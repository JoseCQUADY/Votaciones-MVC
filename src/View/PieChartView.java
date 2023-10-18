
package View;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.logging.Logger;

public class PieChartView {
    private JFrame frame;
    private ChartPanel chartPanel;
    private DefaultPieDataset dataset;
    private static final Logger logger = Test.Main.logger;


    public PieChartView() {
        frame = new JFrame("Gráfico de Pastel");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        dataset = new DefaultPieDataset();
        JFreeChart pieChart = createPieChart(dataset);

        chartPanel = new ChartPanel(pieChart);
        frame.add(chartPanel);

        frame.pack();
        frame.setVisible(true);
        
        logger.info("Desde PieChartView: PieChartView.");
    }

    public void updateChart(String[] productNames, int[] votes) {
        dataset.clear();

        for (int i = 0; i < productNames.length; i++) {
            dataset.setValue(productNames[i], votes[i]);
        }
        logger.info("Desde PieChartView: updateChart.");
    }

    private JFreeChart createPieChart(DefaultPieDataset dataset) {
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Resultados de Votación", dataset, true, true, false);

        logger.info("Desde PieChartView: createPieChart.");
        return pieChart;
    }

    public void closeWindow() {
        frame.dispose();
        logger.info("Desde PieChartView: closeWindow.");
    }
}
