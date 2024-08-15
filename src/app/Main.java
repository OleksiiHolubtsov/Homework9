package app;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {23, 45, 12, 37},
                {50, 11, 42, 20},
                {33, 27, 19, 48},
                {8, 39, 6, 4}
        };

        System.out.println("  Матриця 4x4:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        int sumEvenRows = 0;
        int sumOddRows = 0;


        for (int i = 0; i < matrix.length; i += 2) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumEvenRows += matrix[i][j];
            }
        }


        System.out.println("\nСума елементів у парних рядках (рядок 0, 2): "
                + sumEvenRows);


        for (int i = 1; i < matrix.length; i += 2) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumOddRows += matrix[i][j];
            }
        }

        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): "
                + sumOddRows);

        long productEvenColumns = 1;
        long productOddColumns = 1;

               for (int j = 0; j < matrix[0].length; j += 2) {
            for (int i = 0; i < matrix.length; i++) {
                productEvenColumns *= matrix[i][j];
            }
        }

        System.out.println("Добуток всіх елементів у парних стовпцях (стовпці 0, 2): "
                + productEvenColumns);

        for (int j = 1; j < matrix[0].length; j += 2) {
            for (int i = 0; i < matrix.length; i++) {
                productOddColumns *= matrix[i][j];
            }
        }

        System.out.println("Добуток всіх елементів у непарних стовпцях (стовпці 1, 3): "
                + productOddColumns + "\n");

        if (isMagicSquare(matrix)) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int size = matrix.length;

        for (int[] row : matrix) {
            if (row.length != size) {
                return false;
            }
        }

        int magicSum = 0;

        for (int j = 0; j < size; j++) {
            magicSum += matrix[0][j];
        }

        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int i = 0; i < size; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }
        int diagonal1Sum = 0;
        for (int i = 0; i < size; i++) {
            diagonal1Sum += matrix[i][i];
        }
        if (diagonal1Sum != magicSum) {
            return false;
        }

        int diagonal2Sum = 0;
        for (int i = 0; i < size; i++) {
            diagonal2Sum += matrix[i][size - i - 1];
        }
        if (diagonal2Sum != magicSum) {
            return false;
        }

        return true;

    }
}