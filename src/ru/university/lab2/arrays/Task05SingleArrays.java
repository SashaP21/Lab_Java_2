package ru.university.lab2.arrays;

import java.util.Arrays;
import java.util.Random;

public class Task05SingleArrays {

    public void run() {
        int[] numbers = createRandomArray(10);
        printMinMaxAverage(numbers);
        sortAndPrint(numbers);
        compareArrays();
    }

    private int[] createRandomArray(int size) {
        System.out.println("1. Случайный массив из " + size + " чисел");
        if (size <= 0)
            return new int[0];

        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++)
            array[i] = random.nextInt(100);
        return array;
    }

    private void printMinMaxAverage(int[] array) {
        System.out.println("2. Минимум, максимум, среднее");
        if (array.length == 0) {
            return;
        }
        System.out.println("Минимум: " + findMin(array));
        System.out.println("Максимум: " + findMax(array));
        System.out.println("Среднее арифметическое: " + calcAverage(array));
    }

    private int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private double calcAverage(int[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / array.length;
    }

    private void sortAndPrint(int[] array) {
        System.out.println("3. Сортировка пузырьком");
        if (array.length == 0)
            return;
        System.out.println("До: ");
        printArray(array);
        bubbleSort(array);
        System.out.println("После: ");
        printArray(array);
    }

    private void bubbleSort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private void compareArrays() {
        System.out.println("4. Сравнение массивов");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        System.out.println("arr1 = ");
        printArray(arr1);
        System.out.println("arr2 = ");
        printArray(arr2);
        System.out.println("arr1 == arr2: " + (arr1 == arr2));
        System.out.println("arr1.equals(arr2): " + (arr1.equals(arr2)));
        System.out.println("Arrays.equals(arr1, arr2): " + Arrays.equals(arr1, arr2));
        // Объяснение:
        // == для ссылочных типов сравнивает ссылки
        // equals() у массивов работает аналогично ==
        // Arrays.equals сравнивает поэлементно
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

}
