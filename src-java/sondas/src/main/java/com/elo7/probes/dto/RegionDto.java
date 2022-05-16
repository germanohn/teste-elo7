package com.elo7.probes.dto;

import com.elo7.probes.domain.Region;
import com.elo7.probes.domain.Shape;

public class RegionDto {

    private int id;
    private Shape shape;

    public RegionDto(Region region) {
        this.id = region.getId();
        this.shape = region.getShape();
    }

    public Shape getShape() {
        return shape;
    }
}
