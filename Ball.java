import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ball {
    private int triesCount = 0;
    private int position = 0;
    private int resolveCharCount = 0;
    //Arraylist for storing colours of balls
    ArrayList<Character> balls = new ArrayList<>(Arrays.asList('-', '-', '-', '-', '-', '-', '-', '-','-', '-', '-', '-',
            '-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-',
            '-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-'));

    //Arraylist of storing marks of user attempts
    ArrayList<Character> resolveChar = new ArrayList<>(Arrays.asList('-', '-', '-', '-', '-', '-', '-', '-','-', '-', '-', '-',
            '-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-',
            '-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-','-', '-', '-', '-'));
    //Arraylist for storing duplicities of input
    ArrayList<Character> duplicity = new ArrayList<>(Arrays.asList(' ', ' ', ' ', ' '));
    char[]dealt = new char[4];
    //Arraylist of possible colours in game
    ArrayList<Character> colours = new ArrayList<>(Arrays.asList('w', 'y', 'o', 'r', 'g', 'c', 'b', 'm'));
    //"white", "yellow", "orange", "red", "green", "cyan", "blue", "magenta"
    private String guess;
    private String deal = "";
    //constructor
    public Ball() {
    }

    public void setBall() {
        //for guessed colour balls store color in arraylist
        for (int i = 0; i < guess.length(); i++) {
            balls.set(position, guess.charAt(i));
            position++;
            PlayBoard.ball = balls;
            PlayBoard.resolve = resolveChar;
        }
    }

    public void randomBalls() {
        //select random 4 colours and store them via StringBuilder in String "dealt"
        for ( int i = 0; i < 4; i++ ) {
            int ballColour = (int) (Math.random() * colours.size());
            dealt[i] = colours.get(ballColour);
            colours.remove(ballColour);
            deal += dealt[i];
        }
        PlayBoard.ball = balls;
        PlayBoard.resolve = resolveChar;
        //System.out.println(deal + " testing"); //only for testing
    }

    public void guessBall() {
        Scanner scanner = new Scanner(System.in);
        guess = scanner.next();
        //guess = "rgby";
        if (validateInput()) {
            setBall();
        } else {
            System.out.println("Invalid input, please type again!");
            guessBall();
        }
    }

    public boolean validateInput() {
        if (guess.matches("[wyorgcbm]{4}$")) {
            return true;
        } else
            return false;
    }

    public boolean resolve() {
        //checking endgame with successful guess
        if (deal.equals(guess)) {
            PlayBoard.setAttempt();
            PlayBoard.setWon();
            System.out.println("You've won!");
            return false;
        } else {
            triesCount++;
            clearDuplicity();
            checkDuplicity();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guess.charAt(i) == deal.charAt(i)) {
                        duplicity.set(i, ' ');
                        resolveChar.set(resolveCharCount, '\u2713');
                        resolveCharCount++;
                        break;
                    //if there is duplicity, ignore the colour
                    } else if (duplicity.get(0) == '-' || duplicity.get(1) == '-' || duplicity.get(2) == '-') {
                        if (i == 0) {
                            duplicity.set(0, ' ');
                            resolveChar.set(resolveCharCount, ' ');
                            resolveCharCount++;
                            break;
                        } else if (i == 1) {
                            duplicity.set(1, ' ');
                            resolveChar.set(resolveCharCount, ' ');
                            resolveCharCount++;
                            break;
                        } else if (i == 2) {
                            duplicity.set(2, ' ');
                            resolveChar.set(resolveCharCount, ' ');
                            resolveCharCount++;
                            break;
                        } else
                            resolveChar.set(resolveCharCount, ' ');
                            resolveCharCount++;
                            break;
                    //if the colour is right but position not
                    } else if ((guess.charAt(i) == deal.charAt(j)) && i != j) {
                        resolveChar.set(resolveCharCount, '\u21b6');
                        resolveCharCount++;
                        break;
                    //when you reach end of input and don't find match
                    } else if (j == 3) {
                        resolveChar.set(resolveCharCount, ' ');
                        resolveCharCount++;
                        break;
                    }
                }
            }
            PlayBoard.isAttempt = true;
            System.out.println();
        }
        //checking endgame with attempts
        if (triesCount == 12) {
            System.out.println("Maximum tries reached, you have lost!");
            return false;
        } else
            return true;
    }

    //check for duplicities
    public void checkDuplicity() {
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(0) == guess.charAt(1)) {
                duplicity.add(0, '-');
            } else if (guess.charAt(0) == guess.charAt(2)) {
                duplicity.add(0, '-');
            } else if (guess.charAt(0) == guess.charAt(3)) {
                duplicity.add(0, '-');
            } else if (guess.charAt(1) == guess.charAt(2)) {
                duplicity.add(1, '-');
            } else if (guess.charAt(1) == guess.charAt(3)) {
                duplicity.add(1, '-');
            } else if (guess.charAt(2) == guess.charAt(3)) {
                duplicity.add(2, '-');
            }
        }
    }

    //clearing duplicity for next guess
    public void clearDuplicity() {
        duplicity.set(0, ' ');
        duplicity.set(1, ' ');
        duplicity.set(2, ' ');
    }

}