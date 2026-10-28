package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Botty.");
        System.out.println("I was created in 2026.");
        System.out.println("Please, remind me your name.");

        String MyName = scanner.nextLine();

        System.out.println("What a great name you have " + MyName + "!");
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is "+ age +" that`s a good time to start programming!");
        System.out.println("Now I will prove to you that I can count to any number you want!");

        int UserNumb = scanner.nextInt();

        for(int numb0 = 0; numb0 <= UserNumb; numb0++){
            System.out.println(numb0 + "!");
        }

    }
}

