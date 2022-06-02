package com.elo7.probes.dto;

import com.elo7.probes.domain.Circle;
import com.elo7.probes.domain.Position;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CircleDto implements ShapeDto {
    @NotNull
    private Double xCentre;
    @NotNull
    private Double yCentre;
    @NotNull @Positive
    private Double radius;

    public CircleDto() {

    }

    public CircleDto(Circle circle) {
        this.xCentre = circle.getCentre().getX();
        this.yCentre = circle.getCentre().getY();
        this.radius = circle.getRadius();
    }

    public Double getxCentre() {
        return xCentre;
    }

    public void setxCentre(Double xCentre) {
        this.xCentre = xCentre;
    }

    public Double getyCentre() {
        return yCentre;
    }

    public void setyCentre(Double yCentre) {
        this.yCentre = yCentre;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Circle convertToShape() {
        return new Circle(new Position(xCentre, yCentre), radius);
    }
}
