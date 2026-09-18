package ru.university.lab2.util;

public class Task07MethodsAndArgs {

    public void run() {
        demonstrateOverloadedPrint();
        demonstrateVarargsSum();
        demonstratePower();
    }

    private void demonstrateOverloadedPrint() {
        System.out.println("1. Перегрузка метода print");
        print(42);              // вызывается print(int)
        print(3.14);            // вызывается print(double)
        print("Hello, Java!");  // вызывается print(String)
        print(new int[]{1, 2, 3}); // вызывается print(int[])
    }

    private void print(int value) {
        System.out.println("print(int) " + value);
    }

    private void print(double value) {
        System.out.println("print(double) " + value);
    }

    private void print(String value) {
        System.out.println("print(String) " + value);
    }

    private void print(int[] array) {
        System.out.print("print(int[]) ");
        if (array.length == 0)
            return;
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0)
                System.out.print(", ");
            System.out.print(array[i]);
        }
        System.out.println("]");
    }

    private void demonstrateVarargsSum() {
        System.out.println("2. Varargs: сумма произвольного числа аргументов");
        System.out.println("sum() = " + sum());
        System.out.println("sum(5) = " + sum(5));
        System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));
        int[] arr = {10, 20, 30};
        System.out.println("sum(new int[]{10, 20, 30}) = " + sum(arr));
    }

    private long sum(int... numbers) {
        long total = 0;
        for (int i = 0; i < numbers.length; i++)
            total += numbers[i];
        return total;
    }

    private void demonstratePower() {
        System.out.println("3. Степень: рекурсия и итерация");
        checkPower(2, 0);
        checkPower(2, 1);
        checkPower(2, 10);
        checkPower(3, 4);

        // Быстрее будет итеративная версия, т.к
        // не тратится время на создание кадров стека, как в рекурсии
    }

    private void checkPower(long base, int exp) {
        long rec = powerRecursive(base, exp);
        long iter = powerIterative(base, exp);
        long expected = (long) Math.pow(base, exp);
        String res = (rec == iter && iter == expected) ? "одинаковы" : "различны";
        System.out.println(base + "^" + exp + ": рекурсия = " + rec
                + ", итерация = " + iter + ", Math.pow = " + expected + " - " + res);
    }

    private long powerIterative(long base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++)
            result *= base;
        return result;
    }

    private long powerRecursive(long base, int exp) {
        if (exp == 0)
            return 1;
        return base * powerRecursive(base, exp - 1);
    }
}
