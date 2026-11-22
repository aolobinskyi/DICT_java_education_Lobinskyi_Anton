package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    private final double [][]  data;
    private final int rows;
    private final int colums;

    private double[][] getMinor(int row, int column) {
        double[][] minor = new double[rows - 1][colums - 1];
        int minorRow = 0;
        for (int i = 0; i < rows; i++) {
            if (i == row) {
                continue;
            }
            int minorColumn = 0;
            for (int j = 0; j < colums; j++) {
                if (j == column) {
                    continue;
                }
                minor[minorRow][minorColumn] = data[i][j];
                minorColumn++;
            }
            minorRow++;
        }
        return minor;
    }

    public MatrixProcessing(double[][] data){
        this.data = data;
        this.rows = data.length;
        this.colums = data[0].length;
    }

    public MatrixProcessing add(MatrixProcessing other){
        if (rows != other.rows || colums != other.colums) {
            return null;
        }

        double[][] result = new double[rows][colums];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }

        return new MatrixProcessing(result);
    }

    public void printMatrix(){
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < colums; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static MatrixProcessing readMatrix(Scanner scanner) {

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        double[][] data = new double[rows][cols];
        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = scanner.nextDouble();
            }
        }

        return new MatrixProcessing(data);
    }

    public MatrixProcessing multiply(int multiply){

        double[][] result = new double[rows][colums];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                result[i][j] = data[i][j] * multiply;
            }
        }

        return new MatrixProcessing(result);
    }

    public MatrixProcessing multiplyMatrix(MatrixProcessing other) {

        if (colums != other.rows) {
            return null;
        }

        double[][] result = new double[rows][other.colums];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.colums; j++) {
                for (int k = 0; k < colums; k++) {
                    result[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }

        return new MatrixProcessing(result);
    }
    public MatrixProcessing transposeMainDiagonal() {

        double[][] result = new double[colums][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                result[j][i] = data[i][j];
            }
        }

        return new MatrixProcessing(result);
    }
    public MatrixProcessing transposeSideDiagonal() {

        double[][] result = new double[colums][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {

                result[colums - 1 - j][rows - 1 - i] =
                        data[i][j];
            }
        }

        return new MatrixProcessing(result);
    }
    public MatrixProcessing transposeVertical() {

        double[][] result = new double[rows][colums];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                result[i][colums - 1 - j] = data[i][j];
            }
        }

        return new MatrixProcessing(result);
    }
    public MatrixProcessing transposeHorizontal() {

        double[][] result = new double[rows][colums];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                result[rows - 1 - i][j] = data[i][j];
            }
        }

        return new MatrixProcessing(result);
    }

    public double determinant() {
        if (rows != colums) {
            return 0;
        }
        if (rows == 1) {
            return data[0][0];
        }
        if (rows == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        }
        double determinant = 0;
        for (int j = 0; j < colums; j++) {
            double sign;
            if (j % 2 == 0) {
                sign = 1;
            } else {
                sign = -1;
            }
            MatrixProcessing minorMatrix = new MatrixProcessing(getMinor(0, j));
            determinant += sign * data[0][j] * minorMatrix.determinant();
        }
        return determinant;
    }



}


