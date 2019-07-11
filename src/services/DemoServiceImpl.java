package services;

import entity.Date;

import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DemoServiceImpl implements DemoService {
    private DateService dateService = new DateServiceImpl();

    @Override
    public void run() {
        showAge();
        showDifferenceInDays();
        showConvertedDates();
    }

    private void showAge() {
        Date date = new Date(24, 5, 1993, 2, 15);
        long years = dateService.calculateAge(date, ChronoUnit.YEARS);
        long months = dateService.calculateAge(date, ChronoUnit.MONTHS);
        long days = dateService.calculateAge(date, ChronoUnit.DAYS);
        long hours = dateService.calculateAge(date, ChronoUnit.HOURS);
        long minutes = dateService.calculateAge(date, ChronoUnit.MINUTES);
        long seconds = dateService.calculateAge(date, ChronoUnit.SECONDS);
        System.out.printf("Age in years: %d; months: %d; days: %d; hours: %d; minutes: %d; seconds: %d%n",
                years, months, days, hours, minutes, seconds);
    }

    private void showDifferenceInDays() {
        String day1 = "14.06.1946";
        String day2 = "07.02.1978";
        String datePattern = "dd.MM.yyyy";
        try {
            long days = dateService.dayDifferenceBetweenDates(day1, day2, datePattern);
            System.out.printf("Difference between %s and %s is %d%n", day1, day2, days);
        } catch (DateTimeParseException e) {
            System.out.println("Dates can't be parsed by the given pattern%n");
        }
    }

    private void showConvertedDates() {
        String date = "Friday, Aug 10, 2016 12:10:56 PM";
        String oldPattern = "E, MMM dd, yyyy hh:mm:ss a";
        String newPatter = "yyyy-MM-dd";
        try {
            String convertedDate = dateService.convertDateWithPattern(date, oldPattern, newPatter);
            System.out.printf("Date %s was converted to %s%n", date, convertedDate);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            System.out.println("Date can't be parsed");
        }
    }
}
