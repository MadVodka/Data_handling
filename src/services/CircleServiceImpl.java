package services;

import entity.Circle;

import java.math.BigDecimal;

public class CircleServiceImpl implements CircleService {
    @Override
    public BigDecimal square(Circle circle) {
        double radius = circle.getRadius();

        BigDecimal radiusDecimal = new BigDecimal(radius);
        BigDecimal piDecimal = new BigDecimal(Math.PI);
        return radiusDecimal.pow(2).multiply(piDecimal).setScale(50, BigDecimal.ROUND_DOWN);
    }
}
