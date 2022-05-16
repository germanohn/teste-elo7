package com.elo7.probes.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Position)) {
            return false;
        }

        Position position = (Position) obj;
        return this.getX() == position.getX() &&
                this.getY() == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void printPosition() {
        System.out.print(this.getX() + " " + this.getY());
    }
}
