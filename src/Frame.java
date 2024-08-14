import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Panel p = new Panel();

    public Frame() {
        this.setTitle("Sortierungen");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);
        this.add(p);
        this.setLayout(null);
        this.setVisible(true);

    }


}
