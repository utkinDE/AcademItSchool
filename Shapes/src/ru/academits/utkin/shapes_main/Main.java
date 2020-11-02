package ru.academits.utkin.shapes_main;

import ru.academits.utkin.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(2);
        Square square2 = new Square(1);

        Rectangle rectangle1 = new Rectangle(3, 2);
        Rectangle rectangle2 = new Rectangle(1, 2);

        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(2);

        Triangle triangle1 = new Triangle(3, 6, 2, 8, 5, 4);
        Triangle triangle2 = new Triangle(-2, 6, 0, 4, 7, 9);

        Shape[] arrayShapes = new Shape[]{square1, square2, rectangle1, rectangle2, triangle1, triangle2, circle1, circle2};
        Arrays.sort(arrayShapes, new AreaComparator());

        System.out.println("Фигура с максимальной площадью это " + arrayShapes[arrayShapes.length - 1]); //Неявный вызов toString

        Arrays.sort(arrayShapes, new PerimeterComparator());

        System.out.println("Фигура со вторым по величине периметром это " + arrayShapes[arrayShapes.length - 2]); //Неявный вызов toString
    }
}