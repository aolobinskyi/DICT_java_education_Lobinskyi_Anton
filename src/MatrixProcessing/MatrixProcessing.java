package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    private final double [][]  data;
    private final int rows;
    private final int colums;

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

}


