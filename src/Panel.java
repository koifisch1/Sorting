import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JPanel implements MouseListener, Runnable {
    private JButton a;
    private JButton b;
    private JButton c;
    int[] daten = new int[300];

    public Panel() {
        this.setSize(500, 500);
        this.validate();
        this.setLayout(null);

        daten = Randomize(daten.length);
        a = new JButton();
        b = new JButton();
        c = new JButton();
        a.setLocation(350, 50);
        b.setLocation(350, 150);
        c.setLocation(350, 250);
        a.setSize(100, 50);
        b.setSize(100, 50);
        c.setSize(100, 50);
        a.setText("Neue Werte");
        b.setText("BubbleSort");
        a.addMouseListener(this);
        b.addMouseListener(this);
        c.addMouseListener(this);
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
        repaint();
        if (source.equals(a)) {
            daten = Randomize(daten.length);


        } else if (source.equals(b)) {
            while (!isSorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(3000/daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                Bubble.step(daten);
            }

        } else if (source.equals(c)) {
            Insetion i = new Insetion();
            while (!isSorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(3000/daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                i.step(daten);
            }
        }


    }

    private boolean isSorted(int[] daten) {
        for (int i = 1; i < daten.length; i++) {
            if (daten[i] < daten[i - 1]) return false;

        }
        return true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, 300, 300);
        for (int i = 0; i < daten.length; i++) {
            g.fillRect((300 / daten.length) * i, 0, (300 / daten.length), daten[i]);
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

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repaint();
        }
    }
}
