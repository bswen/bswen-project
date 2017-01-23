package streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xxx on 2017-1-23.
 *
 * @author xxx
 */
public class MainForFilter {
    public static void main(String[] args) {
        List<Integer> numbers = constructList();
        numbers.stream()
                .filter(i->i%2==0)
                //.distinct()
                .forEach(i-> System.out.println(i));
    }

    private static List<Integer> constructList() {
        return Arrays.asList(1,2,3,4,4,5,8,9,9,10,10);
    }
}
