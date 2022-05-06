package com.elo7.probes.domain;

public class Position {
    private double x;
    private double y;

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void printPosition() {
        System.out.print(this.getX() + " " + this.getY());
    }
}
