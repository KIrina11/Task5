package ru.vsu.cs.kislova_i_v;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int size = readRhombusSize();

        printRhombus(size);
    }

    private static int readRhombusSize() {
        System.out.print("Input rhombus size: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();            //ввод размера ромба

        if (size < 2 || size % 2 != 0) { //проверка размера на соответствие условию задачи
            System.out.println("The program only works with even "
                    + "numbers greater than or equal to 2");
            return readRhombusSize();
        }
        return size;
    }

    private static void printRhombus(int size) {
        int slash = size - (size - 1); //количество слэшей в строке
        int gap = size - size / 2 - 1;  //количество пробелов в строке
        if (size == 2) {
            gap = 1;
        }

        printFirstLine(gap, slash);

        if (size != 2) {                                //если s = 2 эти действия не нужны
            printIntermediatePart1(slash, gap, size);

            printCentralPart(slash, size);

            printIntermediatePart2(slash, gap, size);
        }

        printLastLine(gap, slash);
    }

    private static void printFirstLine(int gap, int slash) {
        for (int i = 0; i < gap; i++) {
            System.out.print(' ');
        }

        for (int z = 0; z < slash; z++) {
            System.out.print('/');
        }

        for (int x = 0; x < slash; x++) {
            System.out.print('\\');
        }

        for (int j = 0; j < gap; j++) {
            System.out.print(' ');
        }

        System.out.println();
    }

    private static void printIntermediatePart1(int slash, int gap, int size) {
        for (int a = 0; a < size / 2 - 2; a++) {
            slash++;
            gap--;

            printFirstLine(gap, slash);
        }
    }

    private static void printCentralPart(int slash, int size) {
        slash = size / 2;

        for (int i = 0; i < slash; i++) {
            System.out.print('/');
        }

        for (int j = 0; j < slash; j++) {
            System.out.print('\\');
        }

        System.out.println();

        for (int x = 0; x < slash; x++) {
            System.out.print('\\');
        }

        for (int z = 0; z < slash; z++) {
            System.out.print('/');
        }

        System.out.println();
    }

    private static void printIntermediatePart2(int slash, int gap, int size) {
        for (int a = 0; a < size / 2 - 2; a++) {
            if (size == 4) {
                printLastLine(gap, slash);

                slash--;
                gap++;
            }
            
            if (size == 6) {
                printLastLine(gap - 1, slash + 1);

                slash--;
                gap++;
            } else {
                printLastLine(gap - (size - size / 2 - 2), slash + size / 2 - 2);

                slash--;
                gap++;
            }
        }
    }

    private static void printLastLine(int gap, int slash) {
        for (int y = 0; y < gap; y++) {
            System.out.print(' ');
        }

        for (int f = 0; f < slash; f++) {
            System.out.print('\\');
        }

        for (int m = 0; m < slash; m++) {
            System.out.print('/');
        }

        for (int n = 0; n < gap; n++) {
            System.out.print(' ');
        }

        System.out.println();
    }
}
