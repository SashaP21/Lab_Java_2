package ru.university.lab2.numbers;

public class Task03BitwiseOps {

    public void run() {
        demonstrateBitwiseOperators();
        demonstrateShiftDifference();
        demonstrateEvenCheck();
        demonstratePowerOfTwoCheck();
        demonstrateBitCount();
        demonstrateXorSwap();
    }

    private void demonstrateBitwiseOperators() {
        System.out.println("1. Побитовые операторы");
        int a = 12; // 1100
        int b = 10; // 1010

        System.out.println("a & b  = " + (a & b));
        System.out.println("a | b  = " + (a | b));
        System.out.println("a ^ b  = " + (a ^ b));
        System.out.println("~a     = " + (~a));
        System.out.println("a << 2 = " + (a << 2));
        System.out.println("a >> 1 = " + (a >> 1));
        System.out.println("a >>> 1 = " + (a >>> 1));
    }

    private void demonstrateShiftDifference() {
        System.out.println("2. Разница >> и >>> на отрицательном числе");
        int x = -8;
        System.out.println("x = " + x);
        System.out.println("x >> 1  = " + (x >> 1));
        System.out.println("x >>> 1 = " + (x >>> 1));
        // Объяснение: >> - сохраняет знак (слева копируется знаковый бит)
        // >>> - беззнаковый сдвиг: слева всегда дописываются 0
    }

    private void demonstrateEvenCheck() {
        System.out.println("3.1. Чётность через & 1");
        int a = 5;
        int b = 4;
        System.out.println(a + " - " + ((a & 1) == 0 ? "чётное" : "нечётное"));
        System.out.println(b + " - " + ((b & 1) == 0 ? "чётное" : "нечётное"));
    }

    private void demonstratePowerOfTwoCheck() {
        System.out.println("3.2. Проверка на степень двойки");
        int a = 7;
        int b = 8;
        System.out.println(a + " - " + (a > 0 && (a & (a - 1)) == 0 ? "степень двойки" : "не степень двойки"));
        System.out.println(b + " - " + (b > 0 && (b & (b - 1)) == 0 ? "степень двойки" : "не степень двойки"));
    }

    private void demonstrateBitCount() {
        System.out.println("3.3. Подсчёт единичных битов");
        int a = 7;
        int b = 10;
        System.out.println("Единичных битов в " + a + " - " + countOneBits(a));
        System.out.println("Единичных битов в " + b + " - " + countOneBits(b));
    }

    private void demonstrateXorSwap() {
        System.out.println("4. Обмен через XOR");
        int a = 5;
        int b = 9;
        System.out.println("До обмена: a = " + a + ", b = " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("После обмена: a = " + a + ", b = " + b);
    }

    private int countOneBits(int n) {
        int value = n;
        int count = 0;
        while (value != 0) {
            count += value & 1;
            value >>>= 1;
        }
        return count;
    }
}
