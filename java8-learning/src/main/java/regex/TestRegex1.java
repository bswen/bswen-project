package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * .
 * Created by zhaocaiwen on 2017/10/31.
 */
public class TestRegex1 {
    public static void main2(String[] args) {
        String s = "abc\\d*def";
        System.out.println(Pattern.compile(s).matcher("abc1def").matches());

        String s1 = "abc(dynamic_content)def";
        String s2 = s1.replace("(dynamic_content)","(.*)");
        String s3 = ".*"+s2+".*";
        String origin_string = "I am abc123def good.";
        Matcher matcher = Pattern.compile(s3).matcher(origin_string);
        System.out.println(matcher.matches()+","+matcher.group(1));
        //String s3 = Pattern.compile(s2).matcher("I am abc123def here.").replaceAll("***");
        //System.out.println(s3);
        String theValue = matcher.group(1);
        System.out.println(origin_string.replace(theValue, Matcher.quoteReplacement("***")));
    }

    public static void main(String[] args) {
        String origin_string = "CreditAlert!\n" +
                "Acct:208**677\n" +
                "DT:10/31/2017:7:00 PM\n" +
                "NIP CR/DYNAMIC CHERISH SECURITY COM\n" +
                "DR Amt:NGN235,000.00\n" +
                "Bal:852,019.06\n" +
                "REF:201563440";
        //String origin_string = "1212.00 is the Balance. I am waiting ...";
        //String origin_string = "Hi, the Balance is 121212.0, I am waiting ...";
        String key = "(dynamic_content)";
        String userRegex = "Bal:"+key+"\n";//用户输入的替换用的模式
        String regex = parse2Regex(key,userRegex);
        System.out.println("---before---");
        System.out.println(origin_string);

        Matcher matcher = Pattern.compile(regex).matcher(origin_string);
        System.out.println(matcher.matches()+","+matcher.group(1));
        if(matcher.matches()) {
            String theValue = matcher.group(1);
            System.out.println("---after---");
            System.out.println(origin_string.replace(theValue, Matcher.quoteReplacement("***")));
        }else {
            System.out.println("not match");
        }
    }

    private static String parse2Regex(String key,String userRegex) {
        int idxStart = userRegex.indexOf(key);
        int idxEnd = idxStart+key.length();
        String s2 = userRegex.replace("(dynamic_content)", "(.*)");
        String result = "(?s)";//替换后的正则表达式.
        if(idxStart==0) {
            result = result+"^"+s2+".*";
        }else if(idxEnd==userRegex.length()) {
            result = result+".*"+s2+"$";
        }else {
            result = result+".*"+s2+".*";//替换后的正则
        }
        return result;
    }
}
