package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import View.SetProductNamesView;

public class DaoProducts {

    Product[] products = new Product[3];
    int voteCount = 0;
    private int[] votes = new int[3];
    private static final Logger logger = Test.Main.logger;
    private final String fileName = "producto.txt";

    public Product getProduct(int productIndex) {
        logger.info("Desde DaoProducts: getProduct.");
        return products[productIndex];
    }

    public String[] getProductNames() {
        String[] productNames = new String[3];

        for (int i = 0; i < 3; i++) {
            productNames[i] = products[i].getProductName();
        }

        logger.info("Desde DaoProducts: getProductNames.");
        return productNames;
    }

    public int[] getProductVotes() {
        logger.info("Desde DaoProducts: getProductVotes.");
        return votes;
    }
    public void loadProductsFromFile() {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                try {
                    Product product = new Product();
                    product.setProductName(line);
                    products[index] = product;

                    System.out.println(products[index].getProductName());
                    index++;
                } catch (NumberFormatException e) {
                    // Este metodo es para la bitacora logger.log(this.getClass().getSimpleName(), "Error en el formato de línea en el archivo de votación.");
                }
            }
            reader.close();
        } catch (IOException e) {

        }
        logger.info("Desde DaoProducts: loadProductsFromFile.");
    }


    public void loadVotesFromFile() throws IOException {
        for (int i = 0; i < 3; i++) {
            String productName = products[i].getProductName();
            String fileName = productName + "_votaciones.txt";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;

                int voteCount = 0;
                while ((line = reader.readLine()) != null) {
                    try {
                        voteCount++;
                    } catch (NumberFormatException e) {
                        // Manejo de excepciones si es necesario
                    }
                }
                reader.close();
                votes[i] = voteCount; // Actualiza el recuento de votos para el producto
            } catch (IOException e) {
                // Manejo de excepciones si es necesario
            }
        }
        logger.info("Desde DaoProducts: loadVotesFromFile.");
    }

    public void incrementProductVotes(int productIndex) throws IOException {
        if (productIndex >= 0 && productIndex < votes.length) {
            votes[productIndex]++;
        }
        logger.info("Desde DaoProducts: incrementProductVotes.");
    }
    public void saveProductstoFile(SetProductNamesView setProductNamesView) {
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
                
            }
        logger.info("Desde DaoProducts: saveProductstoFile.");
    }
    public void saveVoteTimestamp(int index) {
        try {
            String productName = products[index].getProductName();
            Date timestamp = new Date();
            String voteRecord = productName + ": " + timestamp.toString();

            String fileName = productName + "_votaciones.txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(voteRecord);
            writer.newLine();
            writer.close();
        } catch (IOException e) {

        }
        logger.info("Desde DaoProducts: saveVoteTimestamp.");
    }
    
    public boolean fileExist(String fileName){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                try {
                    Product product = new Product();
                    product.setProductName(line);
                    products[index] = product;

                    System.out.println(products[index].getProductName());
                    index++;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            reader.close();
        } catch (IOException e) {
            logger.info("Desde DaoProducts: fileExist.");
            return false;
        }
        logger.info("Desde DaoProducts: fileExist.");
        return true;
    }
}
