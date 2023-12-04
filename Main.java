// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to today's Wordle!");
        System.out.print("Enter your name: ");
        String playerName = scan.nextLine();
        System.out.println("Welcome! " + playerName + " Let's play Wordle.");
        Player player = new Player(playerName);
        WordleGame game = new WordleGame("apple");
        game.playGame();
    }
}