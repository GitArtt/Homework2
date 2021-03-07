package ru.geekbrains.homework2;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Homework2 {

        public static void main(String[] args) {

            System.out.print("1)");
            Task1.solutionOne(Task1.array);
            /* Комментарий ко 2 заданию:
            Ввиду своего подхода к структурированию домашней работы и разбития заданий на классы
            хотел бы оставить повествование, почему было предпринято решение в таком выводе снизу.
            Т.к. не смог осуществить метод внутри массива, было предпринято решение осуществить вывод
            извне - из-за чего он получился не совсем лаконичным, но зато без костылей и без лишнего цикла.
            upd. комментарий неактуален, но решил оставить.*/
            System.out.print("\n2)");
            System.out.println(Arrays.toString(Task2.solutionTwo(Task2.array)));
            System.out.print("2.1)");
            Task2_1.solutionTwoV2(new int[8]); //второй вариант второго задания
            System.out.print("\n3)");
            Task3.solutionThree(Task3.array);
            System.out.println("\n4)");
            Task4.solutionFour(new int[5][5]);
            System.out.print("\n5)");
            Task5.solutionFive(Task5.array);
            System.out.print("\n6)");
            System.out.println(Task6.solutionSix(Task6.array));
            System.out.print("\n7)");
            Task7.solutionSeven(Task7.array, Task7.n);
        }
    }

    class Task1 {

        static int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        static void solutionOne(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = 1;
                } else {
                    array[i] = 0;
                }
                System.out.print(array[i] + " ");
            }
        }
    }

    class Task2 {

        static int[] array = new int[8];

        static int[] solutionTwo(int[] array) {         //не смог придумать лучшего решения, из-за чего отказался от вывода внутри метода.
            for (int i = 1; i < array.length; i++) {    //т.к. из-за вывода внутри метода обрезалось крайнее число массива
                array[i] = array[i-1] + 3;
            }
            return array;
        }

    }

    class Task2_1 {

        static void solutionTwoV2(int[] array) {        //upd.
            for (int i = 0; i < array.length; i++) {    //додумался позже. Решил не избавляться от первого варианта решения,
                array[i] = i * 3;                       //т.к. над ним тоже пришлось заморочиться)
                System.out.print(array[i] + " ");
            }
        }

    }

    class Task3 {

        static int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        static void solutionThree(int[] array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] < 6 ? array[i] * 2: array[i];
                System.out.print(array[i] + " ");
            }
        }
    }

    class Task4 {

        static void solutionFour(int[][] array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (i == j || i == array[i].length - (j + 1)) { //сломал голову, если честно. На вторую ночь додумался, как записать логику.
                        array[i][j] = 1;
                    }
                    System.out.print(array[i][j]);
                }
                System.out.println("");
            }
        }
    }

    class Task5 {

        static int[] array = {19, 32, 4, 48, 13, 81, 20, 66, 53, 75};

        static void solutionFive(int[] array) {
            int min = array[0];
            int max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
                if (array[i] > max) {
                    max = array[i];
                }
            }
            System.out.print("Минимум: " + min + ";");
            System.out.println(" Максимум: " + max + "\n");
        }
    }

    class Task6 {

        static int[] array = {2, 2, 2, 2, 1, 2, 10, 1};

        static boolean solutionSix(int[] array) {

            int sum = 0;
            int sumLeftSide = 0;

            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i];
            }

            for (int i = 0; i < array.length; i++) {
                sumLeftSide =  sumLeftSide + array[i];
                if (sumLeftSide == sum / 2) return true;
                if (sumLeftSide > sum / 2) return false;
            }
            return false;
        }
    }

    class Task7 {

    static int n = -2;
    static int[] array = {1, 2, 3};

    static void solutionSeven(int[] array, int n) {
        int move = (array.length + n % array.length) % array.length;

        for (int i = 0; i < move; i++) {
            int memorized = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = memorized;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    }