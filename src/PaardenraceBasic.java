import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaardenraceBasic extends JFrame implements ActionListener {

    JPanel racepanel = new JPanel();

    Graphics paper;
    public static void main(String[] args) {
        PaardenraceBasic root = new PaardenraceBasic();
        root.setTitle("Paardenrace");
        root.setSize(600, 600);
        root.setVisible(true);

        root.setup_gui();
    }

    private void setup_gui() {
        Container window = getContentPane();

        JPanel full_panel = new JPanel(new BorderLayout());

        JButton start_race = new JButton("Start Race:");
        start_race.addActionListener(this);

        full_panel.add(racepanel, BorderLayout.CENTER);
        full_panel.add(start_race, BorderLayout.PAGE_END);
        window.add(full_panel);

    }

    private void setup_racers() {
        Paard paard1 = new Paard("Paard 1");
        Paard paard2 = new Paard("Paard 2");

        while (paard1.getAfstand() < 100 & paard2.getAfstand() < 100) {
            //Updates the first horse its distance.//
            paard1.loop();
            int paard1_afstand = paard1.getAfstand() * 10;
            paper.fillRect(100, 100, paard1_afstand, 100);

            //Updates the second horse its distance.//
            paard2.loop();
            int paard2_afstand = paard2.getAfstand() * 10;
            paper.fillRect(100, 400, paard2_afstand, 100);
        }

        check_winner(paard1, paard2);
    }

    private void check_winner(Paard p1, Paard p2) {
        if (p1.getAfstand() > p2.getAfstand()) {
            JOptionPane.showMessageDialog(null, "Paard 1 heeft gewonnen!");
        }

        else {
            JOptionPane.showMessageDialog(null, "Paard 2 heeft gewonnen!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paper = racepanel.getGraphics();

        //Draws the finish line.//
        paper.setColor(Color.red);
        paper.drawLine(1100, 80, 1100, 800);

        //Draws the starting lines.//
        paper.setColor(Color.gray);
        paper.fillRect(100, 100, 1, 100);
        paper.fillRect(100, 400, 1, 100);

        paper.setColor(Color.RED);
        setup_racers();
    }
}
