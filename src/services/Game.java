package services;

import java.util.Scanner;

public class Game {
    static int healthPoint = 100;
    static boolean hasKey = false;
    static final int CORRECT_CODE = 7890;
    static final int MAX_ATTEMPTS = 3;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("You wake up in a dark room. A voice whispers: 'Find the Golden Key to escape!'");
        choosePath();
        findSafe();
        displayGameResult();
    }


    public static void choosePath() {
        System.out.println("Please choose one of these choices:");
        System.out.println("1️⃣ Open the wooden door 🚪");
        System.out.println("2️⃣ Climb through the vent 🔲");

        int choice = scanner.nextInt();

        if (choice == 1) {
            fightGuard();
        } else if (choice == 2) {
            healthPoint -= 10;
            System.out.println("You chose the vent and lost 10 health points due to spiders! You have " + healthPoint + " health points left!");
        } else {
            System.out.println("Invalid choice! Try again.");
            choosePath();
        }
    }

    public static void fightGuard() {
        System.out.println("You met a guard! He blocks you.");
        System.out.println("Choose a weapon to defend yourself:");
        System.out.println("⚔ 1 - Sword");
        System.out.println("🏹 2 - Bow");
        System.out.println("❌ 3 - Nothing");

        int weaponChoice = scanner.nextInt();
        switch (weaponChoice) {
            case 1:
            case 2:
                System.out.println("You fought with the guard and YOU WON!");
                break;
            case 3:
                healthPoint -= 20;
                System.out.println("You chose nothing and couldn't fight against the guard!");
                System.out.println("You lost 20 health points! You have " + healthPoint + " health points left!");
                break;
            default:
                System.out.println("Invalid choice! Try again.");
                fightGuard();
        }
    }

    public static void findSafe() {
        int attempts = MAX_ATTEMPTS;

        System.out.println("\nYou find a safe with a Golden Key inside!");
        System.out.println("WARNING!!: If you don't find the code, you will be trapped forever!!!");
        System.out.println("Enter the 4-digit code to unlock it:");

        while (attempts > 0) {
            System.out.println("Guess the number! Attempts left: " + attempts);
            int guess = scanner.nextInt();

            if (guess == CORRECT_CODE) {
                System.out.println("Congratulations! You guessed the correct code and escaped!");
                hasKey = true;
                return;
            } else {
                attempts--;
                System.out.println(attempts > 0 ? "Wrong guess! Try again." : "Game Over! You are trapped forever!");
            }
        }
    }

    public static void displayGameResult() {
        System.out.println(hasKey
                ? "🎊 You use the Golden Key and escape the castle! YOU WIN! 🏆"
                : "😱 You failed to find the key. You are trapped forever!");
    }
}
