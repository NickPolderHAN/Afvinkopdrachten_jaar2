import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Afvink5op1 extends JFrame implements ActionListener {
    JTextField inputfield = new JTextField();
    JTextField output_label = new JTextField();

    public static void main(String[] args) {
        Afvink5op1 root = new Afvink5op1();
        root.setup_gui();
        root.setSize(600, 600);

        root.setVisible(true);
    }
    public void setup_gui() {
        Container window = getContentPane();

        JPanel fullpanel = new JPanel();

        JButton translate_button = new JButton("Translate:");
        translate_button.addActionListener(this);

        inputfield.setColumns(10);
        output_label.setColumns(10);

        fullpanel.add(inputfield);
        fullpanel.add(translate_button);
        fullpanel.add(output_label);
        window.add(fullpanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sequence_input = inputfield.getText();
        StringBuilder full_letter_code = new StringBuilder();

        for (int i = 0; i < sequence_input.length(); i++) {
            char letter = sequence_input.charAt(i);
            try {
                String code = Translator.one2three(letter);
                full_letter_code.append(code);
                if (i != sequence_input.length() - 1) {
                    full_letter_code.append("-");
                }
            }

            catch (NotAnAA ex) {
                throw new RuntimeException(ex);
            }
        }
        output_label.setText(full_letter_code.toString());

    }
}
