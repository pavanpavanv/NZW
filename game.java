import java.util.Random;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Define the range and the number of attempts
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;

        // Generate a random number within the specified range
        int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + minRange + " and " + maxRange);
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        int attempts = 0;
        boolean guessedCorrectly = false;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                guessedCorrectly = true;
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You've guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
        }

        scanner.close();
    }
}
