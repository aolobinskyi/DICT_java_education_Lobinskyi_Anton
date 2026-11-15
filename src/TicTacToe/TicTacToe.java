package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter cells: ");
        String cells = scanner.nextLine();

        printCells(cells);
        System.out.println(getGameState(cells));
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

    public static int countSymbol(String cells, char symbol) {
        int count = 0;
        for (int i = 0; i < cells.length(); i++) {
            if (cells.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static boolean hasEmptyCells(String cells) {
        return cells.contains("_");
    }

    public static String getGameState(String cells) {
        boolean xWins = checkWin(cells, 'X');
        boolean oWins = checkWin(cells, 'O');
        int xCount = countSymbol(cells, 'X');
        int oCount = countSymbol(cells, 'O');

        if (xWins && oWins) {
            return "Impossible";
        }
        if (Math.abs(xCount - oCount) > 1) {
            return "Impossible";
        }
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
}
