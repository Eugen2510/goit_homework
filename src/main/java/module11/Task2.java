package module11;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    public static List<String> upperCaseReverseSort(List<String> list){
        return  list.stream()
                .map(String :: toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

    }
}
