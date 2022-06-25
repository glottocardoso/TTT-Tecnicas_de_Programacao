package aula01datas;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Datas {
    public static void main(String[] args) {
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);

        System.out.println(LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30));
        System.out.println(LocalDateTime.parse("2015-02-20T06:30:00"));

        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        System.out.println(zoneId);

        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,zoneId);
        System.out.println("ZonedDateTime");
        System.out.println(zonedDateTime);

        ZoneOffset offset = ZoneOffset.of("+02:00");
        OffsetDateTime offSetByTwo = OffsetDateTime .of(localDateTime, offset);
        System.out.println("Offset:");
        System.out.println(offSetByTwo);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        System.out.println("7. ====================================");
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2022-03-13T19:01:45.768149722-03:00");
        System.out.println(offsetDateTime);

        System.out.println("8. ====================================");
        LocalDateTime data1 = LocalDateTime.parse("2022-03-13T19:01:45.768149722");
        LocalDateTime data2 = LocalDateTime.parse("2022-03-13T18:01:45.768149722");

        ZoneOffset offset1 = ZoneOffset.of("-03:00");
        ZoneOffset offset2 = ZoneOffset.of("+03:00");

        OffsetDateTime offsetDateTime1 = data1.atOffset(offset1);
        OffsetDateTime offsetDateTime2 = data2.atOffset(offset2);

        System.out.println("data 1: " + offsetDateTime1);
        System.out.println("data 2: " + offsetDateTime2);

        //Diferença em horas:
        Duration duration = Duration.between(offsetDateTime1,offsetDateTime2);
        long horas = duration.toHours();
        System.out.println(horas);

        //Usando ChronoUnit:
        long chronoUnit = ChronoUnit.HOURS.between(offsetDateTime1,offsetDateTime2);
        System.out.println(chronoUnit);

        System.out.println(offsetDateTime1.until(offsetDateTime2,ChronoUnit.HOURS));

        System.out.println("9. ====================================");
        ZonedDateTime zonedDateTime9 = ZonedDateTime.parse("2022-03-13T20:17:43.936594508Z[Europe/London]");
        System.out.println(zonedDateTime9);
    }
}
