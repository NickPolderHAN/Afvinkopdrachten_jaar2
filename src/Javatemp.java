import javax.swing.*;
import java.awt.*;

public class Javatemp {

    public static void setup() {
        System.out.println("hi");
    }

    private class Gpanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(100,100,50,50);
        }
    }

    public static void main(String[] args) {
        JFrame root = new JFrame("Watermolecule Nick");
        setup();
        root.setSize(800, 560);
        root.setVisible(true);
    }
}
