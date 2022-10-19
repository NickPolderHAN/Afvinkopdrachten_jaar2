import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Afvink5op2 extends JFrame implements DocumentListener {
    JTextField phrase_search = new JTextField();

    public static void main(String[] args) {
        Afvink5op2 root = new Afvink5op2();
        root.setSize(600, 600);
        root.setup_gui();
        root.setVisible(true);
    }

    public void setup_gui() {
        Container window = getContentPane();

        JPanel fullpanel = new JPanel();

        phrase_search.setColumns(20);
        phrase_search.getDocument().addDocumentListener(this);

        fullpanel.add(phrase_search);
        window.add(fullpanel);
    }
    public void text_changed() {
        String phrase = phrase_search.getText();
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        text_changed();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        text_changed();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        text_changed();
    }
}

