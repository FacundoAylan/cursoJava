import java.util.Scanner;

public class App{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // Define the game variables here
        String secretWord = "java";
        int maxAttempts = 10;

        char[] guessedLetters = new char[secretWord.length()];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        // Game loop
        int attempts = 0;
        boolean wordGuessed = false;

        while (!wordGuessed && attempts < maxAttempts) {
            System.out.println("The word has " + secretWord.length() +" characters");
            System.err.println(String.valueOf(guessedLetters));
            System.out.print("Enter a letter: ");
            char letter = scanner.nextLine().charAt(0);

            boolean correctGuess = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    correctGuess = true;
                }
            }

            if(String.valueOf(guessedLetters).equals(secretWord)) {
                wordGuessed = true;
                System.out.println("Congratulations! You've guessed the word: " + secretWord);
            }else if (!correctGuess) {
                attempts++;
                System.out.println("Incorrect! You have " + (maxAttempts - attempts) + " attempts left.");
            } else {
                System.out.println("Good guess!");
            }
        }

        if(!wordGuessed) {
            System.out.println("Sorry, you've run out of attempts. The word was: " + secretWord);
        }

        scanner.close();
        
    }
}