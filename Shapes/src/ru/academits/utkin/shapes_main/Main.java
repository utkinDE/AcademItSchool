package ru.academits.utkin.shapes_main;

import ru.academits.utkin.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(2),
                new Square(1),
                new Rectangle(3, 2),
                new Rectangle(1, 2),
                new Circle(5),
                new Circle(2),
                new Triangle(3, 6, 2, 8, 5, 4),
                new Triangle(-2, 6, 0, 4, 7, 9)
        };

        Arrays.sort(shapes, new AreaComparator());

        System.out.println("Фигура с максимальной площадью это " + shapes[shapes.length - 1]); // Неявный вызов toString

        Arrays.sort(shapes, new PerimeterComparator());

        System.out.println("Фигура со вторым по величине периметром это " + shapes[shapes.length - 2]); // Неявный вызов toString

        System.out.println("Список всех фигур: ");
        for (Shape e : shapes) {
            System.out.println(e);
        }
    }
}