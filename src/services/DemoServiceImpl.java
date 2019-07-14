package services;

import entity.Circle;
import entity.Date;

import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DemoServiceImpl implements DemoService {
    private DateService dateService = new DateServiceImpl();
    private CircleService circleService = new CircleServiceImpl();

    @Override
    public void run() {
        showAge();
        showDifferenceInDays();
        showConvertedDates();
        showConvertedDateWithTimeZone();
        showSquareCircle();
        showMinAndMaxNumbers();
        showSum();
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
        String date = "Thu, Aug 11, 2016 12:10:56 PM";
        String oldPattern = "E, MMM dd, yyyy hh:mm:ss a";
        String newPatter = "yyyy-MM-dd";
        try {
            String convertedDate = dateService.convertDate(date, oldPattern, newPatter);
            System.out.printf("Date %s was converted to %s%n", date, convertedDate);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            System.out.println("Date can't be parsed");
        }
    }

    private void showConvertedDateWithTimeZone() {
        String date = "2016-08-16T10:15:30+08:00";
        String oldPattern = "yyyy-MM-dd'T'HH:mm:ssXXX";
        String newPatter = "yyyy-MM-dd HH:mm:ss XXX";
        String timeZoneIzhevsk = "+04:00";
        try {
            String convertedDate = dateService.convertDateWithTimeZone(date, oldPattern, newPatter, timeZoneIzhevsk);
            System.out.printf("Date %s was converted to %s at Izhevsk%n", date, convertedDate);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            System.out.println("Date can't be parsed");
        }
    }

    private void showSquareCircle() {
        Circle circle = new Circle(104.54674);
        String square = circleService.square(circle).toPlainString();
        System.out.println("Square of circle is " + square);
    }

    private void showMinAndMaxNumbers() {
        double num1 = 56;
        double num2 = 146;
        double num3 = -89;

        NumberService numberService = new NumberServiceImpl();
        double min = numberService.findMinNumber(num1, num2, num3);
        double max = numberService.findMaxNumber(num1, num2, num3);

        System.out.printf("Min is %.2f and max is %.2f among numbers: %.2f, %.2f, %.2f%n",
                min, max, num1, num2, num3);
    }

    private void showSum() {
        String numbers = "0.23, 1, 1.23";
        NumberService numberService = new NumberServiceImpl();
        boolean result = numberService.isThirdNumberSumOfFirstTwo(numbers);
        System.out.printf("Is third number a sum of first two numbers in a string of %s: %s%n",
                numbers, result ? "yes" : "no");
    }

}
