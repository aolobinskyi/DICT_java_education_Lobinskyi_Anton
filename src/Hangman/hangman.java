package Hangman;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    static int lifes = 8;

    static String[] words = {
            "python", "java", "javascript", "kotlin"
    };

    public static String ShowWord(String word) {

        String result = "";

        for (int i = 0; i < word.length(); i++) {
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
        String guessedLetters = "";

        String hiddenWord = ShowWord(word);
        while (lifes > 0) {

            System.out.println(hiddenWord);

            System.out.print("Input a letter: ");
            String input = scanner.nextLine();

            char letter = input.charAt(0);
            if (guessedLetters.contains(String.valueOf(letter))) {
                System.out.println("No improvements");
                lifes--;
                continue;
            }
            boolean found = false;

            char[] hiddenChars = hiddenWord.toCharArray();

            for (int i = 0; i < word.length(); i++) {

                if (word.charAt(i) == letter) {

                    hiddenChars[i] = letter;

                    found = true;
                }
            }
            hiddenWord = String.valueOf(hiddenChars);
            guessedLetters += letter;
            if (!found) {
                lifes--;
                System.out.println("That letter doesn't appear in the word");
            }

            if (hiddenWord.equals(word)) {
                System.out.println("You survived!");
                return;
            }

        }

        System.out.println("You lost!");
    }
}
