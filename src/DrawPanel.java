import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel implements Runnable {
    private int[] daten = new int[300];
    private int source = 0;
    private boolean timer = false;
    private final JLabel label;

    public void setHeatmap(int[] heatmap) {
        this.heatmap = heatmap;
    }

    public void setDaten(int[] daten) {
        this.daten = daten;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setTimer(boolean timer) {
        this.timer = timer;
    }

    public boolean isTimer() {
        return timer;
    }

    public DrawPanel(int x, int y, JLabel label) {

        this.setSize(300, 300);
        this.label = label;

        this.setLocation(x, y);
        this.setLayout(null);


    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.clearRect(0, 0, 300, 300);
        for (int i = 0; i < daten.length; i++) {

            g.setColor(new Color((int) (255 - 255 * Panel.sigmoid(0)), (int) (255 - (255 * Panel.sigmoid(heatmap[i]))), (int) (255 - (255 * Panel.sigmoid(heatmap[i])))));
            g.fillRect(300 - (300 / daten.length) * i, 400 - daten[i], (300 / daten.length), daten[i]);
        }

    }


    private int[] heatmap = new int[daten.length];

    @Override
    public void run() {

        repaint();
        if (source == 0) {
            if (timer) {
                double start = System.nanoTime();
                while (!isSorted(daten)) {
                    Bubble.step(heatmap, daten);
                }
                label.setText((int) ((System.nanoTime() - start) / 1000) + "µs");
            }
            while (!isSorted(daten)) {
                repaint();                Toolkit.getDefaultToolkit().sync();
                try {
                    Thread.sleep(5000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                Bubble.step(heatmap, daten);
            }
            System.out.println();

        } else if (source == 1) {
            Selection selection = new Selection();
            if (timer) {
                double start = System.nanoTime();

                while (!isSorted(daten)) {
                    selection.step(heatmap, daten);
                }
                label.setText((int) ((System.nanoTime() - start) / 1000) + "µs");

            }
            while (!isSorted(daten)) {
                selection.step(heatmap, daten);
                repaint();                Toolkit.getDefaultToolkit().sync();
                try {
                    Thread.sleep(5000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

            }
        } else if (source == 3) {
            Radix r = new Radix();

            if (timer) {
                double start = System.nanoTime();
                r = new Radix();
                while (!isSorted(daten)) {
                    r.step(daten);
                }
                label.setText((int) ((System.nanoTime() - start) / 1000) + "µs");

            }
            while (!isSorted(daten)) {
                r.step(daten);
                repaint();                Toolkit.getDefaultToolkit().sync();
                try {
                    Thread.sleep(300000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (source == 4) {

            if (timer) {
                double start = System.nanoTime();
                while (!isSorted(daten)) {
                    Quick.step(daten);
                }
                label.setText((int) ((System.nanoTime() - start) / 1000) + "µs");
            }
            while (!isSorted(daten)) {
                repaint();                Toolkit.getDefaultToolkit().sync();
                try {
                    Thread.sleep(5000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                Quick.step(daten);
            }
        } else if (source == 2) {

            Insetion n = new Insetion();
            if (timer) {
                double start = System.nanoTime();
                while (!isSorted(daten)) {
                    n.step(heatmap, daten);
                }
                label.setText((int) ((System.nanoTime() - start) / 1000) + "µs");
            }
            while (!isSorted(daten)) {
                repaint();
                Toolkit.getDefaultToolkit().sync();
                try {
                    Thread.sleep(5000 / daten.length);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                n.step(heatmap, daten);

            }
        }

        paintImmediately(0, 0, 300, 300);
    }

    private boolean isSorted(int[] daten) {
        for (int i = 1; i < daten.length; i++) {
            if (daten[i] < daten[i - 1]) return false;

        }
        return true;
    }


}
