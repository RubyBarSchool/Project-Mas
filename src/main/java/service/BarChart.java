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

    // code phong
    void barCharCity(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                     PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                     int width, int height);
    void barCharCoutrySide(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                           PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                           int width, int height);

    // code minh
    void avgPopulationBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                              PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                              int width, int height);

    void avgPopulationBarCharMB(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                                PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                                int width, int height);
    void avgPopulationBarCharMN(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                                PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                                int width, int height);
    void avgPopulationBarCharMT(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                                PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                                int width, int height);
    void avgPopulationBarCharCaNuoc(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                                    PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                                    int width, int height);

    // code ngoc
    void distributionMigrationRate(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                                   PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                                   int width, int height);
    void distributionIMMigrationRate(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                                     PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                                     int width, int height);

    // code hoang anh
    void capitalBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                        PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                        int width, int height);

    void economicBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                         PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                         int width, int height);

    void distributionBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle , String dataX, String dataY,
                             PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls,
                             int width, int height);
}
