package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    void testAddStudent() {
        ClassNoteBook classNoteBook = new ClassNoteBook();
        Student first = new Student(2, "bbb");
        Student second = new Student(52, "fff");
        Student third = new Student(200, "sss");

        classNoteBook.addStudent(second);
        classNoteBook.addStudent(third);
        classNoteBook.addStudent(first);

        assertEquals(3, classNoteBook.data.size());
    }

    @Test
    void testAddMark() {
        ClassNoteBook classNoteBook = new ClassNoteBook();
        Student first = new Student(2, "bbb");
        Student second = new Student(52, "fff");
        Student third = new Student(200, "sss");

        classNoteBook.addStudent(second);
        classNoteBook.addStudent(third);
        classNoteBook.addStudent(first);

        classNoteBook.addMark(200, 4);
        classNoteBook.addMark(200, 1);

        assertTrue(classNoteBook.data.containsValue(Arrays.asList(4, 1)));
    }

}