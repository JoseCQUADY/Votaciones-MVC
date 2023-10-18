package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Model.DaoProducts;
import View.BarChartView;
import View.PieChartView;
import java.util.logging.Logger;
import View.SetProductNamesView;
import View.VotingView;

public class SetProductNamesController {
    private static final Logger logger = Test.Main.logger;
    private DaoProducts daoProducts;
    private SetProductNamesView setProductNamesView;

    public SetProductNamesController(DaoProducts daoProducts, SetProductNamesView setProductNamesView){
        this.daoProducts = daoProducts;
        this.setProductNamesView = setProductNamesView;
        
        

        setProductNamesView.getFrame().setVisible(true);
            
                setProductNamesView.saveNamesButtonListener(e->{
                    daoProducts.saveProductstoFile(setProductNamesView);
                    JOptionPane.showMessageDialog(setProductNamesView.getFrame(),
                            "Los cambios requieren reflejaran una vez haya reiniciado el programa");
                    setProductNamesView.closeWindow();
                }); 
                logger.info("Desde setProductNamesController: setProductNamesCOntroller.");
    }
   
}

