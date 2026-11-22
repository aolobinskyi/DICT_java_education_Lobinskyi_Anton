package MatrixProcessing;

import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("0. Exit");

            int choose = scanner.nextInt();

            System.out.println("Your choice:" + choose);

            if(choose == 1){
                System.out.println("Enter size of first matrix:");
                MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);
                System.out.println("Enter size of second matrix:");
                MatrixProcessing secondMatrix = MatrixProcessing.readMatrix(scanner);

                MatrixProcessing result = firstMatrix.add(secondMatrix);
                if(result == null){
                    System.out.println("ERROR");
                } else {
                    System.out.println("The result is:");
                    result.printMatrix();
                }
            } else if (choose == 2) {
                System.out.println("Enter size of matrix:");
                MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);
                System.out.println("Enter constant:");
                int multiply = scanner.nextInt();
                MatrixProcessing result = firstMatrix.multiply(multiply);
                System.out.println("The result is:");
                result.printMatrix();

            } else if (choose == 3) {
                System.out.println("Enter size of first matrix:");
                MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);
                System.out.println("Enter size of second matrix:");
                MatrixProcessing secondMatrix = MatrixProcessing.readMatrix(scanner);

                MatrixProcessing result = firstMatrix.multiplyMatrix(secondMatrix);

                if (result == null) {
                    System.out.println("ERROR");
                } else {
                    System.out.println("The result is:");
                    result.printMatrix();
                }
            }else if (choose == 4) {
                System.out.println("1. Main diagonal");
                System.out.println("2. Side diagonal");
                System.out.println("3. Vertical line");
                System.out.println("4. Horizontal line");

                int choise = scanner.nextInt();

                if(choise == 1){

                    System.out.println("Enter size of matrix:");
                    MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);

                    MatrixProcessing result = firstMatrix.transposeMainDiagonal();
                    result.printMatrix();

                } else if(choise == 2){

                    System.out.println("Enter size of matrix:");
                    MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);

                    MatrixProcessing result = firstMatrix.transposeSideDiagonal();
                    result.printMatrix();

                } else if(choise == 3){

                    System.out.println("Enter size of matrix:");
                    MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);

                    MatrixProcessing result = firstMatrix.transposeVertical();
                    result.printMatrix();

                } else if(choise == 4){

                    System.out.println("Enter size of matrix:");
                    MatrixProcessing firstMatrix = MatrixProcessing.readMatrix(scanner);

                    MatrixProcessing result = firstMatrix.transposeHorizontal();
                    result.printMatrix();

                } else {
                    continue;
                }

            } else if (choose == 0) {
                break;
            }
        }
    }
}
