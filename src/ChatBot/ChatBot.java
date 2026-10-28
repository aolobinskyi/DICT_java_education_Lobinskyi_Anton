package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Botty.");
        System.out.println("I was created in 2026.");
        System.out.println("Please, remind me your name.");

        String MyName = scanner.nextLine();

        System.out.println("Nice to meet you, " + MyName + "!");
    }
}

