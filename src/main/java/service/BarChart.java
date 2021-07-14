package service;

import entity.DataProvinceInVietNam;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import java.util.List;

public interface BarChart {
    // Liet kê hàm
    void demoBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                     PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                     int width, int height);
}
