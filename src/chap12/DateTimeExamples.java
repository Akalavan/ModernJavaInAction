package chap12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Вагин Михаил
 * date 20.07.2022
 */
public class DateTimeExamples {

    private static final ThreadLocal<DateFormat> formatters = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy"));

    public static void main(String[] args) {
        useOldDate();
        useLocalDate();
    }

    private static void useOldDate() {
        Date date = new Date(114, 2, 18);
        System.out.println(date);

        System.out.println(formatters.get().format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, Calendar.FEBRUARY, 18);
        System.out.println(calendar);
    }

    private static void useLocalDate() {
        LocalDate date = LocalDate.of(2017, 9, 21);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        System.out.println(date);

        int y = date.get(ChronoField.YEAR);
        int m = date.get(ChronoField.MONTH_OF_YEAR);
        int d = date.get(ChronoField.DAY_OF_MONTH);

        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println(time);

        LocalDate dateParse = LocalDate.parse("2017-09-21");
        LocalTime timeParse = LocalTime.parse("13:45:20");

        LocalDateTime dt1 = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt1);

        LocalDate date1 = dt1.toLocalDate();
        System.out.println(date1);
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(time1);

        Instant i1 = Instant.ofEpochSecond(3);
        Instant i2 = Instant.ofEpochSecond(3, 0);
        Instant i3 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant i4 = Instant.ofEpochSecond(4, -1_000_000_000);

        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
        Instant now = Instant.now();

        System.out.println(i1.equals(i2) && i2.equals(i3) && i3.equals(i4));

        Duration d1 = Duration.between(time, time1);
        Duration d2 = Duration.between(LocalTime.of(13, 45, 10), time1);
        Duration d3 = Duration.between(dt1, dt2);
        Duration d4 = Duration.between(instant, now);
        System.out.println(d1.getSeconds());
        System.out.println(d4.getSeconds());

        Period tenDays = Period.between(
                LocalDate.of(2017, 9, 11),
                LocalDate.of(2017, 9, 21)
        );
        System.out.println(tenDays);

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println(threeMinutes1);
    }
}
