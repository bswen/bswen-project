package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created on 2019/9/16.
 *
 */
public class InfoExtractor {
    /**
     * extract url from a string.
     * @param s
     * @return
     */
    public static String extractUrl(String s) {
        Matcher matcher = Patterns.WEB_URL.matcher(s);
        if (matcher.find()){
            return matcher.group();
        }
        return null;
    }

    public static String extractIp(String s) {
        Matcher matcher = Patterns.IP_ADDRESS.matcher(s);
        if (matcher.find()){
            return matcher.group();
        }
        return null;
    }

    public static String extractEmail(String s) {
        Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(s);
        if (matcher.find()){
            return matcher.group();
        }
        return null;
    }

    public static List<String> extractUrlIntoParts(String s) {
        Matcher matcher = Patterns.WEB_URL.matcher(s);
        if (matcher.find()){
            int count = matcher.groupCount();
            List<String> result = new ArrayList<>();
            if(count>0) {
                for(int i=0;i<count;i++) {
                    result.add(matcher.group(i));
                }
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String data = "#Let's start doing this job…… http://v.douyin.com/eUWYth?a=1&b=2 copy this url " +
                "to 1.2.3.4 and bswenapp@gmail.com, let's enjoy！";
        System.out.println("url is:"+extractUrl(data));
        System.out.println("ip is:"+extractIp(data));
        System.out.println("email is:"+extractEmail(data));
    }
}
