package com.elo7.probes.domain;

public class Rectangle implements Shape {
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private static final String name = "rectangle";

    public Rectangle() {

    }

    public Rectangle(double minX, double maxX, double minY, double maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public String getName() {
        return Rectangle.name;
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    @Override
    public boolean isPositionInside(Position position) {
        return this.isXCoordinateValid(position.getX()) &&
                this.isYCoordinateValid(position.getY());
    }

    /**
     * Test if the x-coordinate will lie within the boundaries of the
     * "Rectangle" in x-axis.
     *
     * @param  x the x-coordinate to be tested
     * @return   <code>true</code> if the x-coordinate lies within the
     *           boundaries of the "Rectangle" x-axis;
     *           <code>false</code> otherwise.
     */
    private boolean isXCoordinateValid(double x) {
        return x >= this.minX && x <= this.maxX;
    }

    /**
     * Test if the y-coordinate will lie within the boundaries of the
     * "Rectangle" in the y-axis.
     *
     * @param  y the y-coordinate to be tested
     * @return   <code>true</code> if the y-coordinate lies within the
     *           boundaries of the "Rectangle" y-axis;
     *           <code>false</code> otherwise.
     */
    private boolean isYCoordinateValid(double y) {
        return y >= this.minY && y <= this.maxY;
    }
}
