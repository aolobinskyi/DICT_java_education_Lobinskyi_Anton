package MatrixProcessing;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        System.out.println("Вхід:");
        Scanner scanner = new Scanner(System.in);

        MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);
        int multiply = scanner.nextInt();

        MatrixProcessing result = firstMatrix.multiply(multiply);

        if (result == null) {
            System.out.println("ERROR");
        } else {
            result.printMatrix();
        }

    }
}
