package Controller;

import Model.*;
import View.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VotingController {

    private DaoProducts daoProduct;
    private VotingView votingView;
    private BarChartView barChartView;
    private PieChartView pieChartView;
    private SetProductNamesView setProductNamesView;

    public VotingController(DaoProducts daoProduct, VotingView votingView, BarChartView barChartView, PieChartView pieChartView,SetProductNamesView setProductNamesView) {
        this.votingView = votingView;
        this.barChartView = barChartView;
        this.pieChartView = pieChartView;
        this.daoProduct = daoProduct;
        this.setProductNamesView = setProductNamesView;
        
        try{
            daoProduct.loadProductsFromFile();
            
            //boolean voteDataComplete = daoProduct.getProductNames()!=null;
            //if(voteDataComplete == false){
                setProductNamesView.getFrame().setVisible(true);
                setProductNamesView.saveNamesButtonListener(e->{
                    try{
                        saveProductNames();
                    }catch(IOException ex){
                        ex.getStackTrace();
                    }
                }); 
            //}
            daoProduct.loadVotesFromFile();
            }catch(IOException ex){
            ex.getStackTrace();
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
    private void saveProductNames()throws IOException{
        try {
            String product1 = setProductNamesView.getTextField1().getText();
            String product2 = setProductNamesView.getTextField2().getText();
            String product3 = setProductNamesView.getTextField3().getText();
            
            BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"));
            writer.write(product1 + "\n");
            writer.write(product2 + "\n");
            writer.write(product3 + "\n");
            JOptionPane.showMessageDialog(setProductNamesView.getFrame(), "Datos guardados exitosamente.");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(VotingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
