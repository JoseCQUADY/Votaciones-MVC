import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VotingView {
    private JFrame frame;
    private JLabel[] productLabels;
    private JButton[] voteButtons;
    private JLabel[] voteCountLabels;

    public VotingView(List<String> productNames) {
        frame = new JFrame("Votación de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(productNames.size() + 1, 3));

        productLabels = new JLabel[productNames.size()];
        voteButtons = new JButton[productNames.size()];
        voteCountLabels = new JLabel[productNames.size()];

        for (int i = 0; i < productNames.size(); i++) {
            productLabels[i] = new JLabel(productNames.get(i));
            voteButtons[i] = new JButton("Votar");
            voteCountLabels[i] = new JLabel("0");

            frame.add(productLabels[i]);
            frame.add(voteButtons[i]);
            frame.add(voteCountLabels[i]);
        }

        frame.pack();
        frame.setVisible(true);
    }

    public void addVoteButtonListener(ActionListener listener, int index) {
        voteButtons[index].addActionListener(listener);
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
