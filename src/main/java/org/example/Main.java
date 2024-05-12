package org.example;


import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10000];
        FenwickTree fenwickTree = new FenwickTree(10000);


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }

        System.out.println("Добавление элементов");
        long startTime, endTime;
        startTime = System.nanoTime();
        System.out.println("Количество операций до: " + fenwickTree.getIterations());
        for (int i = 0; i < numbers.length; i++) {
            fenwickTree.add(i + 1, numbers[i]);
        }
        endTime = System.nanoTime();
        System.out.println("Количество операций после: " + fenwickTree.getIterations());
        long addTime = endTime - startTime;
        System.out.println(addTime);
        System.out.println("Среднее значение: " + addTime / 10000);
        System.out.println();

        System.out.println("Поиск");
        System.out.println("Количество операций до: " + fenwickTree.getIterations());
        int[] searchIndexes = new int[100];
        for (int i = 0; i < 100; i++) {
            searchIndexes[i] = random.nextInt(numbers.length) + 1;
        }
        startTime = System.nanoTime();
        for (int index : searchIndexes) {
            fenwickTree.query(index);
        }
        endTime = System.nanoTime();
        System.out.println("Количество операций после: " + fenwickTree.getIterations());
        long searchTime = endTime - startTime;
        System.out.println(searchTime);
        System.out.println("Среднее значение: " + searchTime / 100);
        System.out.println();

        System.out.println("Удаление элементов");
        System.out.println("Количество операций до: " + fenwickTree.getIterations());
        int[] deleteIndexes = new int[1000];
        for (int i = 0; i < 1000; i++) {
            deleteIndexes[i] = random.nextInt(numbers.length) + 1;
        }
        startTime = System.nanoTime();
        for (int index : deleteIndexes) {
            fenwickTree.remove(index, numbers[index - 1]);
        }
        endTime = System.nanoTime();
        System.out.println("Количество операций после: " + fenwickTree.getIterations());
        long deleteTime = endTime - startTime;
        System.out.println(deleteTime);
        System.out.println("Среднее значение: " + deleteTime / 1000);


    }
}