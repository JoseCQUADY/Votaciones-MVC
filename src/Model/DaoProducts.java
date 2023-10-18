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

public class DaoProducts {

    Product[] products = new Product[3];
    int voteCount = 0;
    private int[] votes = new int[3];

   
    public void assignProductNames(String productName, int index) {
        Product product = new Product();
        product.setProductName(productName);
        if (!product.getProductName().equals(productName)) {
            products[index] = product;
        }
    }

    public Product getProduct(int productIndex) {
        return products[productIndex];
    }

    public String[] getProductNames() {
        String[] productNames = new String[3];
        
            for ( int i=0; i < 3; i++) {              
                productNames[i] = products[i].getProductName();
            }
            return productNames;      
        }
    
    public int[] getProductVotes() {
        if(votes == null){
           for(int i=0;i<3;i++){
            votes[i]=0;
                    } 
                }
     return votes;
    }

    public void loadProductsFromFile() {
        String fileName = "productos.txt";
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
    }

    public void saveProductstoFile() {
        try {
            for (int i = 0; i < 3; i++) {
                String productName = products[i].getProductName();
                if (products[i].getProductName().equals(productName)) {
                    return;
                }
                String fileName = "productos.txt";
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.write(productName);
                writer.newLine();
                writer.close();
            }

        } catch (IOException e) {

        }
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
    }

    public void incrementProductVotes(int productIndex) throws IOException {
        if (productIndex >= 0 && productIndex < votes.length) {
            votes[productIndex]++;
        }
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
    }
}
