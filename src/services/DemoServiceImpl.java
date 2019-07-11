package services;

import entity.Date;

import java.time.temporal.ChronoUnit;

public class DemoServiceImpl implements DemoService {
    private DateService dateService = new DateServiceImpl();

    @Override
    public void run() {
        showAge();
    }

    private void showAge() {
        Date date = new Date(24, 5, 1993, 2, 15);
        long years = dateService.calculateAge(date, ChronoUnit.YEARS);
        long months = dateService.calculateAge(date, ChronoUnit.MONTHS);
        long days = dateService.calculateAge(date, ChronoUnit.DAYS);
        long hours = dateService.calculateAge(date, ChronoUnit.HOURS);
        long minutes = dateService.calculateAge(date, ChronoUnit.MINUTES);
        long seconds = dateService.calculateAge(date, ChronoUnit.SECONDS);
        System.out.printf("Age in years: %d; months: %d; days: %d; hours: %d; minutes: %d; seconds: %d",
                years, months, days, hours, minutes, seconds);
    }
}
