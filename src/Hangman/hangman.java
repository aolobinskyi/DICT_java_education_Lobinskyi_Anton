package Hangman;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");

        String word = "python";

        System.out.print("Guess the word:");
        String userword = scanner.nextLine();

        if(userword.equals(word)){
            System.out.print("You survived!");
        }
        else {
            System.out.print("You lost!");
        }
    }
}
