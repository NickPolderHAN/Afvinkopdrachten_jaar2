import javax.swing.*;
import java.awt.*;

public class H2O {
    public static class drawmolecule extends JPanel {
        public int x_val;
        public int y_val;
        @Override
        public void paint(Graphics g) {
            int x_value = 40 * 3;
            int y_value = 50 * 3;
            int width = 60 * 2;
            int height = 60 * 2;

            //Draws the Oxygen.//
            g.setColor(Color.BLUE);
            g.fillOval(x_value, y_value, width, height);

            //Draws the Hydrogen.//
            g.setColor(Color.red);
            g.fillOval(x_value + 160, y_value + 50 * 3, width - 12 * 3, height - 12 * 3);
            g.fillOval(x_value + 160, y_value - 40 * 3, width - 12 * 3, height - 12 * 3);

            //Draws lines between the atoms.//
            g.setColor(Color.BLACK);
            g.drawLine(x_value, y_value, x_value + 110, y_value + 40);
            g.drawLine(x_value, y_value, x_value + 110, y_value - 40);
        }
    }


    public static void main(String[] args) {
        JFrame root = new JFrame("Watermolecule Nick");
        root.setSize(800, 670);

        JPanel back_panel = new JPanel(new BorderLayout());
        JPanel fullPanel = new JPanel();

        JPanel canvas = new drawmolecule();
        fullPanel.setBackground(Color.BLACK);

        JButton drawButton = new JButton();

        JTextField x_input = new JTextField("x value");

        JTextField y_input = new JTextField("y value");

        fullPanel.add(x_input);
        fullPanel.add(y_input);
        fullPanel.add(drawButton);

        back_panel.add(canvas, BorderLayout.CENTER);
        back_panel.add(fullPanel, BorderLayout.PAGE_END);

        root.setContentPane(back_panel);
        root.setVisible(true);
    }
}
