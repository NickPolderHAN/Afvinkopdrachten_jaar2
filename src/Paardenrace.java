import javax.swing.*;
import java.awt.*;

public class Paardenrace extends JFrame {

    public static void main(String[] args) {
        Paardenrace root = new Paardenrace();
        root.setTitle("Paardenrace");
        root.setSize(600, 600);
        root.setVisible(true);
        root.setup_race();
    }

    public void setup_race() {
        Container window = getContentPane();

        JPanel centerpanel = new JPanel(new FlowLayout());

        JProgressBar progress1 = new JProgressBar();
        JProgressBar progress2 = new JProgressBar();

        progress1.setMaximum(60);
        progress2.setMaximum(60);

        progress1.setSize(240, 60);
        progress2.setSize(240, 60);

        progress1.setForeground(Color.red);
        progress2.setForeground(Color.CYAN);

        centerpanel.add(progress1);
        centerpanel.add(progress2);
        window.add(centerpanel);

        Paard paard1 = new Paard("Paard 1");
        Paard paard2 = new Paard("Paard 2");

        while (paard1.getAfstand() < 60 & paard2.getAfstand() < 60) {
            paard1.loop();
            progress1.setValue(paard1.getAfstand());

            paard2.loop();
            progress2.setValue(paard2.getAfstand());
        }

        check_winner(paard1, paard2);
    }
    public static void check_winner(Paard p1, Paard p2) {
        if (p1.getAfstand() > p2.getAfstand()) {
            JOptionPane.showMessageDialog(null, "Paard 1 heeft gewonnen!");
        }

        else {
            JOptionPane.showMessageDialog(null, "Paard 2 heeft gewonnen!");
        }
    }

}
