package Test;


import Controller.*;
import View.*;
import Model.*;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;





public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> array = new ArrayList<String>();
        array.add("papas");
        array.add("chetos");
        array.add("charritos");
        //El modelo no debe pedir la lista de votos, debe haner un controlador para pedir
        
        DaoProducts daoProduct = new DaoProducts();
        
        VotingView votingView = new VotingView();
        BarChartView barChartView = new BarChartView();
        PieChartView pieChartView = new PieChartView();
        SetProductNamesView setProductNamesView = new SetProductNamesView();
        VotingController controller = new VotingController(daoProduct, votingView, barChartView, pieChartView,setProductNamesView);
                
    }
}

