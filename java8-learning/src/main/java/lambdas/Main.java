package lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhaocw on 2017-1-6.
 * @author zhaocw
 */
public class Main {
    public static void main(String[] args) {
        List<Apple> all = constructAppleInventory1();
        List<Apple> greeApples = filterApples(all,
                new AppleColorFilter("green"));
        System.out.println("green apples");
        printApples(greeApples);
        List<Apple> hugeApples = filterApples(all,
                new AppleWeightFilter(2));
        System.out.println("big apples");
        printApples(hugeApples);

        List<Apple> redApples = filterApples(all,
                (Apple apple)->"red".equals(apple.getColor()));
        System.out.println("red apples");
        printApples(redApples);

        System.out.println("after sort1");
        //all.sort((Apple a1,Apple a2)->a1.getWeight()-a2.getWeight());
        all.sort((a1,a2)->a1.getWeight()-a2.getWeight());
        printApples(all);
        System.out.println("after sort2");
        all.sort(Comparator.comparing(Apple::getWeight));
        printApples(all);
    }

    private static void printApples(List<Apple> apples) {
        for(Apple apple:apples) {
            System.out.println(apple);
        }
    }

    private static List<Apple> constructAppleInventory1() {
        List<Apple> result = new ArrayList<>();
        result.add(new Apple("green",1));
        result.add(new Apple("yellow",2));
        result.add(new Apple("black",3));
        result.add(new Apple("red",4));
        result.add(new Apple("red",2));
        return result;
    }

    private static List<Apple> filterApples(List<Apple> inventory,
                                            IAppleFilter filter) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory) {
            if(filter.filter(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static <T> List<T> filterApples(List<T> inventory,
                                            IFilter<T> filter) {
        List<T> result = new ArrayList<>();
        for(T t:inventory) {
            if(filter.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
