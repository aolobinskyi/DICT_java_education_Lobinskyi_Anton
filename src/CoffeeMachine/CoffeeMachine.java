package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    static void Print(String args){
        System.out.println(args);
    }

    static void CheckAbility(int water, int milk, int coffe, int amount) {
        int possibleWater = water / 200;
        int possibleMilk = milk / 50;
        int possibleCoffe = coffe / 15;

        int possibleCups = Math.min(possibleWater, Math.min(possibleMilk, possibleCoffe));
        int moreCups = possibleCups - amount;

        if (amount == possibleCups) {
            Print("Yes, I can make that amount of coffee.");
        } else if (amount < possibleCups) {
            Print("Yes, I can make that amount of coffee (and even "  + moreCups + " more than that)");
        } else {
            Print("No, I can make" + possibleCups + "only N cups of coffee.");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Print("Write how many ml of water the coffee machine has:");
        int amountWater = scanner.nextInt();
        Print("Write how many ml of milk the coffee machine has:");
        int amountMilk = scanner.nextInt();
        Print("Write how many grams of coffee beans the coffee machine has:");
        int amountCoffe = scanner.nextInt();
        Print("Write how many cups of coffee you will need:");
        int amountCups = scanner.nextInt();
        CheckAbility(amountWater, amountMilk, amountCoffe,amountCups);
    }
}
