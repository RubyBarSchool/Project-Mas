package service;

import entity.DataProvinceInVietNam;
import org.jfree.chart.plot.PlotOrientation;

import java.util.List;

public interface DoubleBarChar {
    void demoDoublrBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                     PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                     int width, int height);
}
