package com.elo7.probes.domain;

import java.util.HashMap;

public class Region {
    private int id;
    private Shape shape;
    private HashMap<Position, PositionStatus> positionStatus;

    public Region() {

    }

    public Region(int id, Shape shape) {
        this.id = id;
        this.shape = shape;
    }

    public Region(int id, Shape shape, HashMap<Position, PositionStatus> positionStatus) {
        this.id = id;
        this.shape = shape;
        this.positionStatus = positionStatus;
    }

    public void changeShape(Shape shape) {
        this.shape = shape;
    }

    public boolean isPositionFree(Position position) {
        return PositionStatus.F.equals(positionStatus.get(position));
    }
}
