import java.awt.*;
import java.awt.event.KeyEvent;

public class PingPongPaddles extends Rectangle {

    // declaring the variables
    int id;
    int yVelocity;
    int speed = 10;

    // creating a constructor
    PingPongPaddles(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {

        // adding super constructors to the constructor
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;

    }

    // method when the key is pressed
    public void keyPressed(KeyEvent e) {

    }

    // method when the key is released
    public void keyReleased(KeyEvent e) {

    }

    // method to set the direction of Y axis
    public void setYDirection(int yDirection) {

    }

    // method to move the paddles
    public void move() {

    }

    // method to draw the paddles
    public void draw(Graphics g) {

        if(id==1)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);

    }

}
