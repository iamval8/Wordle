import java.util.*;
public class WordleGame
{
    private String targetWord;
    private int attempts;
    private Scanner scan = new Scanner(System.in);

    // Constructor
    public WordleGame(String tWord)
    {
        this.targetWord = tWord.toLowerCase();
        this.attempts = 6;
    }
    public String guessWord(String guess)
    {
        guess = guess.toLowerCase();
        String feedback = "";
        for (int i = 0; i < guess.length(); i++)
        {
            char letter = guess.charAt(i);
            if (letter == targetWord.charAt(i))
            {
                feedback += "🟩"; // Correct letter and position
            }
            else if (targetWord.contains(String.valueOf(letter)))
            {
                feedback += "🟨"; // Correct letter, wrong position
            }
            else
            {
                feedback += "⬜"; // Incorrect letter
            }
        }
        return feedback;
    }


    // Method to check if game is over
    public boolean isGameOver()
    {
        return attempts == 0;
    }

    // Method to check if word is guessed correctly
    public boolean isWordGuessed(String guess)
    {
        return guess.equals(targetWord);
    }

    // Method to validate the guess
    private boolean isValidGuess(String guess)
    {
       return guess.length() == 5 && guess.matches("[a-zA-Z]+");
    }
    public void playGame()
    {
        while (!(this.isGameOver()))
        {
            System.out.print("Enter your guess: ");
            String guess = scan.nextLine();
            if (this.isValidGuess(guess))
            {
                attempts--;
                System.out.println(guessWord(guess));
                if (this.isWordGuessed(guess))
                {
                    System.out.println("Good job! You guessed the word with " + attempts + " attempts left!");
                    break;
                }
                else if (!(this.isWordGuessed(guess)))
                {
                    System.out.println("That's not it. You have " + attempts + " attempts left.");
                }
            }
            else if (!(this.isValidGuess(guess)))
            {
                System.out.println("Guess is invalid. Please try again. ");
            }
        }
        if (this.isGameOver())
        {
            System.out.println("You ran out of tries! Game Over. The word was: " + targetWord + "!");
        }
    }
}
