import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel implements MouseListener {
    private JButton a;
    private JButton b;
    private JButton c;
    int[] daten=new int[100];

    public Panel() {
        this.setSize(500, 500);
        this.validate();
        this.setLayout(null);

        daten = Randomize(daten.length);
        a = new JButton();
        b = new JButton();
        c = new JButton();
        a.addMouseListener(this);
        this.add(a);
        this.add(b);
        this.add(c);

        this.setVisible(true);
    }

    private int[] Randomize(int n) {
        int[] datne = new int[n];
        for (int i = 0; i < n; i++) {
            datne[i] = (int) (300 * Math.random());
        }
        return datne;


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        e.consume();
        if (source.equals(a)) {
            daten = Randomize(daten.length);


        } else if (source.equals(b)) {
            Radix.step(daten);


        } else if (source.equals(c)) {


        }


    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < daten.length; i++) {
            g.fillRect((300/daten.length)*i,0,(300/daten.length),daten[i]);
        }

    }
    @Override
    public void mousePressed(MouseEvent e) {
//Ignored
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//ignored
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//Ignored
    }

    @Override
    public void mouseExited(MouseEvent e) {
//Ignored
    }
}
