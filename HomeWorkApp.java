package ru.geekbrains.lesson3;

import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {

        changeNumber(); //замена в массиве 0 на 1
        creationArrayNum(); //создание массива от 1 до 100
        checkArrayNum(); //увеличение чисел, которые <6 в два раза
        fillDiagonalArray(); //единицы по диагоналям
        creationArray(9, -5); //создание массива длиной len и инициализация initialValue
        minMaxNumber(); //поиск минимального и максимального значения в массиве


        checkBalance(2, 2, 2, 1, 2, 2, 10, 1); //проверка на наличие места в массиве, где сумма левой части равна правой
        shiftNumber(-2, 1, 2, 3, 4, 5); //сдвиг на num позиций влево или вправо
    }

    private static void changeNumber() {
        int[] array = {0, 1, 1, 0, 1, 1, 0, 0, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    private static void creationArrayNum() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    private static void checkArrayNum() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    private static void fillDiagonalArray() {
        int[][] array = new int[6][6];

        for (int i = 0; i < array.length; i++) {
            array[i][array.length - i - 1] = 1;
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
            }
        }
    }

    private static int[] creationArray(int len, int initialValue) {
        int[] array = new int[len];

        for (int i =  0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    private static void minMaxNumber() {
        int[] array = new int[10];
        Random rand = new Random();

        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(50);
        }

        int arrMin = array[0];
        int arrMax = array[0];

        for(int i = 0; i < array.length; i++) {
            if(arrMin > array[i]) {
                arrMin = array[i];
            }
            if(arrMax < array[i]) {
                arrMax = array[i];
            }
        }
    }

    private static boolean checkBalance(int... array) {
        int sumLeft = array[0] + array[1];
        int count = 2;
        int sumRight = 0;

        for(int i = 2; i < array.length; i++) {
            sumRight = 0;
            int num = 1;
            for(int j = 0; j < array.length - count; j++) {
                sumRight += array[array.length - num];
                num++;
            }

            if(sumLeft == sumRight) {
                return true;
            }

            sumLeft += array[i];
            count++;
        }

        return false;
    }

    private static void shiftNumber(int num, int... array) {
        if (num > 0) {
            for (int i = 0; i < num; i++) { //сдвиг на num позиций вправо
                shiftNumRight(array);
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        if (num < 0) {
            num *= -1;

            for (int i = 0; i < num; i++) { //сдвиг на num позиций влево
                shiftNumLeft(array);
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    private static void shiftNumRight(int... array) {
        int lastNum = array[array.length - 1];

        for (int j = array.length - 1; j > 0; j--) {
            array[j] = array[j - 1];
        }
        array[0] = lastNum;
    }

    private static void shiftNumLeft(int... array) {
        int firstNum = array[0];

        for (int j = 0; j < array.length - 1; j++) {
            array[j] = array[j + 1];
        }
        array[array.length - 1] = firstNum;
    }

}


