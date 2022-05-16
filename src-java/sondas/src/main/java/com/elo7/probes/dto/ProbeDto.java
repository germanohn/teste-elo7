package com.elo7.probes.dto;

import com.elo7.probes.domain.Direction;
import com.elo7.probes.domain.Probe;

public class ProbeDto {

    private int id;
    private double x;
    private double y;
    private Direction direction;

    public ProbeDto(Probe probe) {
        this.id = probe.getId();
        this.x = probe.getOrientedPosition().getPosition().getX();
        this.y = probe.getOrientedPosition().getPosition().getY();
        this.direction = probe.getOrientedPosition().getDirection();
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
