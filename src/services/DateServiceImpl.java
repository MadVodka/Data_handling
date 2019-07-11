package services;

import entity.Date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateServiceImpl implements DateService {
    @Override
    public long calculateAge(Date date, ChronoUnit chronoUnit) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime birthdayDayTime = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(),
                date.getHour(), date.getMinute());
//        Duration duration = Duration.between(birthdayDayTime, nowDateTime);
        return chronoUnit.between(birthdayDayTime, nowDateTime);
    }
}
