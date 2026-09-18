package ru.university.lab2.numbers;

public class Task02FloatingPoint {

    public void run() {
        demonstrateZeroPointOnePlusZeroPointTwo();
        sumZeroPointOneTenTimes();
        demonstrateEpsilonComparison();
        demonstrateInfinityAndNaN();
        compareRoundingMethods();
        compareFloatAndDouble();
    }

    private void demonstrateZeroPointOnePlusZeroPointTwo() {
        System.out.println("1. 0.1 + 0.2");
        double result = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + result);
        System.out.println("0.1 + 0.2 == 0.3 ? " + (result == 0.3));
        // Объяснение: 0.1 и 0.2 непредставимы точно в двоичной системе.
        // Тип double хранит ближайшие двоичные дроби
    }

    private void sumZeroPointOneTenTimes() {
        System.out.println("2. Сумма 0.1 x 10 и сравнение с 1.0");
        double sum = 0.0;
        for (int i = 0; i < 10; i++) {
            sum += 0.1;
        }
        System.out.println("sum = " + sum);
        System.out.println("sum == 1.0 ? " + (sum == 1.0));
    }

    private void demonstrateEpsilonComparison() {
        System.out.println("3. Сравнение с epsilon");
        double epsilon = 1e-9;
        System.out.println("almostEqual(0.1 + 0.2, 0.3, 1e-9) = " + almostEqual(0.1 + 0.2, 0.3, epsilon));
        System.out.println("almostEqual(1.0, 2.0, 1e-9) = " + almostEqual(1.0, 2.0, epsilon));
    }

    private boolean almostEqual(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }

    private void demonstrateInfinityAndNaN() {
        System.out.println("4. Infinity и NaN");
        double posInf = 1.0 / 0.0;
        double negInf = -1.0 / 0.0;
        double nan = 0.0 / 0.0;
        System.out.println("1.0 / 0.0 = " + posInf);
        System.out.println("-1.0 / 0.0 = " + negInf);
        System.out.println("0.0 / 0.0 = " + nan);
        System.out.println("NaN == NaN ? " + (nan == nan));
        System.out.println("NaN != NaN ? " + (nan != nan));
    }

    private void compareRoundingMethods() {
        System.out.println("5. Округление положительных и отрицательных");
        System.out.println("x = " + 2.7
                + " | (int)x = " + ((int) 2.7)
                + " | round = " + Math.round(2.7)
                + " | floor = " + Math.floor(2.7)
                + " | ceil = " + Math.ceil(2.7));
        System.out.println("x = " + -2.7
                + " | (int)x = " + ((int) -2.7)
                + " | round = " + Math.round(-2.7)
                + " | floor = " + Math.floor(-2.7)
                + " | ceil = " + Math.ceil(-2.7));
    }

    private void compareFloatAndDouble() {
        System.out.println("6. Точность float vs double");
        float f = 0.1f + 0.2f;
        double d = 0.1 + 0.2;
        System.out.println("float : 0.1f + 0.2f = " + f);
        System.out.println("double: 0.1 + 0.2 = " + d);
    }
}
