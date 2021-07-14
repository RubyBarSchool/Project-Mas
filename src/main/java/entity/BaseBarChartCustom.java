package entity;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BaseBarChartCustom extends ApplicationFrame {
    public BaseBarChartCustom(String applicationTitle, int width, int height, JFreeChart barChartCustom) {
        super(applicationTitle);
        ChartPanel chartPanel = new ChartPanel( barChartCustom );
        chartPanel.setPreferredSize(new java.awt.Dimension( width , height ) );
        setContentPane( chartPanel );
    }
}
