
package Model;


public class Product {
    private String productName;
    private int productVotes;

    public Product() {
        this.productName = "";
        this.productVotes = 0;
    }

    public String getProductName() {   
            return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductVotes() {
        return productVotes;
    }

    public void setProductVotes() {
        this.productVotes = productVotes++;
    }
    
    
    
    
    
    
}
