package com.elo7.probes.domain;

import java.util.HashMap;

public class Region {
    private int id;
    private Shape shape;
    private HashMap<Position, PositionStatus> positionStatus = new HashMap<>();

    public Region() {
        System.out.println("Default constructor of Region used");
    }

    public Region(Shape shape) {
        System.out.println("Constructor Region(Shape shape) used");
        this.shape = shape;
        this.positionStatus = new HashMap<>();
    }

    public Region(Shape shape, HashMap<Position, PositionStatus> positionStatus) {
        System.out.println("Constructor Region(Shape shape, ... positionStatus) used");
        this.shape = shape;
        this.positionStatus = positionStatus;
    }

    public Region(int id, Shape shape) {
        System.out.println("Constructor Region(int id, Shape shape) used");
        this.id = id;
        this.shape = shape;
        this.positionStatus = new HashMap<>();
    }

    public Region(int id, Shape shape, HashMap<Position, PositionStatus> positionStatus) {
        System.out.println("Constructor Region(<all parameters>) used");
        this.id = id;
        this.shape = shape;
        this.positionStatus = positionStatus;
    }

    public int getId() {
        return this.id;
    }

    public Shape getShape() {
        return shape;
    }

    public PositionStatus getPositionStatusIn(Position position) {
        return positionStatus.get(position);
    }

    public void freePosition(Position position) {
        this.positionStatus.remove(position);
    }

    public void freeAllPositions() {
        this.positionStatus.clear();
    }

    public void fillPosition(Position position, PositionStatus positionStatus) {
        this.positionStatus.put(position, positionStatus);
    }

    public void changeShape(Shape shape) {
        this.shape = shape;
    }

    public boolean isPositionInside(Position position) {
        return this.shape.isPositionInside(position);
    }

    public boolean isPositionFree(Position position) {
        return !positionStatus.containsKey(position);
    }
}
