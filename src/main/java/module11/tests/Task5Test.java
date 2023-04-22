package module11.tests;

import module11.Task5;

import java.util.stream.Stream;

public class Task5Test {
    public static void main(String[] args) {
        Stream<String> st1 = Stream.of("Ivan", "Nick", "Sem", "Peter", "Max", "Liza");
        Stream<String> st2 = Stream.of("Piddubnyi", "Poulson", "Grek", "Maslou");

        Task5.zip(st1, st2).forEach(System.out::println);
    }
}
