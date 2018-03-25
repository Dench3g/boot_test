package com.example.demo.api;

import com.example.demo.validation.ValidRectangle;


@ValidRectangle
public class Rectangle {

    @javax.validation.constraints.DecimalMin("0")
    private double a;
    @javax.validation.constraints.DecimalMin("0")
    private double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
