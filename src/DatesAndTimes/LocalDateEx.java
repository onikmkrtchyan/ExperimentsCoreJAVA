package DatesAndTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateEx {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        LocalDate tomorrow = date.plusDays(1);

        ZoneId zoneYerevan = ZoneId.of("Asia/Yerevan");
        ZoneId zoneTokyo = ZoneId.of("Asia/Tokyo");
        LocalDateTime currentDateTimeYerevan = LocalDateTime.now(zoneYerevan);
        LocalDateTime currentDateTimeTokyo = LocalDateTime.now(zoneTokyo);

        System.out.println("Today date:     " + date);
        System.out.println("Yesterday date: " + yesterday);
        System.out.println("Tomorrow date:  " + tomorrow);
        System.out.println("-----------------------------------");
        System.out.println("Yerevan " + currentDateTimeYerevan);
        System.out.println("Tokyo   " + currentDateTimeTokyo);
        System.out.println("Difference is " + (currentDateTimeTokyo.getHour()-currentDateTimeYerevan.getHour()) + " hour(s):");
//        System.out.println("and " + (currentDateTimeTokyo.getDayOfMonth() - currentDateTimeYerevan.getDayOfMonth()));
    }
}