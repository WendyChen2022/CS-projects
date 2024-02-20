package org.example;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalGames = 0;
        int totalGuesses = 0;
        int guess = 0;
        int bestGame = Integer.MAX_VALUE;

        do {
            guess = playGame(scanner, random);
            if(guess<bestGame){
                bestGame = guess;
            }
            totalGuesses += guess;
            totalGames++;
            System.out.print("Play again? ");
        } while (scanner.next().trim().toLowerCase().startsWith("y"));


        System.out.println("Your overall results:");
        System.out.println("Total games = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.printf("Guesses/game = %.1f\n", (double) totalGuesses / totalGames);
        System.out.println("Best game = " + bestGame);
    }

    private static int playGame(Scanner scanner, Random random) {
        int numberToGuess = random.nextInt(100) + 1;
        int guesses = 0;
        int guess;

        System.out.println("I'm thinking of a number between 1 and 100...");

        do {
            System.out.print("Your guess? ");
            guess = scanner.nextInt();
            guesses++;

            if (guess < numberToGuess) {
                System.out.println("It's higher.");
            } else if (guess > numberToGuess) {
                System.out.println("It's lower.");
            }
        } while (guess != numberToGuess);

        System.out.println("You guessed it in " + guesses + " guesses!");

        return guesses;
    }
}