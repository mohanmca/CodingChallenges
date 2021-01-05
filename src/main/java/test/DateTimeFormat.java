package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.Calendar;

public class DateTimeFormat {

    public static void main(String[] args) {
        var date = LocalDate.of(2020,12,31);
        System.out.println(DateTimeFormatter.ISO_WEEK_DATE.format(date));;
        var formatter = DateTimeFormatter.ofPattern("dd-MMM-YYYY");
        System.out.println(date.get(IsoFields.WEEK_BASED_YEAR));
        System.out.println(date.get(IsoFields.WEEK_BASED_YEAR));
        System.out.println(formatter.format(date));;
        System.out.println(formatter.format(date));;
    }
}
