import javax.swing.*;
import java.awt.*;

public class PingPongFrame extends JFrame {

    // creating an instance of panel
    PingPongPanel pingPongPanel = new PingPongPanel();

    // creating a constructor
    PingPongFrame() {

        // adding the frame properties
        pingPongPanel = new PingPongPanel();
        this.add(pingPongPanel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

}
