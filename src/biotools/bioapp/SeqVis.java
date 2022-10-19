package biotools.bioapp;

import bioseq.*;;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SeqVis extends JFrame implements ActionListener {

    private Character[] DNA_list = {'G', 'C', 'A', 'T'};
    private Character[] peptide_list = {};
    private boolean[] checklist = {false, false, false};
    private JButton search_button;
    private JButton visualize_button;
    private JTextField file_path_field;
    private JTextArea seq_area;


    public static void main(String[] args) {
        SeqVis instance = new SeqVis();
        instance.setTitle("Seqvisualizer");
        instance.setSize(400, 400);

        instance.setup_gui();
        instance.setVisible(true);
    }

    /**
     * Sets up all the GUI components and adds them to the main window.
     */
    public void setup_gui() {
        Container window = getContentPane();

        JPanel full_panel = new JPanel(new GridLayout(3, 3));
        JPanel top_panel = new JPanel();
        JPanel center_panel = new JPanel();
        JPanel bottom_panel = new JPanel();

        JLabel file_label = new JLabel("Chosen file:");
        JLabel seq_label = new JLabel("Sequence:");

        search_button = new JButton("Search file:");
        search_button.addActionListener(this);

        visualize_button = new JButton("Visualize:");
        visualize_button.addActionListener(this);

        file_path_field = new JTextField();
        file_path_field.setColumns(12);

        seq_area = new JTextArea();
        seq_area.setColumns(20);
        seq_area.setRows(15);
        seq_area.setLineWrap(true);

        top_panel.add(file_label);
        top_panel.add(file_path_field);
        top_panel.add(search_button);

        center_panel.add(seq_label);
        center_panel.add(seq_area);
        center_panel.add(visualize_button);

        full_panel.add(top_panel);
        full_panel.add(center_panel);
        full_panel.add(bottom_panel);
        window.add(full_panel);
    }

    /**
     * Method to open the given file and add its lines to the full_sequence_list Array.
     *
     * @param file_path -> contains a file path to be opened.
     * @return full_sequence_list -> list containing all the sequence parts
     * @throws FileNotFoundException -> (if the method fails to find the given file.)
     */
    public String[] open_file(String file_path) throws FileNotFoundException {
        File received_file = new File(file_path);
        Scanner sc = new Scanner(received_file);
        int counter = 0;
        String[] full_sequence_list = new String[20];

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            full_sequence_list[counter] = line;
            counter++;

            for (int i = 0; i < line.length(); i++) {
                if (Arrays.asList(DNA_list).contains(line.charAt(i))) {
                    checklist[0] = true;
                } else if (line.charAt(i) == 'U') {
                    checklist[1] = true;

                }
            }
        }
        return full_sequence_list;
    }

    /**
     * Takes a list of sequence parts as its input and turns them into a string using a String builder.
     * @param seq_list -> passed from the open_file method, contains all the parts of the full sequence.
     */
    public void complete_sequence(String[] seq_list) {
        StringBuilder full_sequence = new StringBuilder();

        for (String s : seq_list) {
            full_sequence.append(s);
        }

        if (checklist[0] && !checklist[1]) {
            bioseq.DNA dna_obj = new DNA();
            dna_obj.setSeq(full_sequence.toString());

            seq_area.setText(dna_obj.getSeq());

        } else if (checklist[1]) {
            bioseq.RNA rna_obj = new RNA();
            rna_obj.setSeq(full_sequence.toString());

            seq_area.setText(rna_obj.getSeq());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_button) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this);
            String file_path = fc.getSelectedFile().getAbsolutePath();

            file_path_field.setText(file_path);
        }
        else if (e.getSource() == visualize_button) {
            String[] sequence_list;
            try {
                sequence_list = open_file(file_path_field.getText());
            }
            catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            complete_sequence(sequence_list);
        }


    }
}
