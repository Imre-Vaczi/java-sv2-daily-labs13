package day01;

import java.util.*;

public class ClassNoteBook {

    Map<Student, List<Integer>> data = new TreeMap<>();

    public void addStudent(Student student) {
        if (!data.containsKey(student)) {
            data.put(student, new ArrayList<>());
        }
    }

    public void addMark(int id, int mark) {
        Student tempKey = getStudentByID(id);
        List<Integer> tempValue = data.get(tempKey);
        tempValue.add(mark);
        data.put(tempKey, tempValue);
        //data.put(getStudentByID(id), data.get(getStudentByID(id)).add(mark));
    }

    private Student getStudentByID(int id) {
        for (Map.Entry<Student, List<Integer>> entry : data.entrySet()) {
            if (entry.getKey().getId() == id) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("No entry found.");
    }

    @Override
    public String toString() {
        return "ClassNoteBook{" +
                "data=" + data +
                '}';
    }
}
