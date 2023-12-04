import java.util.Scanner;

public class WordleGame {
    private String targetWord; // Word to be guessed
    private int attempts; // Number of attempts left

    private Scanner scan; // Scanner object for input

    // Constructor
    public WordleGame(String targetWord) {
        this.targetWord = targetWord.toLowerCase(); // Ensure target word is in lowercase for consistency
        this.attempts = 6; // Initialize attempts to 6
        this.scan = new Scanner(System.in); // Initialize scanner for input
    }

    // Method to guess the word and get feedback
    public String guessWord(String guess) {
        guess = guess.toLowerCase(); // Convert guess to lowercase for comparison
        if (!isValidGuess(guess)) {
            return "Invalid guess. Please enter a 5-letter word.";
        }

        String feedback = "";
        for (int i = 0; i < guess.length(); i++) {
            char letter = guess.charAt(i);
            if (letter == targetWord.charAt(i)) {
                feedback += "🟩"; // Correct letter and position
            } else if (targetWord.contains(String.valueOf(letter))) {
                feedback += "🟨"; // Correct letter, wrong position
            } else {
                feedback += "⬜"; // Incorrect letter
            }
        }
        attempts--;
        return feedback;
    }

    // Method to check if game is over
    public boolean isGameOver() {
        return attempts <= 0;
    }

    // Method to check if word is guessed correctly
    public boolean isWordGuessed(String guess) {
        return guess.equalsIgnoreCase(targetWord);
    }

    // Method to validate the guess
    private boolean isValidGuess(String guess) {
        return guess.length() == 5 && guess.matches("[a-zA-Z]+");
    }

    // Main game loop
    public void playGame() {

        while (attempts > 0) {
            System.out.print("Enter your guess (" + attempts + " attempts left): ");
            String guess = scan.nextLine();

            if (isValidGuess(guess)) {
                String feedback = guessWord(guess);
                System.out.println(feedback);
                if (isWordGuessed(guess)) {
                    System.out.println("Congratulations! You've guessed the word.");
                    return;
                }
            } else {
                System.out.println("Invalid guess. Please try a 5-letter word.");
            }
        }

        System.out.println("Game Over. The word was: " + targetWord);
    }

    // Main method to run the game
    public static void main(String[] args) {
        WordleGame game = new WordleGame("apple"); // Example target word
        game.playGame();
    }
}
