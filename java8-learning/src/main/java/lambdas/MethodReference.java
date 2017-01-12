package lambdas;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by zhaocw on 2017-1-12.
 *
 * @author zhaocw
 */
public class MethodReference {
    public static void main(String[] args) {
        //test method references
        List<Apple> inventory = Arrays.asList(
                new Apple("green",105),
                new Apple("yellow",102)
        );
        inventory.sort(comparing(Apple::getWeight));
        for(Apple apple:inventory) {
            System.out.println(apple);
        }
    }
}
