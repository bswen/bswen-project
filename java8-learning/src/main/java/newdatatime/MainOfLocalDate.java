package newdatatime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * Created by zhaocaiwen on 2017/3/7.
 */
public class MainOfLocalDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2017,3,7);
        //date = LocalDate.now();
        //year 2017, month 3,day 7 dayOfWeek 2, lenOfMonth 31, isLeap:false
        System.out.println(String.format("year %d, month %d,day %d" +
                " dayOfWeek %d, lenOfMonth %d, isLeap:%b",
                date.getYear(),date.getMonth().getValue(),date.getDayOfMonth(),
                date.getDayOfWeek().getValue(),date.lengthOfMonth(),date.isLeapYear()));

        System.out.println("using ChronoField");
        System.out.println(String.format("year %d, month %d,day %d dayOfWeek %d",
                date.get(ChronoField.YEAR),date.get(ChronoField.MONTH_OF_YEAR),
                date.get(ChronoField.DAY_OF_MONTH),
                date.get(ChronoField.DAY_OF_WEEK)));
    }
}
