package com.elo7.probes.form;

import com.elo7.probes.domain.Direction;
import com.elo7.probes.domain.OrientedPosition;
import com.elo7.probes.domain.Position;
import com.elo7.probes.domain.Probe;

import javax.validation.constraints.NotNull;

public class ProbeForm {
    @NotNull
    private Double x;
    @NotNull
    private Double y;
    @NotNull
    private Direction direction;

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Probe convertToProbe() {
        return new Probe(new OrientedPosition(new Position(x, y), direction));
    }
}
