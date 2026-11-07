package Hangman;
import java.util.Random;
import java.util.Scanner;

public class hangman {

    static String[] words = {
            "python", "java", "javascript", "kotlin"
    };

    public static String ShowWord(String word) {

        String result = word.substring(0, 2);

        for (int i = 2; i < word.length(); i++) {
            result += "-";
        }

        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("HANGMAN");

        int wordNumber = random.nextInt(words.length);
        String word = words[wordNumber];

        System.out.print("Guess the word: " + ShowWord(word));
        String userword = scanner.nextLine();

        if(userword.equals(word)){
            System.out.print("You survived!");
        }
        else {
            System.out.print("You lost!");
        }
    }
}
