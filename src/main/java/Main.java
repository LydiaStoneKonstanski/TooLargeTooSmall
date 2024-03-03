import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int lastGuess;
    public static void main(String[] args){
        guessingNumberGame();

    }
    public static void guessingNumberGame(){

        int maxNumber = getMaxNumber();
        int maxGuesses = getMaxGuesses();
        int randomNumber = generateRandomNumber(maxNumber);

    //Loop starts here
    int guessCounter = 0;
    boolean didIWin = false; //default if all guesses are used
  while (guessCounter <= maxGuesses){ //counts up
        guessCounter++;
        int userGuess = getUserGuess();
        if (userGuess < randomNumber){
            System.out.println("Too low!");
        }
        else if (userGuess > randomNumber){
            System.out.println("Too high!");
        }
        else {
            didIWin = true;
            break; //without the break it keeps guessing
        }
    }

  if (didIWin){
      System.out.println("Congrats! You won! You guessed " + guessCounter + " times." );
    }
  else {
        System.out.println("Sorry, you are all out of guesses. My number was" + randomNumber );
    }

}

    private static int getUserGuess() {
        System.out.println("Type your best guess!");
        int userGuess = Integer.parseInt(scanner.nextLine());
        if (userGuess == lastGuess){
            return getUserGuess();
        }
        lastGuess = userGuess;
        return userGuess;
    }

    private static int generateRandomNumber(int maxNumber) {
        double random = Math.random();

        int r2 = (int) Math.ceil(random * maxNumber);

        return r2;
    }

    private static int getMaxGuesses() {
        System.out.println("How many times would you like to guess?");
        int maxGuesses = Integer.parseInt(scanner.nextLine());
        return maxGuesses;
    }

    private static int getMaxNumber() {
        System.out.println("Welcome to my number guessing game! What should the highest number be?");
        int maxNumber = Integer.parseInt(scanner.nextLine());
        return maxNumber;
    }

}
