package ru.academits.utkin.shapes;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return "[Круг площадью " + getArea() + " c периметром = " + getPerimeter() + ", высотой = " + getHeight() + ", шириной = " + getWidth() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Circle circle = (Circle) o;

        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        final int prime = 41;
        int hash = 1;

        hash = prime * hash + Double.hashCode(radius);

        return hash;
    }
}