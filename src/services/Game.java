package services;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        int healthpoint = 100;

        boolean hasKey = false;


        System.out.println("You wake up in a dark room. A voice whispers: 'Find the Golden Key to escape!'");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please choose one of these choices:");
        System.out.println("1️⃣ Open the wooden door 🚪");
        System.out.println("2️⃣ Climb through the vent 🔲");

        int choice=scanner.nextInt();

        if (choice==1){
            System.out.println("You met with a guard! He blocks you.");
            System.out.println("Choose a weapon to defend yourself:");
            System.out.println("⚔ 1 - Sword");
            System.out.println("🏹 2 - Bow");
            System.out.println("❌ 3 - Nothing");

            int weaponChoice=scanner.nextInt();
            switch (weaponChoice){
                case 1:
                    System.out.println("You chose sword,fought with a guard and YOU WON!");
                    break;
                case 2:
                    System.out.println("You chose bow,fought with a guard and YOU WON!");
                    break;
                case 3:
                    System.out.println("You chose nothing and couldn't fight against guard!");
                    healthpoint-=20;
                    System.out.println("You lost 20 health points due to spiders!You have left: " + healthpoint + "health point!");
                    break;
                default:
                    System.out.println("Please choose invalid weapon");

            }

        }else if (choice==2){
            healthpoint-=10;
            System.out.println("You chose vent and lost 10 health points due to spiders!You have left: " + healthpoint + "health point!");
        }else{
            System.out.println("Please choose invalid choice!");
        }


        int correctCode=7890;
        int attempts=3;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("You find a safe with a Golden Key inside!");
        System.out.println("WARNING!!:If you find code you'll escape or not you will be trapped forever!!!");
        System.out.println("Enter the 4-digit code to unlock it:");

        while (attempts>0){
            System.out.println("Guess the number! Attempts left: " + attempts);
            int guess = scanner.nextInt();

            if(guess==correctCode){
                System.out.println("Congratulations! You guessed the correct code and escaped!");
                hasKey=true;
                break;
            }else{
                attempts--;
                if (attempts>0){
                    System.out.println("Wrong guess! Try again. Attempts left: " + attempts);
                } else {
                    System.out.println("Game Over! You are trapped forever!");
                }
            }

        }

        System.out.println(hasKey
                ? "🎊 You use the Golden Key and escape the castle! YOU WIN! 🏆"
                : "😱 You failed to find the key. You are trapped forever!");




    }
}
