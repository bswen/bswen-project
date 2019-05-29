package regex;

import java.util.regex.Pattern;

/**
 * Created by zhaocaiwen on 2017/11/1.
 */
public class TestRegex2 {
    public static void main(String[] args) {
        String pattern = "^(.*) is the Balance.*";
        Pattern ptn = Pattern.compile(pattern);
        System.out.println(ptn.matcher("21232.0 is the Balance, check it.").matches());
    }
}
