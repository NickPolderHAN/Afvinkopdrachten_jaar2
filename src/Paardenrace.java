import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Paardenrace extends JFrame implements ActionListener {

    JPanel racepanel = new JPanel();

    Graphics paper;

    JTextField horse_input = new JTextField();

    Boolean race_ended = false;

    HashMap<String, float[]> colors = new HashMap<>();

    public static void main(String[] args) {
        Paardenrace root = new Paardenrace();
        root.setTitle("Paardenrace");
        root.setSize(600, 600);
        root.setVisible(true);

        root.setup_gui();
    }

    private void setup_gui() {
        Container window = getContentPane();

        JPanel full_panel = new JPanel(new BorderLayout());
        JPanel bottompanel = new JPanel(new FlowLayout());

        JLabel input_text = new JLabel("Enter horse amount: (max 5 horses!)");

        JButton start_race = new JButton("Start Race:");
        start_race.addActionListener(this);

        horse_input.setColumns(10);

        bottompanel.add(input_text);
        bottompanel.add(horse_input);
        bottompanel.add(start_race);

        full_panel.add(racepanel, BorderLayout.CENTER);
        full_panel.add(bottompanel, BorderLayout.PAGE_END);

        window.add(full_panel);

    }

    private void setup_racers(int racers) {
        ArrayList<Paard> paardenlist = new ArrayList<>();
        int y_coords = 100;
        Random rand = new Random();

        //takes the amount of racers and creates that amount of horse instances.//
        paper.setColor(Color.gray);
        for (int i = 0; i < racers; i++) {
            Paard race_horse = new Paard(("Horse " + i));
            paardenlist.add(race_horse);

            //Generates a random color per horse.//
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            float[] rgb_list = {r, g, b};
            colors.put(Integer.toString(i), rgb_list);

            paper.fillRect(100, y_coords, 1, 100);
            y_coords += 150;
        }

        while (!race_ended) {
            int start_coords = 100;

            //Loops through all the horses.//
            for (Paard i : paardenlist) {
                int horse_num = paardenlist.indexOf(i);

                i.loop();
                int current_distance = i.getAfstand();

                float[] rgb_values = colors.get(Integer.toString(horse_num));
                Color randomColor = new Color(rgb_values[0], rgb_values[1], rgb_values[2]);
                paper.setColor(randomColor);

                paper.fillRect(100, start_coords, current_distance * 10, 100);
                start_coords += 150;

                if (current_distance > 100) {
                    horse_num++;
                    JOptionPane.showMessageDialog(null, ("Horse " + horse_num + " won the race!"));
                    race_ended = true;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paper = racepanel.getGraphics();

        //Draws the finish line.//
        paper.setColor(Color.red);
        paper.drawLine(1100, 80, 1100, 900);

        String text = horse_input.getText();
        int horses_amount = Integer.parseInt(text);
        if (horses_amount < 6 & horses_amount > 1) {
            setup_racers(horses_amount);
        }
        else {
            JOptionPane.showMessageDialog(null, "please enter a valid number between 2 and 5");
        }

    }
}
