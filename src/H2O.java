import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class H2O extends JFrame implements ActionListener {

    JTextField xfield;
    JTextField yfield;
    JButton button;
    JPanel panel;

    public static void main(String[] args) {
        H2O frame = new H2O();
        frame.setTitle("Watermolecule Nick");
        frame.setSize(600,600);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        xfield = new JTextField("Typ hier iets");
        window.add(xfield);

        yfield = new JTextField("Typ hier iets");
        window.add(yfield);

        button = new JButton("Klik");
        window.add(button);
        button.addActionListener(this);

        panel = new JPanel(); // init panel
        panel.setPreferredSize(new Dimension(300,300));
        panel.setBackground(Color.GRAY);
        window.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics paper = panel.getGraphics();
        paper.clearRect(0, 0, 300,300);

        String x_val = xfield.getText();
        String y_val = yfield.getText();
        int x_coords = Integer.parseInt(x_val);
        int y_coords = Integer.parseInt(y_val);
        int sizeH = 13;
        int sizeO = 20;

        paper.setColor(Color.BLACK);
        paper.drawLine(x_coords + 50 + sizeO / 2, y_coords - 50 + sizeO / 2, x_coords + sizeH / 2,
                y_coords + sizeH / 2);
        paper.drawLine(x_coords + 50 + sizeO / 2, y_coords + 50 + sizeO / 2, x_coords + sizeH / 2,
                y_coords + sizeH / 2);

        paper.setColor(Color.BLUE);
        paper.fillOval(x_coords + 50,y_coords - 50, sizeH, sizeH);
        paper.fillOval(x_coords + 50,y_coords + 50, sizeH, sizeH);

        paper.setColor(Color.RED);
        paper.fillOval(x_coords, y_coords, sizeO, sizeO);
    }
}