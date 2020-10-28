package ru.academits.utkin.main;

import ru.academits.utkin.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(3.5, 5);
        Range range2 = new Range(3, 4);

        double rangeNumber = 3;

        Range intersectionRange = range1.getIntersection(range2);
        Range[] unionRange = range1.getUnion(range2);
        Range[] remainderRange = range1.getDifference(range2);

        System.out.printf(" Длина диапазона 1 = %.1f;%n Длина диапазона 2 = %.1f.%n", range1.getLength(), range2.getLength());
        System.out.printf("Число %.1f входит в диапазон 1 = %S, входит в диапазон 2 = %S%n", rangeNumber, range1.isInside(rangeNumber), range2.isInside(rangeNumber));

        if (intersectionRange == null) {
            System.out.println("NULL, пересечений нет");
        } else {
            System.out.println("Пересечение диапазонов даёт: " + intersectionRange.getFrom() + " - " + intersectionRange.getTo());
        }

        if (remainderRange == null) {
            System.out.println("NULL, пересечений нет, результат разности не может быть выдан");
        } else {
            for (int i = 0; i <= remainderRange.length; ++i) {
                if (remainderRange.length == 1) {
                    System.out.println("Разница (интервал 1 - интервал 2) даёт интервал: " + remainderRange[i].getFrom() + " - " + remainderRange[i].getTo());
                    break;
                }
                if (remainderRange.length == 2) {
                    System.out.println("Разница (интервал 1 - интервал 2) даёт интервал 1: " + "[" + remainderRange[0].getFrom() + " - " + remainderRange[0].getTo() + "]");
                    System.out.println("и интервал 2: [" + remainderRange[1].getFrom() + " - " + remainderRange[1].getTo() + "]");
                    break;
                }
                if (remainderRange.length == 0) {
                    System.out.println("Разница (интервал 1 - интервал 2) даёт - ноль");
                    break;
                }
            }
        }

        for (Range range : unionRange) {
            if (unionRange.length < 2) {
                System.out.println("Объединение диапазонов даёт: " + range.getFrom() + " - " + range.getTo());
            } else {
                System.out.println("Объединение диапазонов даёт интервал 1: " + unionRange[0].getFrom() + " - " + unionRange[0].getTo());
                System.out.println("и интервал 2: " + unionRange[1].getFrom() + " - " + unionRange[1].getTo());
                break;
            }
        }
    }
}