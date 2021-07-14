package service.impl;

import entity.BaseBarChart;
import entity.DataProvinceInVietNam;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import service.BarChart;

import java.util.List;

public class BarChartImpl implements BarChart {
    @Override
    public void demoBarChar(List<DataProvinceInVietNam> data,String applicationTitle, String chartTitle ,String dataX,String dataY,
                            PlotOrientation plotOrientation,Boolean legend,Boolean tolltips,Boolean urls,
                            int width, int height) {
        CategoryDataset categoryDataset = this.formatData(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle,chartTitle,dataX,dataY,categoryDataset,plotOrientation,legend,tolltips,urls,width,height);
        barChar.pack( );
        RefineryUtilities.centerFrameOnScreen( barChar );
        barChar.setVisible( true );
    }
    private CategoryDataset formatData(List<DataProvinceInVietNam> data) {
        final String hanoi = "Ha Noi";
        final String hatay = "Ha Tay";
        final String vinhphuc = "Vinh Phuc";

        final String nam16 = "2016";
        final String nam17 = "2017";
        final String nam18 = "2018";
        final String nam19 = "2019";

        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        dataset.addValue( 21000 , hanoi , nam16 );
        dataset.addValue( 36000 , hatay , nam16 );
        dataset.addValue( 43000 , vinhphuc , nam16 );

        dataset.addValue( 25000 , hanoi , nam17 );
        dataset.addValue( 32000 , hatay , nam17 );
        dataset.addValue( 53000 , vinhphuc , nam17 );

        dataset.addValue( 20000 , hanoi , nam18 );
        dataset.addValue( 46000 , hatay , nam18 );
        dataset.addValue( 33000 , vinhphuc , nam18 );

        dataset.addValue( 29000 , hanoi , nam19 );
        dataset.addValue( 37000 , hatay , nam19 );
        dataset.addValue( 23000 , vinhphuc , nam19 );
        return dataset;
    }
}
