package Test;


import Controller.*;
import View.*;
import Model.*;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;





public class Main {
    public static void main(String[] args) throws IOException {
        
        //Cambiar la estructura para productos , tiene que pedir los productos a registrar
        List<String> productNames = new ArrayList<>();
        productNames.add("Producto A");
        productNames.add("Producto B");
        productNames.add("Producto C");
        productNames.add("Producto D");
        
        //El modelo no debe pedir la lista de votos, debe haner un controlador para pedir
        
        DaoProducts daoProduct = new DaoProducts();
        
        VotingView votingView = new VotingView();
        BarChartView barChartView = new BarChartView();
        PieChartView pieChartView = new PieChartView();
        VotingController controller = new VotingController(daoProduct, votingView, barChartView, pieChartView);
                
    }
}

