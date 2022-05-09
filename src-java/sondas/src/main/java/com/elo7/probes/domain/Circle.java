package com.elo7.probes.domain;

public class Circle implements Shape {
    private Position centre;
    private double radius;

    public Circle() {

    }

    public Circle(Position centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    public Position getCentre() {
        return centre;
    }

    public void setCentre(Position centre) {
        this.centre = centre;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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
