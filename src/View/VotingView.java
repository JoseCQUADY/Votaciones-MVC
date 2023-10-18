package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class VotingView {

    private JFrame frame;
    private JLabel[] productLabels;
    private JButton[] voteButtons;
    private JLabel[] voteCountLabels;
    private static final Logger logger = Test.Main.logger;

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
        
        logger.info("Desde VotingView: VotingView.");
    }

    public void addVoteButtonListener(ActionListener listener, int index) {
        voteButtons[index].addActionListener(listener);
        logger.info("Desde VotingView: addVoteButtonListener.");
    }

    public void setLabel(String[] productName) {
        for (int i = 0; i < productName.length; i++) {
            productLabels[i].setText(productName[i]);
        }
        logger.info("Desde VotingView: setLabel.");
    }

    public void updateResults(int[] votes) {
        for (int i = 0; i < votes.length; i++) {
            voteCountLabels[i].setText(Integer.toString(votes[i]));
        }
        logger.info("Desde VotingView: updateResults.");
    }

    public void closeWindow() {
        frame.dispose();
        logger.info("Desde VotingView: closeWindow.");
    }
}
