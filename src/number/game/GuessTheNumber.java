/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author sswet
 */


import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int rounds = 0;
        int wins = 0;

        while (playAgain) {
            System.out.println("\nRound " + (rounds + 1) + ":");
            boolean roundWon = playGame(random, scanner);
            if (roundWon) {
                wins++;
            }
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nTotal Rounds: " + rounds);
        System.out.println("Total Wins: " + wins);
        System.out.println("Thanks for playing!");
    }

    public static boolean playGame(Random random, Scanner scanner) {
        int lowerBound = 1;
        int upperBound = 100;
        int randomNum = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int attempts = 0;
        int maxAttempts = 10;
        boolean guessedCorrectly = false;

        System.out.println("Guess the number between " + lowerBound + " and " + upperBound + "!");

        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNum) {
                System.out.println("Congratulations! You guessed the correct number!");
                guessedCorrectly = true;
            } else if (userGuess < randomNum) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attempts++;
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + randomNum + ".");
        }

        return guessedCorrectly;
    }
}
