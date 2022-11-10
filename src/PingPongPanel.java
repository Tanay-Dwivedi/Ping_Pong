import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class PingPongPanel extends JPanel implements Runnable{


    // declaring some values
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * 0.5555);
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static  final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    PingPongPaddles paddleA;
    PingPongPaddles paddleB;
    PongBall ball;
    PingPongScore score;

    // creating a constructor
    PingPongPanel() {

        // adding the paddle properties
        newPaddles();
        newBall();
        score = new PingPongScore(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    // method to create a new ball on the screen
    public void newBall() {

    }

    // method to create a new paddles
    public void newPaddles() {

    }

    // method to paint on the screen
    public void paint(Graphics g) {

        // painting our game panel
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }

    // method to draw on the screen
    public void draw(Graphics g) {

    }

    // method to move objects
    public void move() {

    }

    // method to check collisions
    public void collision() {

    }

    // method to run the game
    public void run() {

        // creating the game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                move();
                collision();
                repaint();
                delta--;
            }
        }

    }

    // class for the action listener
    public class AL extends KeyAdapter {

        // method when the key is pressed
        public void keyPressed(KeyEvent e) {

        }

        // method when the key is released
        public void keyReleased(KeyEvent e) {

        }

    }

}
