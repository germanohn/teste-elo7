package com.elo7.probes.domain;

public class Circle implements Shape {
    private Position centre;
    private double radius;
    private static final String name = "circle";

    public Circle() {

    }

    public Circle(Position centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    public Position getCentre() {
        return centre;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getName() {
        return Circle.name;
    }

    @Override
    public boolean isPositionInside(Position position) {
        return this.distanceFromCentre(position) <= radius;
    }

    private double distanceFromCentre(Position position) {
        return Math.sqrt((position.getX() - centre.getX())
                          * (position.getX() - centre.getX()) +
                         (position.getY() - centre.getY())
        )                 * (position.getY() - centre.getY());
    }
}
