package practiceAssignment.codility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateDifference {

	public static void calculateDifference(String dateTime1, String dateTime2) {
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime dt1 = LocalDateTime.parse(dateTime1, formatter);
        LocalDateTime dt2 = LocalDateTime.parse(dateTime2, formatter);

        Duration duration = Duration.between(dt1, dt2);

        long days = duration.toDays();
        long hrs = duration.toHours() % 24;
        long mins = duration.toMinutes() % 60;
        long secs = duration.getSeconds() % 60;


        System.out.println("Difference between " + dateTime1 + " and " + dateTime2 + " is:");
        System.out.println(days + " days, " + hrs + " hours, " + mins + " minutes, " + secs + " seconds.");
    }

    public static void main(String[] args) {

        String dateTime1 = "2025-03-25 14:30:00";
        String dateTime2 = "2025-03-27 16:45:30";

        calculateDifference(dateTime1, dateTime2);
    }
}
