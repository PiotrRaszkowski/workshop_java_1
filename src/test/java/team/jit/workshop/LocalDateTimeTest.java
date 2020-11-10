package team.jit.workshop;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeTest {

    @Getter
    @Setter
    public class TestClass {
        private LocalDateTime localDateTime;
    }

    @Test
    public void test() {
//        System.out.println(LocalDate.now().plusWeeks(5));
//        System.out.println(LocalDate.of(2015, 3, 20));
//        System.out.println(LocalDate.parse("2020-03-20"));
//
//        System.out.println(LocalTime.now());
//        System.out.println(LocalTime.of(23, 59));
//
//        System.out.println(LocalDateTime.now());
//        System.out.println(LocalDateTime.now().isBefore(LocalDateTime.now().plusYears(2)));
//
//        System.out.println(LocalDate.now().atTime(LocalTime.now()));

        System.out.println(ZoneId.getAvailableZoneIds());

        //LocalDateTime now = LocalDateTime.now();

        //System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));
        //System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM/dd")));

//        System.out.println(ZonedDateTime.of(now, ZoneId.of("Africa/Nairobi")));
//        System.out.println(ZonedDateTime.of(now, ZoneId.of("Europe/Warsaw")));
//
//        LocalTime initialTime = LocalTime.of(18, 0, 0);
//
//        Duration javaTrainingDuration = Duration.ofHours(2);
//
//        System.out.println(initialTime.plus(javaTrainingDuration));
//
//        System.out.println(Period.between(LocalDate.of(2015, 1, 1), LocalDate.now()));

//        System.out.println(LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()));
    }
}
