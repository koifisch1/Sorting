import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel implements Runnable {
    public DrawPanel(int x, int y) {
        this.setSize(300, 300);

        this.setLocation(x, y);
        this.setLayout(null);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


    }

    @Override
    public void run() {


    }
}
