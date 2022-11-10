import java.awt.*;

public class PingPongScore extends Rectangle {

    //declaring the variables
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int playerA;
    int playerB;

    // creating a constructor
    PingPongScore(int GAME_WIDTH, int GAME_HEIGHT) {

        PingPongScore.GAME_WIDTH = GAME_WIDTH;
        PingPongScore.GAME_HEIGHT = GAME_HEIGHT;

    }

    // method to show the score
    public void draw(Graphics g) {

        g.setColor(Color.white);
        g.setFont(new Font("Consoles", Font.PLAIN, 60));

        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);

        g.drawString(playerA / 10 + String.valueOf(playerA % 10), (GAME_WIDTH / 2) - 85, 50);
        g.drawString(playerB / 10 + String.valueOf(playerB % 10), (GAME_WIDTH / 2) + 20, 50);

    }

}
