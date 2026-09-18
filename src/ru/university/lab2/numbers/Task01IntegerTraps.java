package ru.university.lab2.numbers;

public class Task01IntegerTraps {

    public void run() {
        printTypeRanges();
        demonstrateMaxValuePlusOne();
        compareIntAndLongMultiplication();
        demonstrateDivisionAndRemainder();
        demonstrateLongToIntCast();
        demonstrateCharArithmetic();
        demonstrateOverflowCheck();
    }

    private void printTypeRanges() {
        System.out.println("1. Диапазоны целочисленных типов");
        System.out.println("byte : [" + Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + "]");
        System.out.println("short: [" + Short.MIN_VALUE + ", " + Short.MAX_VALUE + "]");
        System.out.println("int  : [" + Integer.MIN_VALUE + ", " + Integer.MAX_VALUE + "]");
        System.out.println("long : [" + Long.MIN_VALUE + ", " + Long.MAX_VALUE + "]");
        // Объяснение: MIN_VALUE и MAX_VALUE - константы границ типов;
        // ширина типа определяет количество доступных двоичных комбинаций и диапазон.
    }

    private void demonstrateMaxValuePlusOne() {
        System.out.println("2. Integer.MAX_VALUE + 1");
        int max = Integer.MAX_VALUE;
        int result = max + 1;
        System.out.println("Integer.MAX_VALUE = " + max);
        System.out.println("Integer.MAX_VALUE + 1 = " + result);
        // Объяснение: Происходит циклическое переполнение.
        // После MAX_VALUE следующий результат переходит через границу диапазона
        // к Integer.MIN_VALUE.
    }

    private void compareIntAndLongMultiplication() {
        System.out.println("3. Integer.MAX_VALUE * 2 в int и в long");
        int inInt = Integer.MAX_VALUE * 2;
        long inLong = (long) Integer.MAX_VALUE * 2;
        System.out.println("в int : Integer.MAX_VALUE * 2 = " + inInt);
        System.out.println("в long: Integer.MAX_VALUE * 2 = " + inLong);
        // Объяснение: выражение Integer.MAX_VALUE * 2 вычисляется в типе int
        // (оба операнда int), поэтому результат переполняется
        // Во втором случае один операнд заранее приведён к long, всё выражение
        // расширяется до long (64 бита), переполнения нет
    }

    private void demonstrateDivisionAndRemainder() {
        System.out.println("4. Деление и остаток");
        System.out.println("5 / 2 = " + (5 / 2));
        System.out.println("-5 / 2 = " + (-5 / 2));
        System.out.println("5 % 2 = " + (5 % 2));
        System.out.println("-5 % 2 = " + (-5 % 2));
        // Объяснение: целочисленное деление отбрасывает дробную часть
        // Знак остатка % совпадает со знаком делимого
    }

    private void demonstrateLongToIntCast() {
        System.out.println("5. Приведение long к int");
        long big = Integer.MAX_VALUE + 10L;
        int narrowed = (int) big;
        System.out.println("long value = " + big);
        System.out.println("(int) long value = " + narrowed);
        // Объяснение: при сужающем приведении long к int старшие 32 бита отбрасываются
    }

    private void demonstrateCharArithmetic() {
        System.out.println("6. Арифметика над char");
        char letter = 'd';
        char next = (char) (letter + 1);
        System.out.println("Буква: " + letter + ", следующая: " + next);

        char a = 'A';
        char b = 'B';
        int sumAsInt = a + b;
        char sumAsChar = (char) (a + b);
        System.out.println("'A' + 'B' как число = " + sumAsInt);
        System.out.println("'A' + 'B' как символ = '" + sumAsChar + "' (код " + (int) sumAsChar + ")");
        // Объяснение: char в Java - 16-битное беззнаковое число.
        // В арифметических выражениях char расширяется до int
        // Чтобы получить символ обратно, нужно явное приведение
    }

    private void demonstrateOverflowCheck() {
        System.out.println("7. Проверка переполнения при сложении int");
        checkPair(Integer.MAX_VALUE, 1);   // переполнение
        checkPair(100, 200);            // без переполнения
    }

    private void checkPair(int a, int b) {
        boolean overflow = isAdditionOverflow(a, b);
        int sum = a + b;
        System.out.println(a + " + " + b + " = " + sum + " | переполнение: " + (overflow ? "да" : "нет"));
    }

    private boolean isAdditionOverflow(int a, int b) {
        if (b > 0)
            return a > Integer.MAX_VALUE - b;
        if (b < 0)
            return a < Integer.MIN_VALUE - b;
        return false;
    }
}
