import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class numberGuessr{

    private final static Scanner sc = new Scanner(System.in);
    private static int lives = 5;
    private final static String GUESSTEXT = "Guess the number (must be greater or equal to 0): ";
    private final static String TRYAGAINTEXT = "Try again :(";
    private final static String YOUWONTEXT = "YOU WON!";
    private final static String YOULOSTTEXT = "You lost :( The number was: ";
    private final static String MAXNUMBERTEXT = "Select the max number (0-n): ";
    private final static String NOTPOSITIVENUMBERTEXT = "Number must be greater or equal to 0, try again: ";
    private final static String INVALIDINPUTTEXT = "Invalid input. Please input a valid number: ";

    public static void main(String[] args){
        int maxNumber;
        int randomNumber;

        System.out.println(MAXNUMBERTEXT);

        maxNumber = sc.nextInt();
        randomNumber = generateNumber(maxNumber);

        while (lives > 0){
            System.out.println("You have " + lives + " lives.");
            System.out.println(GUESSTEXT);

            if (!tryGuess(randomNumber)){
                lives--;
                if (lives > 0){
                    System.out.println(TRYAGAINTEXT);
                }
                else{
                    System.out.println(YOULOSTTEXT + randomNumber);
                }
            }
            else{
                System.out.println(YOUWONTEXT);
                break;
            }
        }
    }

    private static int generateNumber(int max){
        Random random = new Random();

        return random.nextInt(max+1);
    }

    private static boolean tryGuess(int randomNumber){
        int guess;

        guess = readValidInteger();

        return guess == randomNumber;
    }

    private static int readValidInteger(){
        int guess;

        while (true){

            try{
                guess = sc.nextInt();

                if (guess >= 0){
                    return guess;
                }
                else{
                    System.out.println(NOTPOSITIVENUMBERTEXT);
                }
            }
            catch(InputMismatchException e){
                System.out.println(INVALIDINPUTTEXT);
                sc.next();
            }
        }
    }
}
