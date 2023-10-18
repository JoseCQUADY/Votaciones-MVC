
package Model;

import java.util.logging.Logger;


public class Product {
    private String productName;
    private int productVotes;
    private static final Logger logger = Test.Main.logger;

    public Product() {
        this.productName = "";
        this.productVotes = 0;
        logger.info("Desde Product: Product.");
    }

    public String getProductName() {
        logger.info("Desde Product: getProductName.");
        
        return productName;
    }

    public void setProductName(String productName) {
        logger.info("Desde Product: setProductName.");
        this.productName = productName;
    }

    public int getProductVotes() {
        logger.info("Desde Product: getProductVotes.");
        return productVotes;
    }

    public void setProductVotes() {
        this.productVotes = productVotes++;
        logger.info("Desde Product: setProductVotes.");
    }
    
    
    
    
    
    
}
