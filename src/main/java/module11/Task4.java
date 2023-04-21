package module11;

import java.util.stream.Stream;

public class Task4 {

    public static Stream<Long> linearCongruentGenerator(long a, long c, long m){
        return Stream.iterate(1L, x -> (a * x + c) % m);
    }
}
