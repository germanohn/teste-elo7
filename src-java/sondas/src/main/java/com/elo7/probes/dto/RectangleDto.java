package com.elo7.probes.dto;

import com.elo7.probes.domain.Rectangle;
import com.elo7.probes.validation.ValidRectangleDto;

import javax.validation.constraints.NotNull;

@ValidRectangleDto
public class RectangleDto implements ShapeDto {
    @NotNull
    private Double minX;
    @NotNull
    private Double maxX;
    @NotNull
    private Double minY;
    @NotNull
    private Double maxY;

    public RectangleDto() {
    }

    public RectangleDto(Rectangle rectangle) {
        this.minX = rectangle.getMinX();
        this.maxX = rectangle.getMaxX();
        this.minY = rectangle.getMinY();
        this.maxY = rectangle.getMaxY();
    }

    public Double getMinX() {
        return minX;
    }

    public void setMinX(Double minX) {
        this.minX = minX;
    }

    public Double getMaxX() {
        return maxX;
    }

    public void setMaxX(Double maxX) {
        this.maxX = maxX;
    }

    public Double getMinY() {
        return minY;
    }

    public void setMinY(Double minY) {
        this.minY = minY;
    }

    public Double getMaxY() {
        return maxY;
    }

    public void setMaxY(Double maxY) {
        this.maxY = maxY;
    }

    @Override
    public Rectangle convertToShape() {
        return new Rectangle(minX, maxX, minY, maxY);
    }
}
