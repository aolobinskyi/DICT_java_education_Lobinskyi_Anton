package Hangman;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    static String[] words = {
            "python", "java", "javascript", "kotlin"
    };

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("HANGMAN");

        int wordNumber = random.nextInt(words.length);
        String word = words[wordNumber];

        System.out.print("Selected word is" + word);
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
