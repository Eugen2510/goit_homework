package module11.tests;


import module11.Task2;

import java.util.List;

public class Task2Test {
    public static void main(String[] args) {
        List<String> list = List.of("Ivan", "Peter", "Poll", "Max", "Nicolas", "Eugene", "Olga", "Tetiana");
        System.out.println(Task2.upperCaseReverseSort(list));
    }
}
