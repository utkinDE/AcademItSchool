package ru.academits.utkin.range_main;

import ru.academits.utkin.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(2, 5);
        Range range2 = new Range(3, 7);
        double rangeNumber = 3;

        System.out.printf("Длина диапазона 1 = %.2f;%nДлина диапазона 2 = %.2f.%n", range1.getLength(), range2.getLength());
        System.out.printf("Число %.2f входит в диапазон 1 = %S, входит в диапазон 2 = %S%n", rangeNumber, range1.isInside(rangeNumber), range2.isInside(rangeNumber));

        Range intersection = range1.getIntersection(range2);
        if (intersection == null) {
            System.out.println("NULL, пересечений нет");
        } else {

            System.out.print("Пересечение диапазонов даёт: ");
            intersection.print();
        }

        Range[] difference = range1.getDifference(range2);
        if (difference.length == 0) {
            System.out.print("Разница диапазонов даёт ноль.");
        } else {
            for (Range range : difference) {
                range.print();
            }
        }

        Range[] union = range1.getUnion(range2);
        System.out.print("Объединение диапазонов даёт: ");

        for (Range range : union) {
            range.print();
        }
    }
}