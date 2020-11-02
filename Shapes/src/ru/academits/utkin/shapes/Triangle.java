package ru.academits.utkin.shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        double max = Math.max(x1, x2);

        return Math.max(max, x3);
    }

    @Override
    public double getHeight() {
        double min = Math.min(y1, y2);

        return Math.min(min, y3);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    @Override
    public double getPerimeter() {
        double side1 = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
        double side2 = Math.sqrt(Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));
        double side3 = Math.sqrt(Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));

        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "треугольник c площадью" + " " + getArea() + " и периметром = " + getPerimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Triangle triangle = (Triangle) o;

        return x1 == triangle.x1 && x2 == triangle.x2 && x3 == triangle.x3 && y1 == triangle.y1 && y2 == triangle.y2 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 43;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);

        return hash;
    }
}