package module11;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {

    public static void showStringToIntSort(String [] array){
        System.out.println(Arrays.stream(array)
                .flatMap(s -> Stream.of(s.trim().split(",")))
                .map(s -> Integer.parseInt(s.trim()))
                        .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
