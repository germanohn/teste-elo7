package com.elo7.probes.validation;

import com.elo7.probes.dto.RectangleDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidRectangleDtoValidator implements ConstraintValidator<
        ValidRectangleDto, RectangleDto> {

    @Override
    public void initialize(ValidRectangleDto constraintAnnotation) {
    }

    @Override
    public boolean isValid(RectangleDto rectangleDto,
                           ConstraintValidatorContext context) {
        if (rectangleDto == null) {
            return true;
        }

        return (rectangleDto.getMinX() <= rectangleDto.getMaxX()) &&
                (rectangleDto.getMinY() <= rectangleDto.getMaxY());
    }
}
