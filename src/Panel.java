import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Panel extends JPanel implements MouseListener {
    private final JButton neue;
    private final JButton bubble;
    private final JButton select;
    private final JButton radix;
    private final JButton merge;
    private final JButton insertion;
    private final JToggleButton timer;
    private final JLabel time;
    int[] daten = new int[300];

    public Panel() {
        this.setSize(500, 500);
        this.validate();
        this.setLayout(null);

        daten = Randomize(daten.length);
        neue = new JButton();
        bubble = new JButton();
        select = new JButton();
        radix = new JButton();
        merge = new JButton();
        insertion = new JButton();
        timer = new JToggleButton();
        timer.setText("Timer?");
        timer.setLocation(350, 370);
        time = new JLabel();
        neue.setLocation(350, 50);
        bubble.setLocation(350, 100);
        select.setLocation(350, 150);
        radix.setLocation(350, 200);
        merge.setLocation(350, 250);
        insertion.setLocation(350, 300);
        neue.setSize(100, 50);
        bubble.setSize(100, 50);
        select.setSize(100, 50);
        radix.setSize(100, 50);
        merge.setSize(100, 50);
        insertion.setSize(100, 50);
        timer.setSize(100, 50);
        time.setSize(300, 30);
        time.setLocation(350, 10);
        neue.setText("Neue Werte");
        bubble.setText("BubbleSort");
        select.setText("Selection");
        radix.setText("Radix");
        merge.setText("Merge");
        insertion.setText("Insertion");
        neue.addMouseListener(this);
        bubble.addMouseListener(this);
        select.addMouseListener(this);
        radix.addMouseListener(this);
        merge.addMouseListener(this);
        insertion.addMouseListener(this);
        this.add(neue);
        this.add(bubble);
        this.add(select);
        this.add(radix);
        this.add(merge);
        this.add(insertion);
        this.add(timer);
        this.add(time);
        this.setVisible(true);


    }

    private int[] heatmap;

    private int[] Randomize(int n) {
        heatmap = new int[n];
        Random r = new Random();
        int[] daten = new int[n];
        for (int i = 0; i < n; i++) {
            daten[i] = r.nextInt(300);
            heatmap[i] = 0;
        }
        return daten;


    }

    @Override
    public void mouseClicked(MouseEvent event) {
        Object source = event.getSource();
        event.consume();
        repaint();
        if (source.equals(neue)) {
            daten = Randomize(daten.length);


        } else if (source.equals(bubble)) {
            if (timer.isSelected()) {
                double start = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    daten = Randomize(daten.length);
                    while (notStorted(daten)) {
                        Bubble.step(heatmap, daten);
                    }
                }

                time.setText(System.currentTimeMillis() - start + "µs");

            }
            while (notStorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {

                    Thread.sleep(3000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                Bubble.step(heatmap, daten);
            }
            System.out.println();

        } else if (source.equals(select)) {
            Selection selection = new Selection();
            if (timer.isSelected()) {
                double start = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    daten = Randomize(daten.length);
                    selection = new Selection();
                    while (notStorted(daten)) {
                        selection.step(heatmap, daten);
                    }
                }

                time.setText(System.currentTimeMillis() - start + "µs");

            }
            while (notStorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(3000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                selection.step(heatmap, daten);
            }
        } else if (source.equals(radix)) {
            Radix r = new Radix();

            if (timer.isSelected()) {
                double start = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    daten = Randomize(daten.length);
                    r = new Radix();
                    while (notStorted(daten)) {
                        r.step(daten);
                    }
                }

                time.setText(System.currentTimeMillis() - start + "µs");

            }
            while (notStorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(300000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                r.step(daten);

            }

        } else if (source.equals(merge)) {

            if (timer.isSelected()) {
                double start = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    daten = Randomize(daten.length);
                    Merge.dealy = false;
                    Merge.sort(daten, 0, daten.length - 1,heatmap);
                    paintImmediately(0, 0, 500, 500);
                }

                time.setText(System.currentTimeMillis() - start + "µs");

            }
            while (notStorted(daten)) {
                Merge.dealy = true;
                Merge.daten0 = daten;
                Merge.heatmap0 = heatmap;
                Thread t = new Thread(new Merge());
                t.start();
                while (notStorted(Merge.daten0)) {

                    paintImmediately(0, 0, 500, 500);

                }


                paintImmediately(0, 0, 500, 500);

            }

        } else if (source.equals(insertion)) {

            Insetion n = new Insetion();
            if (timer.isSelected()) {
                double start = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    n = new Insetion();
                    daten = Randomize(daten.length);

                    while (notStorted(daten)) {
                        n.step(heatmap, daten);
                    }
                }

                time.setText(System.currentTimeMillis() - start + "µs");

            }
            while (notStorted(daten)) {
                paintImmediately(0, 0, 500, 500);
                try {
                    Thread.sleep(3000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                n.step(heatmap, daten);

            }
        }


    }

    private boolean notStorted(int[] daten) {
        for (int i = 1; i < daten.length; i++) {
            if (daten[i] < daten[i - 1]) return true;

        }
        return false;
    }

    public static double sigmoid(int x) {
        return ((1 / (1 + Math.exp((double) -x / 30))));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, 300, 300);
        for (int i = 0; i < daten.length; i++) {

            g.setColor(new Color((int) (255 - 255 * sigmoid(0)), (int) (255 - (255 * sigmoid(heatmap[i]))), (int) (255 - (255 * sigmoid(heatmap[i])))));
            g.fillRect(300 - (300 / daten.length) * i, 400 - daten[i], (300 / daten.length), daten[i]);
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
