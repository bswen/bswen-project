package streams;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xxx on 2017-1-23.
 *
 * @author xxx
 */
public class MainForMatch {
    public static void main(String[] args) {
        List<Integer> numbers = constructList();
        System.out.println(numbers.stream().anyMatch(e->e%9==0));
        System.out.println(numbers.stream().anyMatch(e->e%11==0));
        System.out.println(numbers.stream().reduce(0,Integer::sum));
    }

    private static List<Integer> constructList() {
        return Arrays.asList(1,2,3,4,4,5,8,9,9,10,10);
    }
}
