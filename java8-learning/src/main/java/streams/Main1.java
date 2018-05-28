package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by on 2017-1-19.
 *
 * @author ddd
 */
public class Main1 {
    public static void main(String[] args) {
        List<String> titles = Arrays.asList("Java7","Java8","Java9");
        Stream<String> s = titles.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }
}
