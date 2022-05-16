package com.elo7.probes.form;

import com.elo7.probes.domain.Direction;
import com.elo7.probes.domain.OrientedPosition;
import com.elo7.probes.domain.Position;
import com.elo7.probes.domain.Probe;

public class ProbeForm {

    private double x;
    private double y;
    private Direction direction;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Probe convertToProbe() {
        return new Probe(new OrientedPosition(new Position(x, y), direction));
    }
}
