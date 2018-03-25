package com.example.demo.validation;

import com.example.demo.api.Rectangle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RectangleValidator implements ConstraintValidator<ValidRectangle, Rectangle> {
    @Override
    public void initialize(ValidRectangle constraintAnnotation) {

    }

    @Override
    public boolean isValid(Rectangle rectangle, ConstraintValidatorContext constraintValidatorContext) {
        double a = rectangle.getA();
        double b = rectangle.getB();
        if (a < 1 && b < 1) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("I hate small rectangles").addConstraintViolation();
            return false;
        }
        return true;
    }
}
