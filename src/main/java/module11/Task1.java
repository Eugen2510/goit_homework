package module11;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Task1 {
    public static String oddIndicesToString(List<String> list){
        AtomicInteger i = new AtomicInteger(0);
        return list.stream()
                .map(s -> i.getAndIncrement() + ". " + s)
                .filter(s -> i.get() % 2 == 0)
                .collect(Collectors.joining(", "));
    }
}
