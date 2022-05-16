package com.elo7.probes.form;

import com.elo7.probes.domain.Region;
import com.elo7.probes.domain.Shape;

public class RegionForm {
    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Region convertToRegion() {
        return new Region(shape);
    }
}
