package com.example.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = RectangleValidator.class)
public @interface ValidRectangle {
    String message() default "Invalid rectangle";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
