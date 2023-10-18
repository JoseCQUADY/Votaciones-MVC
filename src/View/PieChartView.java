
package View;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PieChartView {
    private JFrame frame;
    private ChartPanel chartPanel;
    private DefaultPieDataset dataset;

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
    }

    public void updateChart(String[] productNames, int[] votes) {
        dataset.clear();

        for (int i = 0; i < productNames.length; i++) {
            dataset.setValue(productNames[i], votes[i]);
        }
    }

    private JFreeChart createPieChart(DefaultPieDataset dataset) {
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Resultados de Votación", dataset, true, true, false);

        return pieChart;
    }

    public void closeWindow() {
        frame.dispose();
    }
}
