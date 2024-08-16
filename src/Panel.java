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
    private JButton d;
    private JButton e;
    private JButton f;
    private JToggleButton timer;
    private JLabel time;
    int[] daten = new int[300];

    public Panel() {
        this.setSize(500, 500);
        this.validate();
        this.setLayout(null);

        daten = Randomize(daten.length);
        a = new JButton();
        b = new JButton();
        c = new JButton();
        d = new JButton();
        e = new JButton();
        f = new JButton();
        timer = new JToggleButton();
        timer.setText("Timer?");
        timer.setLocation(350, 370);
        time = new JLabel();
        a.setLocation(350, 50);
        b.setLocation(350, 100);
        c.setLocation(350, 150);
        d.setLocation(350, 200);
        e.setLocation(350, 250);
        f.setLocation(350, 300);
        a.setSize(100, 50);
        b.setSize(100, 50);
        c.setSize(100, 50);
        d.setSize(100, 50);
        e.setSize(100, 50);
        f.setSize(100, 50);
        timer.setSize(100, 50);
        time.setSize(300, 30);
        time.setLocation(350, 10);
        a.setText("Neue Werte");
        b.setText("BubbleSort");
        c.setText("Insertion");
        d.setText("Radix");
        e.setText("Quick");
        f.setText("N/A");
        a.addMouseListener(this);
        b.addMouseListener(this);
        c.addMouseListener(this);
        d.addMouseListener(this);
        e.addMouseListener(this);
        f.addMouseListener(this);
        this.add(a);
        this.add(b);
        this.add(c);
        this.add(d);
        this.add(e);
        this.add(f);
        this.add(timer);
        this.add(time);
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
            if (timer.isSelected()) {
                double start = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    daten = Randomize(daten.length);
                    while (!isSorted(daten)) {
                        Bubble.step(daten);
                    }
                }

                time.setText(System.currentTimeMillis() - start + "ns");

            }
            while (!isSorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(3000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                Bubble.step(daten);
            }

        } else if (source.equals(c)) {
            Insetion insetion = new Insetion();
            if (timer.isSelected()) {
                double start = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    daten = Randomize(daten.length);
                    insetion = new Insetion();
                    while (!isSorted(daten)) {
                        insetion.step(daten);
                    }
                }

                time.setText(System.currentTimeMillis() - start + "ns");

            }
            while (!isSorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(3000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                insetion.step(daten);
            }
        } else if (source.equals(d)) {
            Radix r = new Radix();
            while (!isSorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(300000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                r.step(daten);

            }

        } else if (source.equals(e)) {
            Radix r = new Radix();
            while (!isSorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(300000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                r.step(daten);

            }

        } else if (source.equals(f)) {
            Radix r = new Radix();
            while (!isSorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(300000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                r.step(daten);

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
