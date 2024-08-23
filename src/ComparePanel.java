import javax.swing.*;

public class ComparePanel extends JPanel {
    public ComparePanel() {
        this.setSize(1000, 500);
        this.setLocation(0, 0);
        this.setLayout(null);
        JComboBox chooser1 = new JComboBox();
        chooser1.addItem("Bubble");
        chooser1.addItem("Selection");
        chooser1.addItem("Insertion");
        chooser1.addItem("Radix");
        chooser1.addItem("Quick");
        chooser1.setSize(100, 30);
        JComboBox chooser2 = new JComboBox<>();
        chooser2.addItem("Bubble");
        chooser2.addItem("Selection");
        chooser2.addItem("Insertion");
        chooser2.addItem("Radix");
        chooser2.addItem("Quick");
        chooser2.setSize(100, 30);

        chooser1.setLocation(400, 100);
        chooser2.setLocation(900, 100);

        DrawPanel panel1=new DrawPanel(300,300);
        DrawPanel panel2=new DrawPanel(300,300);
        panel1.setLocation(100,100);
        panel2.setLocation(600,100);
        this.add(panel1);
        this.add(panel2);





        this.add(chooser2);
        this.add(chooser1);
        this.setVisible(true);
    }
}
