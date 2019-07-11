package services;

import entity.Date;

import java.time.temporal.ChronoUnit;

public interface DateService {
    long calculateAge(Date date, ChronoUnit chronoUnit);
}
