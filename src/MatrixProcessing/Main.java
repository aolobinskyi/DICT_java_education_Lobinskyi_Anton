package MatrixProcessing;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        System.out.println("Вхід:");
        Scanner scanner = new Scanner(System.in);

        MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);
        MatrixProcessing secondMatrix = MatrixProcessing.readMatrix(scanner);

        MatrixProcessing result = firstMatrix.add(secondMatrix);

        if (result == null) {
            System.out.println("ERROR");
        } else {
            result.printMatrix();
        }

    }
}
