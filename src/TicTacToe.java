import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {

    int counter = 0;
    int currentplayer = 2;
    JLabel nowplaying = new JLabel("This is filler text!");

    ArrayList<JButton> buttonList = new ArrayList<>();

    public static void main(String[] args) {
        TicTacToe root = new TicTacToe();
        root.setTitle("TicTacToe game");
        root.setSize(600, 600);
        root.createGui();
        root.setVisible(true);
    }

    //Creates the base widgets for the game.//
    public void createGui() {
        Random randint = new Random();
        currentplayer = randint.nextInt(2);
        Container window = getContentPane();

        JPanel fullfield = new JPanel(new BorderLayout());
        JPanel upperfield = new JPanel();
        JPanel gameField = new JPanel(new GridLayout(3, 3));

        if (currentplayer == 0) {
            nowplaying.setText("O player is playing!");
        } else {
            nowplaying.setText("X player is playing!");
        }

        upperfield.add(nowplaying);

        //Creates the font used for the noughts and crosses.//
        Font font1 = new Font("SansSerif", Font.BOLD, 60);

        //Creates the 9 gamefield buttons in a loop.//
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            button.addActionListener(this);
            button.setFont(font1);
            buttonList.add(button);
        }

        for (JButton jButton : buttonList) {
            gameField.add(jButton);
        }

        fullfield.add(upperfield, BorderLayout.PAGE_START);
        fullfield.add(gameField, BorderLayout.CENTER);
        window.add(fullfield);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        JButton gotbutton = (JButton) e.getSource();

        String player = Integer.toString(currentplayer);

        if (player.equals("0")) {
            gotbutton.setText("O");
            gotbutton.setEnabled(false);
            currentplayer = 1;
            nowplaying.setText("X player is playing!");
        } else {
            gotbutton.setText("X");
            gotbutton.setEnabled(false);
            currentplayer = 0;
            nowplaying.setText("O player is playing!");
        }


        if (counter == 9) {
            reset_game();
            JOptionPane.showMessageDialog(null, "Draw!");
        }
        else {
            save_conditions();
        }
    }
    public void save_conditions() {
        String[] valuelist = {"", "", "", "", "", "", "", "", ""};
        int button_counter = 0;

        for (JButton jButton : buttonList) {
            valuelist[button_counter] = jButton.getText();
            button_counter = button_counter + 1;
        }

        String[] horizontalline1 = {valuelist[0], valuelist[1], valuelist[2]};
        String[] horizontalline2 = {valuelist[3], valuelist[4], valuelist[5]};
        String[] horizontalline3 = {valuelist[6], valuelist[7], valuelist[8]};

        String[] verticalline1 = {valuelist[0], valuelist[3], valuelist[6]};
        String[] verticalline2 = {valuelist[1], valuelist[4], valuelist[7]};
        String[] verticalline3 = {valuelist[2], valuelist[5], valuelist[8]};

        String[] diagonalline1 = {valuelist[0], valuelist[4], valuelist[8]};
        String[] diagonalline2 = {valuelist[2], valuelist[4], valuelist[6]};

        //Checks for a horizontal win.//
        check_conditions(horizontalline1);
        check_conditions(horizontalline2);
        check_conditions(horizontalline3);

        //Checks for a vertical win.//
        check_conditions(verticalline1);
        check_conditions(verticalline2);
        check_conditions(verticalline3);

        //Checks for a diagonal win.//
        check_conditions(diagonalline1);
        check_conditions(diagonalline2);
    }

    public void check_conditions(String[]condition_array) {
        String[] x_win = {"X", "X", "X"};
        String[] o_win = {"O", "O", "O"};

        if (Arrays.equals(condition_array, x_win)) {
            JOptionPane.showMessageDialog(null, "X wins!");
            reset_game();
        }
        else if (Arrays.equals(condition_array, o_win)) {
            JOptionPane.showMessageDialog(null, "O wins!");
            reset_game();
        }
    }

    public void reset_game() {
        for (JButton jButton : buttonList) {
            jButton.setEnabled(true);
            jButton.setText("");
            counter = 0;
        }
    }
}
