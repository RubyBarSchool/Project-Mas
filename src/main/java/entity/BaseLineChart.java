package entity;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BaseLineChart extends ApplicationFrame {

    public BaseLineChart(String applicationTitle , String chartTitle, String dataX, String dataY, CategoryDataset dataset,
                         PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                         int width, int height) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                dataX,
                dataY,
                dataset,
                plotOrientation,
                legend,tolltips,urls);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( width , height ) );
        setContentPane( chartPanel );
    }
}
