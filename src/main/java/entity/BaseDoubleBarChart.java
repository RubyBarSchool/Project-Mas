package entity;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BaseDoubleBarChart extends ApplicationFrame {
    public BaseDoubleBarChart(String applicationTitle, String chartTitle , String dataX, String dataY, CategoryDataset dataset,
                              PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                              int width, int height) {
        super(applicationTitle);
        JFreeChart barChart = ChartFactory.createStackedBarChart(
                chartTitle,
                dataX,
                dataY,
                dataset,
                plotOrientation,
                legend,
                tolltips,
                urls);
        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( width , height ) );
        setContentPane( chartPanel );
    }
}
