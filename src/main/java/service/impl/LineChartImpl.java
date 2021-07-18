package service.impl;

import entity.BaseBarChart;
import entity.DataProvinceInVietNam;
import entity.BaseLineChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import service.LineChart;

import java.util.List;

public class LineChartImpl implements LineChart {
    @Override
    public void demoLineChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle,
                             String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend,
                             Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatData(data);
        BaseLineChart lineChart = new BaseLineChart(applicationTitle,chartTitle,dataX,dataY,categoryDataset,plotOrientation,legend,tolltips,urls,width,height);
        lineChart.pack( );
        RefineryUtilities.centerFrameOnScreen( lineChart );
        lineChart.setVisible( true );
    }

    private CategoryDataset formatData(List<DataProvinceInVietNam> data) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        dataset.addValue( 21000 , "Ha Noi" , "2016" );
        dataset.addValue( 25000 , "Ha Noi" , "2017" );
        dataset.addValue( 20000 , "Ha Noi" ,  "2018" );
        dataset.addValue( 29000 , "Ha Noi" , "2019" );

        dataset.addValue( 36000 , "Ha Tay" , "2016" );
        dataset.addValue( 32000 , "Ha Tay" , "2017" );
        dataset.addValue( 46000 , "Ha Tay" ,  "2018" );
        dataset.addValue( 37000 , "Ha Tay" , "2019" );

        dataset.addValue( 43000 , "Vinh Phuc" , "2016" );
        dataset.addValue( 53000 , "Vinh Phuc" , "2017" );
        dataset.addValue( 33000 , "Vinh Phuc" ,  "2018" );
        dataset.addValue( 23000 , "Vinh Phuc" , "2019" );
        return dataset;
    }
    // Logic Hàm
}
