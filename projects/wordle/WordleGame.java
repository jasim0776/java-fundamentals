import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordleGame {

    public static void main(String[] args) {
        
        // ANSI color codes
        String GREEN  = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String WHITE  = "\u001B[37m";
        String RESET  = "\u001B[0m";
        // =========================
        //  Validate arguments
        // =========================

        // We expect exactly one command-line argument
        if (args.length != 1) {
            System.out.println("Please provide a word index as a command-line argument.");
            return;
        }

        int wordIndex;

        // Try converting the argument into an integer
        try {
            wordIndex = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The word index must be a number.");
            return;
        }

        // =========================
        //  Read word list file
        // =========================

        // This list will store all words from the file
        List<String> words = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            // Open the file
            fileReader = new FileReader("wordle-words.txt");

            // Wrap it so we can read line by line
            bufferedReader = new BufferedReader(fileReader);

            // Read each line and add it to the list
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                words.add(line);
            }

        } catch (IOException e) {
            // File missing or unreadable
            System.out.println("Word list file not found.");
            return;
        }

        // =========================
        // Validate the index
        // =========================

        // Check if index is within valid range
        if (wordIndex < 0 || wordIndex >= words.size()) {
            System.out.println("Invalid word index.");
            return;
        }

        // =========================
        // Pick the secret word
        // =========================

        // Get the word at the given index
        // Trim removes extra spaces, lowercase makes comparisons easier later
        String secretWord = words.get(wordIndex).trim().toLowerCase(); 
        // =========================
        /* Read player guesses */
        // =========================

        // Create ONE Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Player gets up to 6 attempts
        int maxAttempts = 6;
        boolean won = false; 
        // Track which letters have been used (a–z)
        boolean[] usedLetters = new boolean[26];
        int attemptsUsed = 0;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {

            // Check for EOF before reading input
            if (!scanner.hasNextLine()) {
                // No more input (Ctrl+D / Ctrl+Z)
                break;
            }

            // Read the player's guess
            String guess = scanner.nextLine().trim().toLowerCase();

            // Check guess length
            if (guess.length() != 5) {
                System.out.println("Please enter a 5-letter word.");
                attempt--; // do not count this attempt
                continue;
            }

            attemptsUsed = attempt;

            // Mark guessed letters as used
            for (int i = 0; i < guess.length(); i++) {
                char c = guess.charAt(i);
                usedLetters[c - 'a'] = true;
            }

            // Compare guess with secret word (letter by letter)
            for (int i = 0; i < 5; i++) {

                char guessChar = guess.charAt(i);
                char secretChar = secretWord.charAt(i);

                if (guessChar == secretChar) {
                    // Correct letter, correct position → GREEN
                    System.out.print(GREEN + guessChar + RESET);
                } else if (secretWord.contains(String.valueOf(guessChar))) {
                    // Correct letter, wrong position → YELLOW
                    System.out.print(YELLOW + guessChar + RESET);
                } else {
                    // Letter not in word → WHITE
                    System.out.print(WHITE + guessChar + RESET);
                }
            }

            // Move to next line after printing feedback for one guess
            System.out.println();

            // Show remaining letters
            for (char c = 'a'; c <= 'z'; c++) {
                if (usedLetters[c - 'a']) {
                    System.out.print(Character.toUpperCase(c));
                } else {
                    System.out.print(c);
                }
            }
            System.out.println();

            // Check if the guess is exactly the secret word
            if (guess.equals(secretWord)) {
                System.out.println("You guessed the word!");
                won = true;
                break;
            }
        }

        if (!won) {
            System.out.println("You lost! The word was: " + secretWord);
        }

        // =========================
        // Write game stats to CSV
        // =========================

        String username = "player";
        String result;

        if (won) {
            result = "win";
        } else {
            result = "loss";
        }

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("stats.csv", true);

            fileWriter.write(username);
            fileWriter.write(",");
            fileWriter.write(secretWord);
            fileWriter.write(",");
            fileWriter.write(String.valueOf(attemptsUsed));
            fileWriter.write(",");
            fileWriter.write(result);
            fileWriter.write("\n");

            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Could not write stats file.");
        }
    }
}
