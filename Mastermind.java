import java.util.Scanner;

public class Mastermind {
    Scanner scanner = new Scanner(System.in);
    boolean isActive;
    int option;
    PlayBoard board = new PlayBoard();

    public static void main(String[] args) {
        Mastermind game = new Mastermind();
        game.mastermindMenu();
    }

    public void mastermindGame() {
        System.out.println("New game");
        Ball ball = new Ball();
        ball.randomBalls();
        board.repaint();
        board.attempt = 0;
        PlayBoard.setNewGame();

        do {
            ball.guessBall();
            board.attempt++;
            board.repaint();
        } while ( ball.resolve() );
    }

    public void mastermindMenu() {
        do {
            displayMenu();
            option = getOption();
            if (option == 1) {
                mastermindGame();
            } else if (option == 2) {
                showRules();
            } else
                System.out.println("Invalid input, please type number from menu followed by ENTER");
        } while (isActive);
            mastermindMenu();

    }

    public int getOption() {
        System.out.println("Option: ");
        while (true) {
            try {
                return scanner.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input, try again.");
            }
        }
    }

    public void displayMenu() {
        System.out.println("\n\nMastermind game");
        System.out.println("\n____________________\n - Menu - \n");
        System.out.println("1 - Play new game");
        System.out.println("2 - Game rules");
    }

    public void showRules() {
        System.out.println("\n\nMastermind game");
        System.out.println("\n____________________\n - Rules - \n");
        System.out.println("You need to guess correct colour combination of 4 balls ");
        System.out.println("Color is represented with the first letter:");
        System.out.println("w = white, y = yellow, o = orange, r = red, g = green, c = cyan, b = blue, m = magenta");
        System.out.println("Correct input should looks like \"worg\" ");
    }

}
