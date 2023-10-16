package j1.s.p0074;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PhạmVinhTiến
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);

    //check integer limit
    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (Exception ex) {
                System.out.println("Please choice from 1 to 4: ");
            }
        }
    }

    //check input is integer
    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                               
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Values of matrix must be the number.");
            }
        }
    }

    //input matrix
    private static int[][] inputMatrix(int n) {
        System.out.println("Enter Row Matrix: "); //enter number row
        int row = checkInputInt();
        System.out.println("Enter Column Matrix: "); //enter number col
        int col = checkInputInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter Matrix" + n + "[" + i + "]" + "[" + j + "]"); //enter element matrix
                matrix[i][j] = checkInputInt();
            }
        }
        return matrix;
    }

    //show matrix
    private static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    //add matrix
    private static void additionMatrix(int[][] matrix1, int[][] matrix2) {
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;
        int row1 = matrix2.length;
        int col1 = matrix2[0].length;
        if (row != row1 || col != col1) {
            System.out.println("Can't not addition");
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] + matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    //sub matrix
    private static void subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;
        int row1 = matrix2.length;
        int col1 = matrix2[0].length;
        if (row != row1 || col != col1) {
            System.out.println("Can't not subtraction");
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    //multi matrix
    private static void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (col1 != row2) {
            System.out.println("Can't multiple");
            return;
        }
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(matrixResult);
    }

    private static void display() {
        int[][] matrix1 = inputMatrix(1);
        int[][] matrix2 = inputMatrix(2);
        System.out.println("======Calculator program======");
        while (true) {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.println("Your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    additionMatrix(matrix1, matrix2);
                    break;
                case 2:
                    subtractionMatrix(matrix1, matrix2);
                    break;
                case 3:
                    multiplicationMatrix(matrix1, matrix2);
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        display();
    }
}
