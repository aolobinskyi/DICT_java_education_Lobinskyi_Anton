package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    static Scanner scanner = new Scanner(System.in);

    static void Print(String args){
        System.out.println(args);
    }

    static void getMaterials(){
        System.out.println("Water left: " + water + " ml");
        System.out.println("Milk left: " + milk + " ml");
        System.out.println("Beans left: " + beans + " g");
        System.out.println("Cups left: " + cups);
        System.out.println("Money left: " + money);
    }

    static void SpendIngredients(int water1, int milk1, int beans1, int cups1, int money1){
        water -= water1;
        milk -= milk1;
        beans -= beans1;
        cups -= cups1;
        money += money1;
    }

    static boolean CheckResources(int water1, int milk1, int beans1, int cups1){

        if(water < water1){
            Print("Sorry, not enough water!");
            return false;
        }

        if(milk < milk1){
            Print("Sorry, not enough milk!");
            return false;
        }

        if(beans < beans1){
            Print("Sorry, not enough coffee beans!");
            return false;
        }

        if(cups < cups1){
            Print("Sorry, not enough disposable cups!");
            return false;
        }

        Print("I have enough resources, making you a coffee!");
        return true;
    }

    static void AddIngredients(){

        Print("Write how many ml of water you want to add:");
        int water1 = scanner.nextInt();
        Print("Write how many ml of milk you want to add:");
        int milk1 = scanner.nextInt();
        Print("Write how many grams of coffee beans you want to add:");
        int beans1 = scanner.nextInt();
        Print("Write how many disposable coffee cups you want to add:");
        int cups1 = scanner.nextInt();
        scanner.nextLine();

        water += water1;
        milk += milk1;
        beans += beans1;
        cups += cups1;
    }

    static int TakeMoney(){
        int tookMoney = money;
        money = 0;

        return tookMoney;
    }

    static void buy(int choose){

        if(choose == 1){ // эспрессо

            if(CheckResources(250, 0, 16, 1)){
                SpendIngredients(250, 0, 16, 1, 4);
            }
        } else if (choose == 2) { // латте

            if(CheckResources(350, 75, 20, 1)){
                SpendIngredients(350, 75, 20, 1, 7);
            }
        } else if (choose == 3){ // капучино

            if(CheckResources(200, 100, 12, 1)){
                SpendIngredients(200, 100, 12, 1, 6);
            }
        }
    }

    public static void main(String[] args){

        while (true){

            Print("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            if(action.equals("buy")){
                Print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - return:");
                int choose = scanner.nextInt();
                scanner.nextLine();
                if(choose == 4){
                    continue;
                }
                buy(choose);
            } else if (action.equals("fill")) {
                AddIngredients();
            } else if (action.equals("take")) {
                int tookmoney = TakeMoney();
                Print("I gave you " + tookmoney);
            } else if (action.equals("remaining")) {
                getMaterials();
            } else if (action.equals("exit")) {
                break;
            }
        }
    }
}