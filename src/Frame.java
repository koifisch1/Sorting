import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    Panel p = new Panel();

    /**
     * erstellt den Frame auf welchem alles zu sehen sein soll
     */
    public Frame() {
        this.setTitle("Sortierungen");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);
        p.setLocation(0, 20);
        this.add(p);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        JButton a = new JButton();
        a.setLocation(0, 0);
        a.setSize(30, 30);
        a.setText("asd");
        a.setVisible(true);
        this.add(a);
        a.addActionListener(this);

    }

    private ComparePanel compare;

    /**
     * erstellt die panels welche die vergleiche durchführen
     */
    private void createComparePanels() {
        compare = new ComparePanel();
        this.add(compare);
    }

    /**
     * entfernt diej vergleichs panels wieder
     */
    private void removeComparepanels() {
        compare.setVisible(false);
        this.remove(compare);

    }

    /**
     * wechselt zwischen den ansichten
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (p.isVisible()) {
            p.setVisible(false);
            this.setSize(1000, 500);
            this.setLocationRelativeTo(null);
            createComparePanels();
        } else {
            removeComparepanels();
            p.setVisible(true);
            this.setSize(500, 500);
            this.setLocationRelativeTo(null);

        }
    }
}
