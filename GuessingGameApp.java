import java.util.Scanner;

class NumberGuessGame {
    static int totalGames = 0;
    static int gamesWon = 0;

    public static int generateSecretNumber() {
        return 1 + (int)(Math.random() * 100);
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            totalGames++;
            int secretNumber = generateSecretNumber();
            int attemptsAllowed = 5;
            int attemptsUsed = 0;
            boolean isGuessedCorrectly = false;

            System.out.println("\n New Game Started!");
            System.out.println("You have 5 attempts to guess the number between 1 and 100.");

            while (attemptsUsed < attemptsAllowed) {
                System.out.print("Attempt " + (attemptsUsed + 1) + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsUsed++;

                if (userGuess == secretNumber) {
                    gamesWon++;
                    System.out.println(" Congratulations! You guessed the correct number.");
                    System.out.println(" You won in " + attemptsUsed + " attempt(s).");
                    isGuessedCorrectly = true;
                    break;
                } else if (userGuess > secretNumber) {
                    System.out.println(" Too high!");
                } else {
                    System.out.println(" Too low!");
                }
            }

            if (!isGuessedCorrectly) {
                System.out.println(" You've used all attempts. The correct number was: " + secretNumber);
            }

            // Show options
            System.out.println("\nChoose an option:");
            System.out.println("1. Play Again");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();
            if (choice != 1) {
                playAgain = false;
            }
        }

        showFinalStats();
        scanner.close();
    }

    public static void showFinalStats() {
        System.out.println("\nGame Summary:");
        System.out.println("Total Games Played: " + totalGames);
        System.out.println("Games Won: " + gamesWon);
        System.out.println("Games Lost: " + (totalGames - gamesWon));
        int score = gamesWon * 100;
        System.out.println("Your Total Score: " + score);
    }
}

public class GuessingGameApp {
    public static void main(String[] args) {
        NumberGuessGame.playGame();
    }
}
