package ru.academits.utkin.shapes;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getWidthEitherHeight(double coordinate1, double coordinate2, double coordinate3) {
        double max = Math.max(coordinate1, coordinate2);
        double maximum = Math.max(max, coordinate3);
        double min = Math.min(coordinate1, coordinate2);
        double minimum = Math.min(min, coordinate3);

        return maximum - minimum;
    }

    public double getLengthSide(double X1, double X2, double Y1, double Y2) {
        return Math.sqrt(Math.pow(X1 - X2, 2) + Math.pow(Y1 - Y2, 2));
    }

    @Override
    public double getWidth() {
        return getWidthEitherHeight(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getWidthEitherHeight(y1, y2, y3);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    @Override
    public double getPerimeter() {
        return getLengthSide(x1, x2, y1, y2) + getLengthSide(x2, x3, y2, y3) + getLengthSide(x1, x3, y1, y3);
    }

    @Override
    public String toString() {
        return "[Треугольник площадью " + getArea() + " c периметром = " + getPerimeter() + ", высотой = " + getHeight() + ", шириной = " + getWidth() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }

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