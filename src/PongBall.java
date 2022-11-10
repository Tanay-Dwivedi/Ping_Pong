import java.awt.*;
import java.util.Random;

public class PongBall extends Rectangle {

    // declaring the variables
    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 2;

    // creating a constructor
    PongBall(int x, int y, int width, int height) {

        super(x, y, width, height);
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if (randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection * initialSpeed);

        int randomYDirection = random.nextInt(2);
        if (randomYDirection == 0)
            randomYDirection--;
        setYDirection(randomYDirection * initialSpeed);

    }

    // method to set the direction of X axis
    public void setXDirection(int randomXDirection) {

        xVelocity = randomXDirection;

    }

    // method to set the direction of Y axis
    public void setYDirection(int randomYDirection) {

        yVelocity = randomYDirection;

    }

    // method to move the ball
    public void move() {

        x += xVelocity;
        y += yVelocity;

    }

    // method to draw the ball
    public void draw(Graphics g) {

        g.setColor(Color.white);
        g.fillOval(x, y, width, height);

    }

}
