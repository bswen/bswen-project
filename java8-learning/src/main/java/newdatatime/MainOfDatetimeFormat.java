package newdatatime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by zhaocaiwen on 2017/3/9.
 */
public class MainOfDatetimeFormat {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(formatter.format(now));

        LocalDateTime date = LocalDateTime.parse("2017-03-09 16:12:14",formatter);
        System.out.println(date);
    }
}
