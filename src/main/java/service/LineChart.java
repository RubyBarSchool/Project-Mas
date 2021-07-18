package service;

import entity.DataProvinceInVietNam;
import org.jfree.chart.plot.PlotOrientation;

import java.util.List;

public interface LineChart {
    // Liet kê hàm
    void demoLineChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                     PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                     int width, int height);

}
