package com.elo7.probes.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidRectangleDtoValidator.class })
@Documented
public @interface ValidRectangleDto {
    String message() default "com.elo7.probes.validation" +
            "ValidRectangleDto.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
