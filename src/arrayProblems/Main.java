package arrayProblems;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class Main {
    private static final String DATE_FORMAT = "YYYY-MM-dd'T'HH:mm:ss.SSS";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static void main(String[] args) {
        //Format date time - optional
        System.out.println(formatter.format(ZonedDateTime.now()) + getTimeZoneOffset());
    }

    public static String getTimeZoneOffset() {
        int timeZone = (int) (TimeZone.getTimeZone("America/Chicago").getRawOffset() / (1000 * 60f * 60f) * 100);
        String timeZoneFormatted = timeZone < 0 ? String.format("%05d", timeZone) : String.format("%+05d", timeZone);
        return timeZoneFormatted;
    }
}