package day02;

import java.util.Arrays;

public class QuizManager {

    public static void main(String[] args) {
        QuizLogic ql = new QuizLogic();
        ql.fileReader();
        System.out.println(ql.getResults());
        System.out.println(ql.getSolutions());
        System.out.println(ql.isCorrect("AB123", 2));
        System.out.println(ql.getWinnerID());
    }
}
