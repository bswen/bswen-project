package lambdas;

import java.util.function.Predicate;

/**
 * Created by www.bswen.com on 2017-1-17.
 *
 * @author www.bswen.com
 */
public class LambdaAndExceptions {
    public static void main2(String[] args) {
        Predicate<String> notEmpty = (String s)->!s.isEmpty();
        System.out.println(checkString(notEmpty,"test"));
        System.out.println(checkString(notEmpty,""));
        //System.out.println(checkString(notEmpty,null));
    }

    public static void main(String[] args) {
        Predicate<String> notEmpty = (String s) -> {
            try {
                return !isEmpty(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        };
        System.out.println(checkString(notEmpty,"test"));
        System.out.println(checkString(notEmpty,""));
        //System.out.println(checkString(notEmpty,null));
    }

    private static boolean isEmpty(String s) throws Exception {
        if(s==null) throw new Exception("null");
        return s.isEmpty();
    }

    private static boolean checkString(Predicate<String> predict,
                                      String theRealString) {
        return predict.test(theRealString);
    }
}
