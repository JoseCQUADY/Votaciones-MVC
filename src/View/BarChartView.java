package View;

import org.jfree.chart.ChartPanel;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartView {
    private JFrame frame;
    private ChartPanel chartPanel;
    private DefaultCategoryDataset dataset;
    private static final Logger logger = Test.Main.logger;

    public BarChartView() {
        frame = new JFrame("Gráfico de Barras");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        dataset = new DefaultCategoryDataset();
        JFreeChart barChart = createBarChart(dataset);

        chartPanel = new ChartPanel(barChart);
        frame.add(chartPanel);

        frame.pack();
        frame.setVisible(true);
        
        logger.info("Desde BarChartView: BarChartView.");
    }

    public void updateChart(String[]productNames, int[] votes) {
        dataset.clear();

        for (int i = 0; i < productNames.length; i++) {
            dataset.setValue(votes[i], "Votos", productNames[i]);
        }
        logger.info("Desde BarChartView: updateChart.");
    }

    private JFreeChart createBarChart(DefaultCategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Resultados de Votación", "Productos", "Votos", dataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        CategoryItemRenderer renderer = new StackedBarRenderer();
        renderer.setSeriesItemLabelGenerator(0, null);
        renderer.setSeriesItemLabelGenerator(1, null);
        renderer.setSeriesItemLabelGenerator(2, null);
        renderer.setSeriesItemLabelsVisible(0, false);
        renderer.setSeriesItemLabelsVisible(1, false);
        renderer.setSeriesItemLabelsVisible(2, false);
        plot.setRenderer(renderer);
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        logger.info("Desde BarChartView: createBarChart.");
        return barChart;
    }

    public void closeWindow() {
        logger.info("Desde BarChartView: closeWindow.");
        frame.dispose();
    }
}
