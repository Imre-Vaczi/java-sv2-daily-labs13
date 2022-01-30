package day02;

import java.util.Objects;

public class QuizObject implements Comparable<QuizObject>{

    private String id;

    public QuizObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(QuizObject o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizObject that = (QuizObject) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "QuizObject{" +
                "id='" + id + '\'' +
                '}';
    }
}
