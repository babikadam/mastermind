import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class PlayBoard extends JFrame {
    Color myGreen = new Color(45, 103, 20);
    static ArrayList<Character> ball = new ArrayList<>();
    static ArrayList<Character> resolve = new ArrayList<>();
    int attempt = 0;
    int nextPosition = 0;
    static boolean isAttempt = false;
    static boolean isWon = false;
    int posX;
    int posY;
    public PlayBoard() {
        setTitle("Mastermind game");
        setSize(750, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(myGreen);
        g2d.fillRoundRect(100, 100, 550, 700, 50, 50);

        //title
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 30));
        g2d.setPaint(Color.BLACK);
        g2d.drawString("Mastermind", 365, 150);
        //rules for game
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 17));
        g2d.setPaint(Color.BLACK);
        g2d.drawString("Guess the correct colour ", 365, 180);
        g2d.drawString("combination. ", 365, 200);
        g2d.drawString("Colours are not repeated.", 365, 220);
        g2d.drawString("Colours are not repeated.", 365, 220);
        g2d.drawString("MARKS", 430, 260);
        g2d.drawString('\u2713' + "correct colour and position", 365, 280);
        g2d.drawString('\u21b6' + "correct colour, wrong position", 365, 300);

        //text for possible colours
        g2d.drawString(" w for white", 420, 357);
        g2d.drawString(" y for yellow", 420, 387);
        g2d.drawString(" o for orange", 420, 417);
        g2d.drawString(" r for red", 420, 447);
        g2d.drawString(" g for green", 420, 477);
        g2d.drawString(" c for cyan", 420, 507);
        g2d.drawString(" b for blue", 420, 537);
        g2d.drawString(" m for magenta", 420, 567);

        //displaying possible colours
        g2d.setPaint(Color.WHITE);
        g2d.fillOval(400, 340, 20, 20);
        g2d.setPaint(Color.YELLOW);
        g2d.fillOval(400, 370, 20, 20);
        g2d.setPaint(Color.ORANGE);
        g2d.fillOval(400, 400, 20, 20);
        g2d.setPaint(Color.RED);
        g2d.fillOval(400, 430, 20, 20);
        g2d.setPaint(Color.GREEN);
        g2d.fillOval(400, 460, 20, 20);
        g2d.setPaint(Color.CYAN);
        g2d.fillOval(400, 490, 20, 20);
        g2d.setPaint(Color.BLUE);
        g2d.fillOval(400, 520, 20, 20);
        g2d.setPaint(Color.MAGENTA);
        g2d.fillOval(400, 550, 20, 20);



        //coloring balls and setting marks
        int position = 0;
        for (int i = 0; i < 12; i++) {                                      //y
            for (int j = 0; j < 4; j++) {                                   //x
                if (ball.isEmpty() || ball.get(position) == '-') {
                    g2d.setPaint(Color.BLACK);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                } else if (ball.get(position) == 'w') {
                    g2d.setPaint(Color.WHITE);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                    g2d.setPaint(Color.BLACK);
                    marks(position, i, j);
                    g2d.drawString("" + resolve.get(position).toString() , posX, posY);
                } else if (ball.get(position) == 'y') {
                    g2d.setPaint(Color.YELLOW);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                    g2d.setPaint(Color.BLACK);
                    marks(position, i, j);
                    g2d.drawString("" + resolve.get(position).toString() , posX, posY);
                } else if (ball.get(position) == 'o') {
                    g2d.setPaint(Color.ORANGE);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                    g2d.setPaint(Color.BLACK);
                    marks(position, i, j);
                    g2d.drawString("" + resolve.get(position).toString() , posX, posY);
                } else if (ball.get(position) == 'r') {
                    g2d.setPaint(Color.RED);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                    g2d.setPaint(Color.BLACK);
                    marks(position, i, j);
                    g2d.drawString("" + resolve.get(position).toString() , posX, posY);
                } else if (ball.get(position) == 'g') {
                    g2d.setPaint(Color.GREEN);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                    g2d.setPaint(Color.BLACK);
                    marks(position, i, j);
                    g2d.drawString("" + resolve.get(position).toString() , posX, posY);
                } else if (ball.get(position) == 'c') {
                    g2d.setPaint(Color.CYAN);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                    g2d.setPaint(Color.BLACK);
                    marks(position, i, j);
                    g2d.drawString("" + resolve.get(position).toString() , posX, posY);
                } else if (ball.get(position) == 'b') {
                    g2d.setPaint(Color.BLUE);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                    g2d.setPaint(Color.BLACK);
                    marks(position, i, j);
                    g2d.drawString("" + resolve.get(position).toString() , posX, posY);
                } else if (ball.get(position) == 'm') {
                    g2d.setPaint(Color.MAGENTA);
                    g2d.fillOval((170 + (j * 50)), (170 + (i * 50)), 20, 20);
                    g2d.setPaint(Color.BLACK);
                    marks(position, i, j);
                    g2d.drawString("" + resolve.get(position).toString() , posX, posY);
                }
                position++;

            }
            nextPosition = 0;
        }
        //System.out.println(resolve);  //testing only


        //endgame resolution + display counter
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g2d.drawString("ATTEMPTS LEFT: " + (12 - attempt), 400, 620);
        if (isWon) {
            g2d.setPaint(Color.BLACK);
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 23));
            g2d.drawString("You've WON!", 400, 650);
        } else if (attempt == 12) {
            g2d.setPaint(Color.BLACK);
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 23));
            g2d.drawString("You've LOST!", 400, 650);
        }
    }

    public static void setAttempt() {
        isAttempt = false;
    }

    public static void setWon() {
        isWon = true;
    }
    public static void setNewGame() {
        isWon = false;
    }

    //add marks to user attempt
    public void marks(int markPosition, int x, int y) {
        if (isAttempt) {
            //show how successful attempt was
            if (resolve.get(markPosition) == '\u21b6') {
                positions(x);
                nextPosition++;
            } else if (resolve.get(markPosition) == '\u2713') {
                positions(x);
                nextPosition++;
            }
        }
    }

    //getting correct positions for marks
    public void positions(int x) {
        if (nextPosition == 0) {
            posX = 130;
            posY = 180 + ((x) * 50);
        } else if (nextPosition == 1) {
            posX = 148;
            posY = 180 + ((x) * 50);
        } else if (nextPosition == 2) {
            posX = 130;
            posY = 195 + ((x) * 50);
        } else if (nextPosition == 3) {
            posX = 148;
            posY = 195 + ((x) * 50);
        }
    }

}
