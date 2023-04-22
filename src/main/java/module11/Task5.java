package module11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();

        List<T> res = new ArrayList<>();

        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()){
            res.add(iteratorFirst.next());
            res.add(iteratorSecond.next());
        }

        return res.stream();

    }
}
