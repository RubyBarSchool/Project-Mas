package service.impl;

import entity.BaseBarChart;
import entity.BaseBarChartCustom;
import entity.DataProvinceInVietNam;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;
import service.DoubleBarChar;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DoubleBarCharImpl implements DoubleBarChar {
    @Override
    public void demoDoublrBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatData(data);
        JFreeChart chartCustom = this.createChart(categoryDataset,chartTitle,dataX,dataY,plotOrientation,legend,tolltips,urls);
        BaseBarChartCustom barChar = new BaseBarChartCustom(applicationTitle,width,height,chartCustom);
        barChar.pack( );
        RefineryUtilities.centerFrameOnScreen( barChar );
        barChar.setVisible( true );
    }
    private JFreeChart createChart(CategoryDataset dataset, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                chartTitle,  // chart title
                dataX,                  // domain axis label
                dataY,                     // range axis label
                dataset,                     // data
                plotOrientation,    // the plot orientation
                legend,                        // legend
                tolltips,                        // tooltips
                urls                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");

        map.mapKeyToGroup("Product 1 (US)", "G1");
        map.mapKeyToGroup("Product 1 (Europe)", "G1");
        map.mapKeyToGroup("Product 1 (Asia)", "G1");
        map.mapKeyToGroup("Product 1 (Middle East)", "G1");

        map.mapKeyToGroup("Product 2 (US)", "G2");
        map.mapKeyToGroup("Product 2 (Europe)", "G2");
        map.mapKeyToGroup("Product 2 (Asia)", "G2");
        map.mapKeyToGroup("Product 2 (Middle East)", "G2");
        map.mapKeyToGroup("Product 3 (US)", "G3");
        map.mapKeyToGroup("Product 3 (Europe)", "G3");
        map.mapKeyToGroup("Product 3 (Asia)", "G3");
        map.mapKeyToGroup("Product 3 (Middle East)", "G3");
        renderer.setSeriesToGroupMap(map);

        renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, new Color(0x88, 0x88, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);
        renderer.setSeriesPaint(4, p1);
        renderer.setSeriesPaint(8, p1);

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(1, p2);
        renderer.setSeriesPaint(5, p2);
        renderer.setSeriesPaint(9, p2);

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0x22, 0x22), 0.0f, 0.0f, new Color(0xFF, 0x88, 0x88)
        );
        renderer.setSeriesPaint(2, p3);
        renderer.setSeriesPaint(6, p3);
        renderer.setSeriesPaint(10, p3);

        Paint p4 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0xFF, 0x22), 0.0f, 0.0f, new Color(0xFF, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(3, p4);
        renderer.setSeriesPaint(7, p4);
        renderer.setSeriesPaint(11, p4);
        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );

        SubCategoryAxis domainAxis = new SubCategoryAxis("Product / Month");
        domainAxis.setCategoryMargin(0.05);
        domainAxis.addSubCategory("Product 1");
        domainAxis.addSubCategory("Product 2");
        domainAxis.addSubCategory("Product 3");

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart;

    }
    private CategoryDataset formatData(List<DataProvinceInVietNam> data) {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        result.addValue(20.3, "Product 1 (US)", "Jan 04");
        result.addValue(27.2, "Product 1 (US)", "Feb 04");
        result.addValue(19.7, "Product 1 (US)", "Mar 04");
        result.addValue(19.4, "Product 1 (Europe)", "Jan 04");
        result.addValue(10.9, "Product 1 (Europe)", "Feb 04");
        result.addValue(18.4, "Product 1 (Europe)", "Mar 04");
        result.addValue(16.5, "Product 1 (Asia)", "Jan 04");
        result.addValue(15.9, "Product 1 (Asia)", "Feb 04");
        result.addValue(16.1, "Product 1 (Asia)", "Mar 04");
        result.addValue(13.2, "Product 1 (Middle East)", "Jan 04");
        result.addValue(14.4, "Product 1 (Middle East)", "Feb 04");
        result.addValue(13.7, "Product 1 (Middle East)", "Mar 04");

        result.addValue(23.3, "Product 2 (US)", "Jan 04");
        result.addValue(16.2, "Product 2 (US)", "Feb 04");
        result.addValue(28.7, "Product 2 (US)", "Mar 04");
        result.addValue(12.7, "Product 2 (Europe)", "Jan 04");
        result.addValue(17.9, "Product 2 (Europe)", "Feb 04");
        result.addValue(12.6, "Product 2 (Europe)", "Mar 04");
        result.addValue(15.4, "Product 2 (Asia)", "Jan 04");
        result.addValue(21.0, "Product 2 (Asia)", "Feb 04");
        result.addValue(11.1, "Product 2 (Asia)", "Mar 04");
        result.addValue(23.8, "Product 2 (Middle East)", "Jan 04");
        result.addValue(23.4, "Product 2 (Middle East)", "Feb 04");
        result.addValue(19.3, "Product 2 (Middle East)", "Mar 04");

        result.addValue(11.9, "Product 3 (US)", "Jan 04");
        result.addValue(31.0, "Product 3 (US)", "Feb 04");
        result.addValue(22.7, "Product 3 (US)", "Mar 04");
        result.addValue(15.3, "Product 3 (Europe)", "Jan 04");
        result.addValue(14.4, "Product 3 (Europe)", "Feb 04");
        result.addValue(25.3, "Product 3 (Europe)", "Mar 04");
        result.addValue(23.9, "Product 3 (Asia)", "Jan 04");
        result.addValue(19.0, "Product 3 (Asia)", "Feb 04");
        result.addValue(10.1, "Product 3 (Asia)", "Mar 04");
        result.addValue(13.2, "Product 3 (Middle East)", "Jan 04");
        result.addValue(15.5, "Product 3 (Middle East)", "Feb 04");
        result.addValue(10.1, "Product 3 (Middle East)", "Mar 04");

        return result;
    }

    // code phong
    @Override
    public void countryPopulation(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.countryPopulation(data);
        JFreeChart chartCustom = this.createChartPhong(categoryDataset, chartTitle, dataX, dataY, plotOrientation, legend, tolltips, urls);
        BaseBarChartCustom barChar = new BaseBarChartCustom(applicationTitle, width, height, chartCustom);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void largeArea(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.lergerAreaPopulation(data);
        JFreeChart chartCustom = this.createLergeAreaChart(categoryDataset, chartTitle, dataX, dataY, plotOrientation, legend, tolltips, urls);
        BaseBarChartCustom barChar = new BaseBarChartCustom(applicationTitle, width, height, chartCustom);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    private JFreeChart createLergeAreaChart(CategoryDataset dataset, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                chartTitle,  // chart title
                dataX,                  // domain axis label
                dataY,                     // range axis label
                dataset,                     // data
                plotOrientation,    // the plot orientation
                legend,                        // legend
                tolltips,                        // tooltips
                urls                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");

        map.mapKeyToGroup("Đồng bằng sông Hồng", "G1");
        map.mapKeyToGroup("Trung du và miền núi phía Bắc", "G1");
        map.mapKeyToGroup("Bắc Trung Bộ và Duyên hải miền Trung", "G1");
        map.mapKeyToGroup("Đồng bằng sông Cửu Long", "G1");

        renderer.setSeriesToGroupMap(map);

        renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, new Color(0x88, 0x88, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);


        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(1, p2);

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(223, 0, 41), 0.0f, 0.0f, new Color(223, 0, 41)
        );
        renderer.setSeriesPaint(2, p3);

        Paint p4 = new GradientPaint(
                0.0f, 0.0f, new Color(249, 244, 0), 0.0f, 0.0f, new Color(249, 244, 0)
        );
        renderer.setSeriesPaint(3, p4);

        SubCategoryAxis domainAxis = new SubCategoryAxis("dân số nông thôn khu vực / cả nước ");
        domainAxis.setCategoryMargin(0.25);
//        domainAxis.addSubCategory("Cả Nước");

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendAreaItems());
        return chart;
    }

    private CategoryDataset lergerAreaPopulation(List<DataProvinceInVietNam> data) {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        List<String> country = new ArrayList<>();
        country.add("Đồng bằng sông Hồng");
        country.add("Trung du và miền núi phía Bắc");
        country.add("Bắc Trung Bộ và Duyên hải miền Trung");
        country.add("Đồng bằng sông Cửu Long");
        for (DataProvinceInVietNam datax : data) {
            if (country.contains(datax.getName())) {
                if (datax.getYear() % 2 == 1 || datax.getYear() == 2018) {
                    double persentOfCoutryside = datax.getAveragePopulationCountryside() / datax.getAveragePopulation() * 100;
                    result.addValue(persentOfCoutryside, datax.getName(), datax.getYear()+"");
                }

            }
        }

        return result;
    }

    private LegendItemCollection createLegendAreaItems() {
        LegendItemCollection result = new LegendItemCollection();
        LegendItem item1 = new LegendItem("Đồng bằng sông Hồng", new Color(0x22, 0x22, 0xFF));
        LegendItem item2 = new LegendItem("Trung du và miền núi phía Bắc", new Color(0x22, 0xFF, 0x22));
        LegendItem item3 = new LegendItem("Bắc Trung Bộ và Duyên hải miền Trung", new Color(223, 0, 41));
        LegendItem item4 = new LegendItem("Đồng bằng sông Cửu Long", new Color(223, 0xFF, 0x22));
        result.add(item1);
        result.add(item2);
        result.add(item3);
        result.add(item4);
        return result;
    }


    private LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
        LegendItem item1 = new LegendItem("Nông thôn", new Color(0x22, 0x22, 0xFF));
        LegendItem item2 = new LegendItem("Thành thị", new Color(0x22, 0xFF, 0x22));
        result.add(item1);
        result.add(item2);
        return result;
    }

    private CategoryDataset countryPopulation(List<DataProvinceInVietNam> data) {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        for (DataProvinceInVietNam datax : data) {
            if (datax.getName().contains("CẢ NƯỚC")) {
                if (datax.getYear() % 2 == 1 || datax.getYear() == 2018) {
                    double persentOfCoutryside = datax.getAveragePopulationCountryside() / datax.getAveragePopulation() * 100;
                    double persentOfCity = datax.getAveragePopulationCity() / datax.getAveragePopulation() * 100;
                    result.addValue(persentOfCoutryside, "Nông thôn", datax.getYear() + "");
                    result.addValue(persentOfCity, "Thành thị", datax.getYear() + "");
                }
            }
        }
        return result;
    }





    private JFreeChart createChartPhong(CategoryDataset dataset, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                chartTitle,  // chart title
                dataX,                  // domain axis label
                dataY,                     // range axis label
                dataset,                     // data
                plotOrientation,    // the plot orientation
                legend,                        // legend
                tolltips,                        // tooltips
                urls                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");

        map.mapKeyToGroup("Nông thôn", "G1");
        map.mapKeyToGroup("Thành thị", "G1");

        renderer.setSeriesToGroupMap(map);

        renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0, 0, 246), 0.0f, 0.0f, new Color(0x88, 0x88, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(0, 0xFF, 0), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(1, p2);


        SubCategoryAxis domainAxis = new SubCategoryAxis("Thành thị / Nông thôn");
        domainAxis.setCategoryMargin(0.25);
        domainAxis.addSubCategory("Cả Nước");

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart;

    }

    // code minh
    @Override
    public void avgPopulationDoubleBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.avgPopulationData(data);
        JFreeChart chartCustom = this.createAvgPopulationChart(categoryDataset,chartTitle,dataX,dataY,plotOrientation,legend,tolltips,urls);
        BaseBarChartCustom barChar = new BaseBarChartCustom(applicationTitle,width,height,chartCustom);
        barChar.pack( );
        RefineryUtilities.centerFrameOnScreen( barChar );
        barChar.setVisible( true );
    }


    private CategoryDataset avgPopulationData(List<DataProvinceInVietNam> data) {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        List<String> listCity = new ArrayList<>();
        listCity.add("Thanh Hoá");
        listCity.add("Nghệ An");
        listCity.add("Phú Yên");
        listCity.add("Quảng Bình");
        listCity.add("Hải Phòng");
        for(int j=0;j<data.size();j++){
            for(int i=0;i<listCity.size();i++){
                if(data.get(j).getName().equals(listCity.get(i))){
                    result.addValue( data.get(j).getAveragePopulation() , data.get(j).getName() , data.get(j).getYear()+"" );
                }
            }
        }
        return result;
    }

    private JFreeChart createAvgPopulationChart(CategoryDataset dataset, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                chartTitle,  // chart title
                dataX,                  // domain axis label
                dataY,                     // range axis label
                dataset,                     // data
                plotOrientation,    // the plot orientation
                legend,                        // legend
                tolltips,                        // tooltips
                urls                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, new Color(0x88, 0x88, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);
        renderer.setSeriesPaint(4, p1);
        renderer.setSeriesPaint(8, p1);

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(1, p2);
        renderer.setSeriesPaint(5, p2);
        renderer.setSeriesPaint(9, p2);

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0x22, 0x22), 0.0f, 0.0f, new Color(0xFF, 0x88, 0x88)
        );
        renderer.setSeriesPaint(2, p3);
        renderer.setSeriesPaint(6, p3);
        renderer.setSeriesPaint(10, p3);

        Paint p4 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0xFF, 0x22), 0.0f, 0.0f, new Color(0xFF, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(3, p4);
        renderer.setSeriesPaint(7, p4);
        renderer.setSeriesPaint(11, p4);
        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );

        SubCategoryAxis domainAxis = new SubCategoryAxis("Years");
        domainAxis.setCategoryMargin(0.05);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart;
    }

    // code ngoc
    @Override
    public void doubleBarCharMigration(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatDataMigration(data);
        JFreeChart chartCustom = this.createChartNgoc(categoryDataset, chartTitle, dataX, dataY, plotOrientation, legend, tolltips, urls);
        BaseBarChartCustom barChar = new BaseBarChartCustom(applicationTitle, width, height, chartCustom);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void doubleBarCharImMigration(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatDataImMigration(data);
        JFreeChart chartCustom = this.createChartNgoc(categoryDataset, chartTitle, dataX, dataY, plotOrientation, legend, tolltips, urls);
        BaseBarChartCustom barChar = new BaseBarChartCustom(applicationTitle, width, height, chartCustom);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    private JFreeChart createChartNgoc(CategoryDataset dataset, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls) {
        List<String> listCity = new ArrayList<>();
        listCity.add("Hà Nội");
        listCity.add("TP.Hồ Chí Minh");
        listCity.add("Bắc Ninh");
        listCity.add("Vĩnh Phúc");
        listCity.add("Thái Nguyên");
        listCity.add("Bình Dương");
        listCity.add("Bình Phước");
        final JFreeChart chart = ChartFactory.createStackedBarChart(
                chartTitle,  // chart title
                dataX,                  // domain axis label
                dataY,                     // range axis label
                dataset,                     // data
                plotOrientation,    // the plot orientation
                legend,                        // legend
                tolltips,                        // tooltips
                urls                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");
        for (int i = 0; i < listCity.size(); i++) {
            map.mapKeyToGroup(listCity.get(i) , "G1" );

        }
        renderer.setSeriesToGroupMap(map);
        renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0, 0, 255), 0.0f, 0.0f, new Color(0, 0, 255)
        );

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x22, 0xFF, 0x22)
        );

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(0, 0, 0), 0.0f, 0.0f, new Color(0, 0, 0)
        );

        Paint p4 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0xFF, 0x22), 0.0f, 0.0f, new Color(0xFF, 0xFF, 0x22)
        );

        Paint p5 = new GradientPaint(
                0.0f, 0.0f, new Color(255, 255, 255), 0.0f, 0.0f, new Color(255, 255, 255)
        );


        Paint p6 = new GradientPaint(
                0.0f, 0.0f, new Color(255, 0, 255), 0.0f, 0.0f, new Color(255, 0, 255)
        );

        Paint p7 = new GradientPaint(
                0.0f, 0.0f, new Color(0, 145, 0x22), 0.0f, 0.0f, new Color(0, 145, 0x22)
        );

        Paint p8 = new GradientPaint(
                0.0f, 0.0f, new Color(0, 128, 128), 0.0f, 0.0f, new Color(0, 128, 128)
        );
        renderer.setSeriesPaint(0,p1);
        renderer.setSeriesPaint(1, p2);
        renderer.setSeriesPaint(2, p3);
        renderer.setSeriesPaint(3, p4);
        renderer.setSeriesPaint(4, p5);
        renderer.setSeriesPaint(5, p6);
        renderer.setSeriesPaint(6, p7);
//        renderer.setSeriesPaint(7, p8);

        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );

        SubCategoryAxis domainAxis = new SubCategoryAxis("Year");
        domainAxis.setCategoryMargin(0.5);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        //plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItemsNgoc());
        return chart;

    }

    private LegendItemCollection createLegendItemsNgoc() {
        LegendItemCollection result = new LegendItemCollection();
        LegendItem item1 = new LegendItem("HN", new Color(0, 0, 255));
        LegendItem item2 = new LegendItem("TP.HCM", new Color(0x22, 0xFF, 0x22));
        LegendItem item3 = new LegendItem("Bắc Ninh", new Color(0, 0, 0));
        LegendItem item4 = new LegendItem("Vĩnh Phúc", new Color(0xFF, 0xFF, 0x22));
        LegendItem item5 = new LegendItem("Thái Nguyên", new Color(255, 255, 255));
        LegendItem item6 = new LegendItem("Bình Dương", new Color(255, 0, 255));
        LegendItem item7 = new LegendItem("Bình Phước", new Color(0, 145, 0x22));
        result.add(item1);
        result.add(item2);
        result.add(item3);
        result.add(item4);
        result.add(item5);
        result.add(item6);
        result.add(item7);
        return result;
    }



    private CategoryDataset formatDataMigration(List<DataProvinceInVietNam> data) {
        //loc data
        List<String> listCity = new ArrayList<>();
        listCity.add("Hà Nội");
        listCity.add("TP.Hồ Chí Minh");
        listCity.add("Bắc Ninh");
        listCity.add("Vĩnh Phúc");
        listCity.add("Thái Nguyên");
        listCity.add("Bình Dương");
        listCity.add("Bình Phước");
//dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < data.size(); i++) {
            if (listCity.contains(data.get(i).getName()) && data.get(i).getMigration() != 0.0) {
                dataset.addValue(data.get(i).getMigration(), data.get(i).getName() , data.get(i).getYear() + "");
            }
        }
        return dataset;
    }
    private CategoryDataset formatDataImMigration(List<DataProvinceInVietNam> data) {
        //loc data
        List<String> listCity = new ArrayList<>();
        listCity.add("Hà Nội");
        listCity.add("TP.Hồ Chí Minh");
        listCity.add("Bắc Ninh");
        listCity.add("Vĩnh Phúc");
        listCity.add("Thái Nguyên");
        listCity.add("Bình Dương");
        listCity.add("Bình Phước");
//dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < data.size(); i++) {
            if (listCity.contains(data.get(i).getName()) && data.get(i).getMigration() != 0.0) {
                dataset.addValue(data.get(i).getImmigration(), data.get(i).getName() , data.get(i).getYear() + "");
            }
        }
        return dataset;
    }
}
