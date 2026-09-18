package ru.university.lab2;

import java.util.Scanner;
import ru.university.lab2.arrays.Task05SingleArrays;
import ru.university.lab2.arrays.Task06MultiArrays;
import ru.university.lab2.numbers.Task01IntegerTraps;
import ru.university.lab2.numbers.Task02FloatingPoint;
import ru.university.lab2.numbers.Task03BitwiseOps;
import ru.university.lab2.strings.Task04TextProcessing;
import ru.university.lab2.util.Task07MethodsAndArgs;

public class Main {
    public static void main(String[] args) {
        String instruction = """
                Выбор задания:
                0 - выход
                1 - задание №1 (целые числа)
                2 - задание №2 (вещественные числа)
                3 - задание №3 (битовые операции)
                4 - задание №4 (текст)
                5 - задание №5 (одномерные массивы)
                6 - задание №6 (матрицы)
                7 - задание №7 (методы)
                """;

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println(instruction);
            System.out.println("Введите номер задания");
            if (!scanner.hasNextInt()){
                System.out.println("Введите число");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();

            switch (choice){
                case 0 -> System.out.println("Выход");
                case 1 -> new Task01IntegerTraps().run();
                case 2 -> new Task02FloatingPoint().run();
                case 3 -> new Task03BitwiseOps().run();
                case 4 -> new Task04TextProcessing().run();
                case 5 -> new Task05SingleArrays().run();
                case 6 -> new Task06MultiArrays().run();
                case 7 -> new Task07MethodsAndArgs().run();
                default -> System.out.println("Нет задания с таким номером");
            }

        } while (choice != 0);
    }
}
