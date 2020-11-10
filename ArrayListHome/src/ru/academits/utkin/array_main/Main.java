package ru.academits.utkin.array_main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> numbersList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome/src/ru/academits/utkin/array_main/input.txt"))) {
            while (scanner.hasNextInt()) {
                numbersList.add(scanner.nextInt());
            }

            System.out.println(numbersList);
        }

        for (int i = 0; i < numbersList.size(); ++i) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
                i--;
            }
        }

        System.out.println(numbersList);

        ArrayList<Integer> withOutClonesList = new ArrayList<>();
        for (int x : numbersList) {
            boolean hasClones = withOutClonesList.contains(x);
            if (!hasClones) {
                withOutClonesList.add(x);
            }
        }

        System.out.println(withOutClonesList);
    }
}



