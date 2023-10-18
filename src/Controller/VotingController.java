package Controller;

import Model.*;
import View.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VotingController {

    private DaoProducts daoProduct;
    private VotingView votingView;
    private BarChartView barChartView;
    private PieChartView pieChartView;

    public VotingController(DaoProducts daoProduct, VotingView votingView, BarChartView barChartView, PieChartView pieChartView) {
        this.votingView = votingView;
        this.barChartView = barChartView;
        this.pieChartView = pieChartView;
        this.daoProduct = daoProduct;
        try {
            daoProduct.loadProductsFromFile();
            daoProduct.loadVotesFromFile();
        } catch (IOException e) {
            e.printStackTrace();

        }
        
        votingView.setLabel(daoProduct.getProductNames());
        votingView.updateResults(daoProduct.getProductVotes());
        barChartView.updateChart(daoProduct.getProductNames(), daoProduct.getProductVotes());
        pieChartView.updateChart(daoProduct.getProductNames(), daoProduct.getProductVotes());
        
        for (int i = 0; i <= 2; i++) {
            final int productIndex = i;

            votingView.addVoteButtonListener(e -> {
                try {
                    vote(productIndex);
                } catch (IOException ex) {
                    Logger.getLogger(VotingController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }, i);
        }

    }

    private void vote(int productIndex) throws IOException {

        daoProduct.incrementProductVotes(productIndex);
        votingView.updateResults(daoProduct.getProductVotes());
        barChartView.updateChart(daoProduct.getProductNames(), daoProduct.getProductVotes());
        pieChartView.updateChart(daoProduct.getProductNames(), daoProduct.getProductVotes());

        // Guardar la fecha y hora en un archivo
        daoProduct.saveVoteTimestamp(productIndex);
    }

}
