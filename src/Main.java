
import java.util.ArrayList;
import java.util.List;




public class Main {
    public static void main(String[] args) {
      List<String> productNames = new ArrayList<>();
        productNames.add("Producto A");
        productNames.add("Producto B");
        productNames.add("Producto C");

        VotingModel model = new VotingModel(productNames);
        VotingView votingView = new VotingView(productNames);
        BarChartView barChartView = new BarChartView();
        PieChartView pieChartView = new PieChartView();

        VotingController controller = new VotingController(model, votingView, barChartView, pieChartView);
        controller.run();
    }
}

