package services;

import entity.Circle;

public class CircleServiceImpl implements CircleService {
    @Override
    public double square(Circle circle) {
        double radius = circle.getRadius();
        return Math.PI * Math.pow(radius, 2);
    }
}
