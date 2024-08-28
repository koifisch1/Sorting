import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ComparePanel extends JPanel implements ActionListener {
    DrawPanel panel1;
    DrawPanel panel2;
    JButton srtatButton;
    JComboBox chooser1, chooser2;

    public ComparePanel() {
        this.setSize(1000, 500);
        this.setLocation(0, 0);
        this.setLayout(null);
        chooser1 = new JComboBox();
        chooser1.addItem("Bubble");
        chooser1.addItem("Selection");
        chooser1.addItem("Insertion");
        chooser1.addItem("Radix");
        chooser1.addItem("Merge");
        chooser1.setSize(100, 30);
        chooser2 = new JComboBox<>();
        chooser2.addItem("Bubble");
        chooser2.addItem("Selection");
        chooser2.addItem("Insertion");
        chooser2.addItem("Radix");
        chooser2.addItem("Merge");
        chooser2.setSize(100, 30);
        JLabel time1 = new JLabel();
        JLabel time2 = new JLabel();
        time1.setSize(100, 50);
        time2.setSize(100, 50);
        time1.setLocation(400, 150);
        time2.setLocation(900, 150);
        chooser1.setLocation(400, 100);
        chooser2.setLocation(900, 100);

        panel1 = new DrawPanel(300, 300, time1);
        panel2 = new DrawPanel(300, 300, time2);
        panel1.setLocation(100, 100);
        panel2.setLocation(600, 100);
        this.add(panel1);
        this.add(panel2);
        srtatButton = new JButton();
        srtatButton.setText("Start");
        srtatButton.setLocation(300, 400);
        srtatButton.setSize(400, 50);
        srtatButton.addActionListener(this);
        JButton timer = new JButton("Timer?");
        timer.addActionListener(this);
        this.add(chooser2);
        this.add(chooser1);
        this.add(srtatButton);
        this.add(time1);
        this.add(time2);

        int[] zahlen = Randomize(300);
        panel1.setDaten(zahlen.clone());
        panel2.setDaten(zahlen.clone());
        this.add(timer);
        timer.setLocation(400, 0);
        timer.setSize(200, 100);
        this.setVisible(true);
    }

    private int[] Randomize(int n) {

        Random r = new Random();
        int[] datne = new int[n];
        for (int i = 0; i < n; i++) {
            datne[i] = r.nextInt(300);

        }
        return datne;


    }

    Thread t1 = new Thread(panel1);
    Thread t2 = new Thread(panel2);

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(srtatButton)) {
            panel1.setSource(chooser1.getSelectedIndex());
            panel2.setSource(chooser2.getSelectedIndex());
            if (t2.isAlive() || t1.isAlive()) return;
            int[] zahlen = Randomize(300);
            panel1.setDaten(zahlen.clone());
            panel2.setDaten(zahlen.clone());
            panel1.setHeatmap(new int[300]);
            panel2.setHeatmap(new int[300]);
            t1 = new Thread(panel1);
            t2 = new Thread(panel2);
            t1.start();
            t2.start();

        } else {
            panel1.setTimer(!panel1.isTimer());
            panel2.setTimer(!panel2.isTimer());

        }
    }
}
