package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static char currentPlayer = 'X';
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cells = "_________";


        printCells(cells);
        while (true){
            int row;
            int col;
            System.out.println("Enter the coordinates:");
            String input = scanner.nextLine();

            String[] coordinates = input.split(" ");

            try {
                row = Integer.parseInt(coordinates[0]);
                col = Integer.parseInt(coordinates[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (!isValidMove(cells, row, col)) {
                continue;
            }
            int index = (row - 1) * 3 + (col - 1);
            char[] board = cells.toCharArray();
            board[index] = currentPlayer;
            cells = String.valueOf(board);
            printCells(cells);
            changePlayer();
            String gameState = getGameState(cells);
            if (gameState.equals("X wins") ||
                    gameState.equals("O wins") ||
                    gameState.equals("Draw")) {

                System.out.println(gameState);
                break;
            }
        }

    }

    public static void printCells(String cells) {

        System.out.println("---------");

        System.out.println("| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |");

        System.out.println("| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |");

        System.out.println("| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |");

        System.out.println("---------");
    }

    public static boolean checkWin(String cells, char charac){
        return (cells.charAt(0) == charac && cells.charAt(1) == charac && cells.charAt(2) == charac ) ||
                (cells.charAt(3) == charac && cells.charAt(4) == charac && cells.charAt(5) == charac) ||
                (cells.charAt(6) == charac && cells.charAt(7) == charac && cells.charAt(8) == charac) ||
                (cells.charAt(0) == charac && cells.charAt(3) == charac && cells.charAt(6) == charac) ||
                (cells.charAt(1) == charac && cells.charAt(4) == charac && cells.charAt(7) == charac) ||
                (cells.charAt(2) == charac && cells.charAt(5) == charac && cells.charAt(8) == charac) ||
                (cells.charAt(0) == charac && cells.charAt(4) == charac && cells.charAt(8) == charac) ||
                (cells.charAt(2) == charac && cells.charAt(4) == charac && cells.charAt(6) == charac);
    }

    public static boolean hasEmptyCells(String cells) {
        return cells.contains("_");
    }

    public static String getGameState(String cells) {
        boolean xWins = checkWin(cells, 'X');
        boolean oWins = checkWin(cells, 'O');

        if (xWins) {
            return "X wins";
        }
        if (oWins) {
            return "O wins";
        }
        if (hasEmptyCells(cells)) {
            return "Game not finished";
        }
        return "Draw";
    }
    public static boolean isValidMove(String cells, int row, int col) {
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        int index = (row - 1) * 3 + (col - 1);
        if (cells.charAt(index) != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    public static void changePlayer(){
        char player = currentPlayer;
        if(player == 'X'){
            currentPlayer = 'O';
        } else{
            currentPlayer = 'X';
        }
    }
}
