package module11.tests;

import module11.Task4;

public class Task4Test {
    public static void main(String[] args) {

        Task4.linearCongruentGenerator(25214903917l, 11, (long) Math.pow(2,48))
                .limit(10)
                .forEach(System.out::println);
    }
}
