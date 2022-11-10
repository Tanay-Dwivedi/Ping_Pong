import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class PingPongPanel extends JPanel implements Runnable {


    // declaring some values
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * 0.5555);
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
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
        score = new PingPongScore(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    // method to create a new ball on the screen
    public void newBall() {

        random = new Random();
        ball = new PongBall((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), random.nextInt(GAME_HEIGHT - BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);

    }

    // method to create a new paddles
    public void newPaddles() {

        // creating instances for paddles A and B
        paddleA = new PingPongPaddles(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddleB = new PingPongPaddles(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);

    }

    // method to paint on the screen
    public void paint(Graphics g) {

        // painting our game panel
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);

    }

    // method to draw on the screen
    public void draw(Graphics g) {

        paddleA.draw(g);
        paddleB.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync();

    }

    // method to move objects
    public void move() {

        paddleA.move();
        paddleB.move();
        ball.move();

    }

    // method to check collisions
    public void collision() {

        //bounce ball off top & bottom window edges
        if (ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }
        //bounce ball off paddles
        if (ball.intersects(paddleA)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if (ball.intersects(paddleB)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        //stops paddles at window edges
        if (paddleA.y <= 0)
            paddleA.y = 0;
        if (paddleA.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddleA.y = GAME_HEIGHT - PADDLE_HEIGHT;
        if (paddleB.y <= 0)
            paddleB.y = 0;
        if (paddleB.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
            paddleB.y = GAME_HEIGHT - PADDLE_HEIGHT;
        //give a player 1 point and creates new paddles & ball
        if (ball.x <= 0) {
            score.playerB++;
            newPaddles();
            newBall();
        }
        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.playerA++;
            newPaddles();
            newBall();
        }

    }

    // method to run the game
    public void run() {

        // creating the game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
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

            paddleA.keyPressed(e);
            paddleB.keyPressed(e);

        }

        // method when the key is released
        public void keyReleased(KeyEvent e) {

            paddleA.keyReleased(e);
            paddleB.keyReleased(e);

        }

    }

}
