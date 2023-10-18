package Test;


import Controller.*;
import View.*;
import Model.*;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class Main {
    public static final Logger logger = Logger.getLogger("MiAplicacion");
    public static final String fileName = "productos.txt";
    
    public static void main(String[] args) throws IOException {
        try {
            FileHandler fileHandler = new FileHandler("bitacora.txt");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        
        DaoProducts daoProduct = new DaoProducts();
        
        
        if(daoProduct.fileExist(fileName) == true){
            VotingView votingView = new VotingView();
        BarChartView barChartView = new BarChartView();
        PieChartView pieChartView = new PieChartView();
            VotingController controller = new VotingController(daoProduct, votingView, barChartView, pieChartView);
        }else if(daoProduct.fileExist(fileName)== false){
            SetProductNamesView productNamesView = new SetProductNamesView();
        SetProductNamesController productNamesController = new SetProductNamesController(daoProduct, productNamesView);
        }
                
    }
}

