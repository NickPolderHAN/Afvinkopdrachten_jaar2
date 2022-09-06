import javax.swing.*;
import java.awt.*;

public class App {
    private JTextField xValue;
    public JPanel panel1;
    private JTextField yValue;
    private JButton createButton;
    private JPanel Canvaspanel;

    public App() {
        createButton.addActionListener(e -> {
            //Gets the text from the x and y JTextFields.//
            String valueForX = xValue.getText();
            String valueForY = yValue.getText();

            //Converts the strings from the JTextFields to integers//
            int x_coords = Integer.parseInt(valueForX);
            int y_coords = Integer.parseInt(valueForY);
        });
    }

    public static void main(String[] args) {
        JFrame root = new JFrame("App");
        root.setContentPane(new App().panel1);
        root.setSize(800, 560);
        root.setVisible(true);

    }
}