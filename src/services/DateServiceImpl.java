package services;

import entity.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateServiceImpl implements DateService {
    @Override
    public long calculateAge(Date date, ChronoUnit chronoUnit) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime birthdayDayTime = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(),
                date.getHour(), date.getMinute());
        return chronoUnit.between(birthdayDayTime, nowDateTime);
    }

    @Override
    public long dayDifferenceBetweenDates(String date1, String date2, String dateTimePattern)
            throws DateTimeParseException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);
        LocalDate localDate1 = LocalDate.parse(date1, dateTimeFormatter);
        LocalDate localDate2 = LocalDate.parse(date2, dateTimeFormatter);
        long days = ChronoUnit.DAYS.between(localDate1, localDate2);
        return Math.abs(days);
    }

    @Override
    public String convertDateWithPattern(String date, String oldPattern, String newPattern) throws DateTimeParseException {
//        SimpleDateFormat oldDateFormat = new SimpleDateFormat(oldPattern);
//        SimpleDateFormat newDateFormat = new SimpleDateFormat(newPattern);
//        java.util.Date date1 = oldDateFormat.parse(date);
//        return newDateFormat.format(date1);

        DateTimeFormatter oldDateTimeFormatter = DateTimeFormatter.ofPattern(oldPattern);
        DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern(newPattern);
        LocalDateTime localDateTime = LocalDateTime.parse(date, oldDateTimeFormatter);
        return localDateTime.format(newDateTimeFormatter);

    }
}
