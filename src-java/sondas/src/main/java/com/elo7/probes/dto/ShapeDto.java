package com.elo7.probes.dto;

import com.elo7.probes.domain.Circle;
import com.elo7.probes.domain.Rectangle;
import com.elo7.probes.domain.Shape;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        defaultImpl = RectangleDto.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RectangleDto.class, name = "rectangle"),
        @JsonSubTypes.Type(value = CircleDto.class, name = "circle")
})
public interface ShapeDto {
    public static ShapeDto convertFromShape(Shape shape) {
        String type = shape.getName();
        if (type == "circle") {
            return new CircleDto((Circle) shape);
        }
        return new RectangleDto((Rectangle) shape);
    }
    public Shape convertToShape();
}
