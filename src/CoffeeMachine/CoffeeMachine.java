package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    static void Print(String args){
        System.out.println(args);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Print("Write how many cups of coffee you will need:");
        int amount = scanner.nextInt();
        Print("For " + amount + " cups of coffee you will need:");
        Print(amount * 200 + " ml of water");
        Print(amount * 50 + " ml of milk");
        Print(amount * 15 + " g of coffee beans");

    }
}
