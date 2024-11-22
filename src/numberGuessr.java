import java.util.Random;
import java.util.Scanner;

public class numberGuessr{

    private final static Scanner sc = new Scanner(System.in);
    private static int lives = 5;

    public static void main(String[] args){
        final String GUESSTEXT = "Guess the number: ";
        final String TRYAGAINTEXT = "Try again :(";
        final String YOUWONTEXT = "YOU WON!";
        final String YOULOSTTEXT = "You lost :(";
        final String MAXNUMBERTEXT = "Select the max number (0-n): ";
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
                    System.out.println(YOULOSTTEXT);
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

        guess = sc.nextInt();

        if (guess == randomNumber){
            return true;
        }

        return false;
    }
}
//TODO try-except