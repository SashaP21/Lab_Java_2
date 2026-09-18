package ru.university.lab2.arrays;

public class Task06MultiArrays {

    public void run() {
        int[][] matrix = createAndPrintMatrix(3, 4);
        transposeAndPrint(matrix);
        multiplyCompatibleMatricesDemo();
    }

    private int[][] createAndPrintMatrix(int rows, int cols) {
        System.out.println("1. Матрица " + rows + "x" + cols);
        if (rows <= 0 || cols <= 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[rows][cols];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value;
                value++;
            }
        }
        System.out.println("Исходная матрица:");
        printMatrix(matrix);
        return matrix;
    }

    private void transposeAndPrint(int[][] matrix) {
        System.out.println("2. Транспонирование");
        if (matrix.length == 0) {
            return;
        }
        int[][] transposed = transpose(matrix);
        System.out.println("Транспонированная матрица:");
        printMatrix(transposed);
    }

    private int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private void multiplyCompatibleMatricesDemo() {
        System.out.println("3. Умножение матриц");
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] b = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        System.out.println("Матрица A (2x3):");
        printMatrix(a);
        System.out.println("Матрица B (3x2):");
        printMatrix(b);
        int[][] c = multiply(a, b);
        System.out.println("A x B (2x2):");
        if (c != null)
            printMatrix(c);
    }

    private int[][] multiply(int[][] a, int[][] b) {
        if (a.length == 0 || b.length == 0) {
            System.out.println("Ошибка: одна из матриц пуста.");
            return null;
        }
        int m = a.length;
        int n = a[0].length;
        int p = b.length;
        int q = b[0].length;
        if (n != p) {
            System.out.println("Ошибка: матрицы несогласованы: A " + m + "x" + n
                    + ", B " + p + "x" + q);
            return null;
        }
        int[][] result = new int[m][q];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    private void printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
