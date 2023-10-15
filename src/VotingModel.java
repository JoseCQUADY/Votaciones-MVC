import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.List;

public class VotingModel {
    private List<String> productNames;
    private int[] votes;
    private BufferedWriter logFile;

    public VotingModel(List<String> productNames) {
        this.productNames = productNames;
        this.votes = new int[productNames.size()];

        try {
            logFile = new BufferedWriter(new FileWriter("log.txt", true));
        } catch (IOException e) {
        }
    }

   public List<String> getProductNames() {
        return productNames;
    }

    public int[] getVotes() {
        return votes;
    }

    public void vote(int productIndex) {
        if (productIndex >= 0 && productIndex < productNames.size()) {
            votes[productIndex]++;
            logVote(productIndex);
        }
    }

    private void logVote(int productIndex) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());
            logFile.write(timestamp + " - Model: Voto para producto " + productNames.get(productIndex) + "\n");
            logFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeLogFile() {
        try {
            logFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
