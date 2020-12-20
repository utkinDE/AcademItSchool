package ru.academits.utkin.array_main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "ArrayListHome/src/ru/academits/utkin/array_main/input.txt";
            System.out.println(getStringsFromFile(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(2, 3, 8, 11, 3, 45, 6, 0));
        deleteEvenNumbers(numbersList);
        System.out.println("Список без чётных элементов: " + numbersList);

        ArrayList<Integer> numbersListWithClones = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        System.out.println("Список без повторяющихся элементов: " + getListWithoutClones(numbersListWithClones));
    }

    public static ArrayList<String> getStringsFromFile(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            ArrayList<String> list = new ArrayList<>();

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            return list;
        }
    }

    public static void deleteEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
    }

    public static ArrayList<Integer> getListWithoutClones(ArrayList<Integer> numbersList) {
        ArrayList<Integer> numbersListWithoutClones = new ArrayList<>(numbersList.size());

        for (Integer number : numbersList) {
            if (!numbersListWithoutClones.contains(number)) {
                numbersListWithoutClones.add(number);
            }
        }

        return numbersListWithoutClones;
    }
}