package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VotingView {

    private JFrame frame;
    private JLabel[] productLabels;
    private JButton[] voteButtons;
    private JLabel[] voteCountLabels;

    public VotingView() {
        frame = new JFrame("Votación de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        productLabels = new JLabel[3];
        voteButtons = new JButton[3];
        voteCountLabels = new JLabel[3];

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            productLabels[i] = new JLabel();
            voteButtons[i] = new JButton("Votar");
            voteCountLabels[i] = new JLabel("0");

            panel.add(productLabels[i]);
            panel.add(voteButtons[i]);
            panel.add(voteCountLabels[i]);
        }

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void addVoteButtonListener(ActionListener listener, int index) {
        voteButtons[index].addActionListener(listener);
    }

    public void setLabel(String[] productName) {
        for (int i = 0; i < productName.length; i++) {
            productLabels[i].setText(productName[i]);
        }
    }

    public void updateResults(int[] votes) {
        for (int i = 0; i < votes.length; i++) {
            voteCountLabels[i].setText(Integer.toString(votes[i]));
        }
    }

    public void closeWindow() {
        frame.dispose();
    }
}
