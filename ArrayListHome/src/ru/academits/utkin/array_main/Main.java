package ru.academits.utkin.array_main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        try {
            System.out.println(getListFromFile(list));
        } catch (FileNotFoundException exception) {
            System.out.println("Файл не найден!");
        }

        ArrayList<Integer> listNumbers1 = new ArrayList<>(Arrays.asList(2, 3, 8, 11, 3, 45, 6, 0));

        System.out.println("Список без чётных элементов: " + getListOddNumbers(listNumbers1));

        ArrayList<Integer> listNumbers2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));

        System.out.println("Список без повторяющихся элементов: " + getListWithoutClones(listNumbers2));
    }

    public static ArrayList<String> getListFromFile(ArrayList<String> strings) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("ArrayListHome/src/ru/academits/utkin/array_main/input.txt"));

        while (scanner.hasNext()) {
            strings.add(scanner.nextLine());
        }

        return strings;
    }

    public static ArrayList<Integer> getListOddNumbers(ArrayList<Integer> numbers) throws IllegalArgumentException {
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }

        return numbers;
    }

    public static ArrayList<Integer> getListWithoutClones(ArrayList<Integer> numbers) {
        ArrayList<Integer> listWithoutClones = new ArrayList<>(numbers.size());

        for (Integer number : numbers) {
            if (!listWithoutClones.contains(number)) {
                listWithoutClones.add(number);
            }
        }

        return listWithoutClones;
    }
}