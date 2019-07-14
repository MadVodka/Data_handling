package services;

import entity.Date;

import java.time.temporal.ChronoUnit;

public interface DateService {
    long calculateAge(Date date, ChronoUnit chronoUnit);

    long dayDifferenceBetweenDates(String date1, String date2, String dateTimePattern);

    String convertDate(String date, String oldPattern, String newPattern);

    String convertDateWithTimeZone(String date, String newPattern, String timeZone);
}
