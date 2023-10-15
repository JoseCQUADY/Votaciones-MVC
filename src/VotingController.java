
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class VotingController {
    private VotingModel model;
    private VotingView votingView;
    private BarChartView barChartView;
    private PieChartView pieChartView;

    public VotingController(VotingModel model, VotingView votingView, BarChartView barChartView, PieChartView pieChartView) {
        this.model = model;
        this.votingView = votingView;
        this.barChartView = barChartView;
        this.pieChartView = pieChartView;

        for (int i = 0; i < model.getProductNames().size(); i++) {
            final int productIndex = i;
            votingView.addVoteButtonListener(e -> vote(productIndex), i);
        }
    }

    public void run() {
        
    }

    private void vote(int productIndex) {
        model.vote(productIndex);
        int[] votes = model.getVotes();
        votingView.updateResults(votes);
        barChartView.updateChart(model.getProductNames(), votes);
        pieChartView.updateChart(model.getProductNames(), votes);
        // Guardar la fecha y hora en un archivo
        saveVoteTimestamp(productIndex);
    }
    
     private void saveVoteTimestamp(int productIndex) {
        try {
            String productName = model.getProductNames().get(productIndex);
            Date timestamp = new Date(); // Obtener la fecha y hora actual
            String voteRecord = productName + ": " + timestamp.toString();
            
            // Nombre del archivo de votaciones (uno por producto)
            String fileName = productName + "_votaciones.txt";
            
            // Guardar en el archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(voteRecord);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
        }
    }
    
}
