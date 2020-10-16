package ru.academits.utkin.range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(2, 5);
        Range range2 = new Range(2, 5);

        double rangeNumber = 3;

        Range intersectionRange = range1.getRangeIntersection(range2);
        Range[] unionRange = range1.getRangeUnion(range2);
        Range[] remainderRange = range1.getRangeRemainder(range2);

        System.out.printf(" Длина диапазона 1 = %.1f;%n Длина диапазона 2 = %.1f.%n", range1.getRangeLength(), range2.getRangeLength());
        System.out.printf("Число %.1f входит в диапазон 1 = %S, входит в диапазон 2 = %S%n", rangeNumber, range1.isInside(rangeNumber), range2.isInside(rangeNumber));


        if (intersectionRange == null) {
            System.out.println("NULL, пересечений нет");
        } else {
            System.out.println("Пересечение диапазонов даёт: " + intersectionRange.getFrom() + " - " + intersectionRange.getTo());
        }

        if (remainderRange == null) {
            System.out.println("NULL, пересечений нет, результата объединения не существует");
        } else {
            for (int i = 0; i < remainderRange.length; ++i) {
                if (remainderRange.length == 1) {
                    System.out.println(remainderRange[i].getFrom() + " _- " + remainderRange[i].getTo());
                } else if (remainderRange.length == 2) {
                    System.out.println("Разница (интервал 1 - интервал 2) даёт интервал 1: " + "[" + remainderRange[0].getFrom() + " - " + remainderRange[0].getTo() + "]");
                    System.out.println("и интервал 2: [" + remainderRange[1].getFrom() + " - " + remainderRange[1].getTo() + "]");
                    break;
                } else if (remainderRange.length == 3) {
                    System.out.println("Разница (интервал 1 - интервал 2) даёт - Пустое множество");
                    break;
                } else {
                    System.out.println("Разность = 0");
                }
            }
        }

        for (int i = 0; i < unionRange.length; ++i) {
            if (unionRange.length < 2) {
                System.out.println("Объединение диапазонов даёт: " + unionRange[i].getFrom() + " - " + unionRange[i].getTo());
            } else {
                System.out.println("Объединение диапазонов даёт интервал 1: " + unionRange[0].getFrom() + " - " + unionRange[0].getTo());
                System.out.println("и интервал 2: " + unionRange[1].getFrom() + " - " + unionRange[1].getTo());

                break;
            }
        }
    }
}