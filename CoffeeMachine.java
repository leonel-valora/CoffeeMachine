package machine;
import java.util.Scanner;

public class CoffeeMachine {
    static Scanner sc = new Scanner(System.in);
	static int water = 400;
	static int milk = 540;
	static int coffee = 120;
	static int cups = 9;
	static int money = 550;
	static boolean flag = true;
    public static void main(String[] args) {
        while(flag) {
			Action();
		}
    }
    private static void StateMachine() {
		System.out.println("The coffee machine has:\n"
				+water+" of water\n"
				+milk+" of milk\n"
				+coffee+" of coffee beans\n"
				+cups+" of disposable cups\n"
				+money+" of money");
	}
	
	private static void Action() {
		System.out.println("Write action (buy, fill, take, remaining, exit):");
		String action = sc.next();
		switch(action) {
			case "buy":
				MakeCoffee();
				break;
			case "fill":
				FillMachine();
				break;
			case "take":
				TakeMoney();
				break;
			case "remaining":
				StateMachine();
				break;
			case "exit":
				flag = false;
				break;
		}
	}
	
	private static void MakeCoffee() {
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
		String kindCoffee = sc.next();
		switch(kindCoffee) {
			case "1":
				CheckResources(250,0,16,4);
				break;
			case "2":
				CheckResources(350,75,20,7);
				break;
			case "3":
				CheckResources(200,100,12,6);
				break;
			case "back":
				break;
		}
	}
	
	private static void CheckResources(int waterNeed, int milkNeed, int coffeeNeed, int price) {
		if((water - waterNeed) < 0) {
			System.out.println("Sorry, not enough water!");
		}
		else if((milk - milkNeed) < 0) {
			System.out.println("Sorry, not enough milk!");
		}
		else if((coffee - coffeeNeed) < 0) {
			System.out.println("Sorry, not enough coffee beans!");
		}
		else if((cups - 1) < 0) {
			System.out.println("Sorry, not enough cups!");
		}
		else {
			System.out.println("I have enough resources, making you a coffee!");
			water -= waterNeed;
			milk -= milkNeed;
			coffee -= coffeeNeed;
			cups -= 1;
			money += price;
		}
		
	}
	
	private static void FillMachine() {
		System.out.println("Write how many ml of water do you want to add:");
		water += sc.nextInt();
		System.out.println("Write how many ml of milk do you want to add:");
		milk += sc.nextInt();
		System.out.println("Write how many grams of coffee beans do you want to add:");
		coffee += sc.nextInt();
		System.out.println("Write how many disposable cups of coffee do you want to add:");
		cups += sc.nextInt();
	}
	
	private static void TakeMoney() {
		System.out.println("I gave you $"+money);
		money = 0;
	}
}