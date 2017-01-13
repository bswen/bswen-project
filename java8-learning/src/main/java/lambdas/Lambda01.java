package lambdas;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by xx on 2017-1-9.
 *
 * @author xx
 */
public class Lambda01 {

    public static void main98(String[] args) {
        //实现 i>0 and (i<10 || i>50)
        Predicate<Integer>  pi = i->i>0;
        Predicate<Integer>  pi2 = (Integer i)->i<10;
        Predicate<Integer>  pi3 = (Integer i)->i>50;
        System.out.println(pi2.or(pi3).and(pi).test(1));
        System.out.println(pi2.or(pi3).and(pi).test(51));
        System.out.println(pi2.or(pi3).and(pi).test(-1));
        System.out.println(pi2.or(pi3).and(pi).test(20));
        Function<Integer,Boolean> f1 = i->{return i>0;};
        System.out.println(f1.apply(100));
    }
    public static void main99(String[] args) {
        Runnable r = ()->{
            while(true) {
                System.out.println("t");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        };
        (new Thread(r)).start();
    }
}
