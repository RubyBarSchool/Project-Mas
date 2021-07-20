package service.impl;

import entity.BaseBarChart;
import entity.DataProvinceInVietNam;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;
import service.BarChart;
import vo.*;

import java.util.ArrayList;
import java.util.Collections;
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
    // code phong
    @Override
    public void barCharCity(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        List<PopulationStructure> populationStructures = getAllPopulationStructure(data);
        CategoryDataset categoryDataset = this.formatDataCity(populationStructures);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void barCharCoutrySide(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        List<PopulationStructure> populationStructures = getAllPopulationStructure(data);
        CategoryDataset categoryDataset = this.formatDataCountrySide(populationStructures);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    private CategoryDataset formatDataCity(List<PopulationStructure> data) {
        List<Integer> listPercentOfCity = new ArrayList<>();
        List<PercentPopulation> listPercent = new ArrayList<>();
        PercentPopulation percentPopulation = null;
        List<Integer> listRange = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int percentageOfCity = (int) Math.floor(data.get(i).getTbAveragePopulationCity() / data.get(i).getTbAveragePopulation() * 100);
            if (!listRange.contains(percentageOfCity)) {
                listRange.add(percentageOfCity);
            }
        }
        Collections.sort(listRange);
        int min = listRange.get(0).intValue();
        int max = Collections.max(listRange);
        int kc = (max - min) / 10;
        for (int j = 0; j <= 11; j++) {
            int range = min + kc * j;
            if (!listPercentOfCity.contains(range)) {
                listPercentOfCity.add(range);
                percentPopulation = new PercentPopulation();
                percentPopulation.setPercentPolulation(range);
                listPercent.add(percentPopulation);
            }
        }
        for (int j = 0; j < listPercent.size() ; j++) {
            for (int i = 0; i < data.size(); i++) {
                int percentageOfCity = (int) Math.floor(data.get(i).getTbAveragePopulationCity() / data.get(i).getTbAveragePopulation() * 100);

                if (j == 0) {
                    if (percentageOfCity <= listPercent.get(j).getPercentPolulation()) {
                        listPercent.get(j).setRepeate(listPercent.get(j).getRepeate() + 1);
                    }
                } else {
                    if (percentageOfCity < listPercent.get(j).getPercentPolulation() &&
                            percentageOfCity >= listPercent.get(j - 1).getPercentPolulation()) {
                        listPercent.get(j).setRepeate(listPercent.get(j).getRepeate() + 1);
                    }
                }
            }
        }
        Collections.sort(listPercent);
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (PercentPopulation per : listPercent) {
            dataset.addValue(per.getRepeate(), "population", per.getPercentPolulation() + "");
        }
        return dataset;
    }

    private CategoryDataset formatDataCountrySide(List<PopulationStructure> data) {
        List<Integer> listPercentOfCity = new ArrayList<>();
        List<PercentPopulation> listPercent = new ArrayList<>();
        PercentPopulation percentPopulation = null;

        List<Integer> listRange = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            int percentageOfCountrySide = (int) Math.floor(data.get(i).getTbAveragePopulationCountryside() / data.get(i).getTbAveragePopulation() * 100);
            if (!listRange.contains(percentageOfCountrySide)) {
                listRange.add(percentageOfCountrySide);
            }
        }
        Collections.sort(listRange);
        int min = listRange.get(0).intValue();
        int max = Collections.max(listRange);
        int kc = (max - min) / 10;
        for (int j = 0; j <= 11; j++) {
            int range = min + kc * j;
            if (!listPercentOfCity.contains(range)) {
                listPercentOfCity.add(range);
                percentPopulation = new PercentPopulation();
                percentPopulation.setPercentPolulation(range);
                listPercent.add(percentPopulation);
            }
        }
        for (int j = 0; j < listPercent.size() ; j++) {
            for (int i = 0; i < data.size(); i++) {
                int percentageOfCountrySide = (int) Math.floor(data.get(i).getTbAveragePopulationCountryside() / data.get(i).getTbAveragePopulation() * 100);

                if (j == 0) {
                    if (percentageOfCountrySide <= listPercent.get(j).getPercentPolulation()) {
                        listPercent.get(j).setRepeate(listPercent.get(j).getRepeate() + 1);
                    }
                } else {
                    if (percentageOfCountrySide < listPercent.get(j).getPercentPolulation() &&
                            percentageOfCountrySide >= listPercent.get(j - 1).getPercentPolulation()) {
                        listPercent.get(j).setRepeate(listPercent.get(j).getRepeate() + 1);
                    }
                }
            }
        }

        Collections.sort(listPercent);
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (PercentPopulation per : listPercent) {
            dataset.addValue(per.getRepeate(), "population", per.getPercentPolulation() + "");
        }
        return dataset;
    }

    private List<PopulationStructure> getAllPopulationStructure(List<DataProvinceInVietNam> data) {
        List<PopulationStructure> populationStructures = new ArrayList<>();
        List<String> country = new ArrayList<>();
        country.add("Đồng bằng sông Hồng");
        country.add("Trung du và miền núi phía Bắc");
        country.add("Bắc Trung Bộ và Duyên hải miền Trung");
        country.add("Đồng bằng sông Cửu Long");
        List<String> name = new ArrayList<>();
        PopulationStructure poplation = null;
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).getCheckCountry() && !country.contains(data.get(i).getName())) {
                if (!name.contains(data.get(i).getName())) {
                    name.add(data.get(i).getName());
                    poplation = new PopulationStructure();
                    poplation.setSumPopulation(data.get(i).getAveragePopulation());
                    poplation.setSumPopulationCity(data.get(i).getAveragePopulationCity());
                    poplation.setSumPopulationCountrySide(data.get(i).getAveragePopulationCountryside());
                    poplation.setCountYear(1);
                    populationStructures.add(poplation);
                } else if (name.contains(data.get(i).getName())) {
                    for (int j = 0; j < name.size(); j++) {
                        if (name.get(j).equals(data.get(i).getName())) {
                            if (data.get(i).getAveragePopulation() != 0) {
                                poplation = new PopulationStructure();
                                poplation.setSumPopulation(populationStructures.get(j).getSumPopulation() + data.get(i).getAveragePopulation());
                                poplation.setSumPopulationCity(populationStructures.get(j).getSumPopulationCity() + data.get(i).getAveragePopulationCity());
                                poplation.setSumPopulationCountrySide(populationStructures.get(j).getSumPopulationCountrySide() + data.get(i).getAveragePopulationCountryside());
                                poplation.setCountYear(populationStructures.get(j).getCountYear() + 1);
                                populationStructures.set(j, poplation);
                            }
                        }
                    }
                }
            }
        }
        for (PopulationStructure propa : populationStructures) {
            propa.setTbAveragePopulation(propa.getSumPopulation() / propa.getCountYear());
            propa.setTbAveragePopulationCity(propa.getSumPopulationCity() / propa.getCountYear());
            propa.setTbAveragePopulationCountryside(propa.getSumPopulationCountrySide() / propa.getCountYear());
        }
        return populationStructures;
    }


    // code minh
    @Override
    public void avgPopulationBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.avgPopulationDataDacKhu(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void avgPopulationBarCharMB(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.DataMB(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void avgPopulationBarCharMN(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.DataMN(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void avgPopulationBarCharMT(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.DataMT(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void avgPopulationBarCharCaNuoc(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.DataCaNuoc(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    private CategoryDataset avgPopulationDataDacKhu(List<DataProvinceInVietNam> data) {
        List<String> listCity = new ArrayList<>();
        listCity.add("Thanh Hoá");
        listCity.add("Nghệ An");
        listCity.add("Phú Yên");
        listCity.add("Quảng Bình");
        listCity.add("Hải Phòng");

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int j = 0; j < data.size(); j++) {
            for (int i = 0; i < listCity.size(); i++) {
                if (data.get(j).getName().equals(listCity.get(i))) {
                    dataset.addValue(data.get(j).getAveragePopulation(), data.get(j).getName(), data.get(j).getYear() + "");
                }
            }
        }
        return dataset;
    }

    private CategoryDataset DataMB(List<DataProvinceInVietNam> data) {
        List<String> listCity = new ArrayList<>();
        listCity.add("Đồng bằng sông Hồng");
        listCity.add("Trung du và miền núi phía Bắc");

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int j = 0; j < data.size(); j++) {
            for (int i = 0; i < listCity.size(); i++) {
                if (data.get(j).getName().equals(listCity.get(i))) {
                    dataset.addValue(data.get(j).getAveragePopulation(), data.get(j).getName(), data.get(j).getYear() + "");
                }
            }
        }
        return dataset;
    }

    private CategoryDataset DataMN(List<DataProvinceInVietNam> data) {
        List<String> listCity = new ArrayList<>();
        listCity.add("Đông Nam Bộ");
        listCity.add("Đồng bằng sông Cửu Long");

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int j = 0; j < data.size(); j++) {
            for (int i = 0; i < listCity.size(); i++) {
                if (data.get(j).getName().equals(listCity.get(i))) {
                    dataset.addValue(data.get(j).getAveragePopulation(), data.get(j).getName(), data.get(j).getYear() + "");
                }
            }
        }
        return dataset;
    }

    private CategoryDataset DataMT(List<DataProvinceInVietNam> data) {
        List<String> listCity = new ArrayList<>();
        listCity.add("Bắc Trung Bộ và Duyên hải miền Trung");

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int j = 0; j < data.size(); j++) {
            for (int i = 0; i < listCity.size(); i++) {
                if (data.get(j).getName().equals(listCity.get(i))) {
                    dataset.addValue(data.get(j).getAveragePopulation(), data.get(j).getName(), data.get(j).getYear() + "");
                }
            }
        }
        return dataset;
    }
    private CategoryDataset DataCaNuoc(List<DataProvinceInVietNam> data) {

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // số lượng tỉnh trùng dân số với nhau
        // tỉnh nào với dân số nào
        // mảng dân số không trùng nhau tăng dần -> trục x [11,12,13,15]
        // mảng số tỉnh trùng nhau theo mảng trên -> trục y [3,5,7,2]

        // key của hashmap
        // value

        List<String> listCity = new ArrayList<>();
        listCity.add("Trung du và miền núi phía Bắc");
        listCity.add("CẢ NƯỚC");
        listCity.add("Đồng bằng sông Hồng");
        listCity.add("Bắc Trung Bộ và Duyên hải miền Trung");
        listCity.add("Đông Nam Bộ");
        listCity.add("Đồng bằng sông Cửu Long");

        List<String> listTP = new ArrayList<>();
        for (int j = 0; j < data.size(); j++) {
            if (!listCity.contains(data.get(j).getName()) && !listTP.contains(data.get(j).getName())) {
                listTP.add(data.get(j).getName());
            }
        }

        List<Integer> tbNam = new ArrayList<>();


        for (int i = 0; i < listTP.size(); i++) {
            int count = 0;
            double tong = 0;
            double avg = 0;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j).getName().equals(listTP.get(i))) {
                    count++;
                    tong += data.get(j).getAveragePopulation();
                    avg = tong / count;
                }
            }
            tbNam.add((int) avg);
        }

        Collections.sort(tbNam);
        int min = tbNam.get(0).intValue();
        int max = Collections.max(tbNam);
        int kc = (max-min)/63;
        List<Integer> list = new ArrayList<>();
        List<Integer> listCou = new ArrayList<>();
        for(int i=0;i<=64;i++){
            list.add(min+kc*i);
            listCou.add(0);
        }
        for(int j=0 ;j<list.size();j++){
            for(int i = 0;i<tbNam.size();i++){
                if(j==0){
                    if(tbNam.get(i)<=list.get(j)){
                        listCou.set(j,listCou.get(j)+1);
                    }
                }else {
                    if(tbNam.get(i)<=list.get(j)&&tbNam.get(i)>list.get(j-1)){
                        listCou.set(j,listCou.get(j)+1);
                    }
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            dataset.addValue(listCou.get(i), "population", list.get(i) + "");
        }
        return dataset;
    }

    // code ngoc
    @Override
    public void distributionMigrationRate(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatDataMigrationRate(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void distributionIMMigrationRate(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatDataIMMigrationRate(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }


    private CategoryDataset formatDataMigrationRate(List<DataProvinceInVietNam> data) {
        List<String> listCity = new ArrayList<>();
        List<DemoClass> listDistri = new ArrayList<>();
        List<Double> listRange = new ArrayList<>();
        List<Integer> listCou = new ArrayList<>();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //city
        for (int i = 0; i < data.size(); i++) {
            if (!listCity.contains(data.get(i).getName()) && data.get(i).getCheckCountry() == false&& data.get(i).getMigration()!=0.0) {
                listCity.add(data.get(i).getName());
            }
        }
        // av
        for (int j = 0; j < listCity.size(); j++) {
            int count = 0;
            double tong = 0;
            for (int i = 0; i < data.size(); i++) {

                if (data.get(i).getName().equals(listCity.get(j))&& data.get(i).getMigration()!=0.0) {
                    count++;
                    tong += data.get(i).getMigration();
                }
            }
            double av = tong / count;
            DemoClass objDis = new DemoClass();
            objDis.setName(listCity.get(j));
            objDis.setTbPopulation(Math.round(av * 10.0) / 10.0);
            listDistri.add(objDis);//city,av
        }
        Collections.sort(listDistri);
        double min = listDistri.get(0).getTbPopulation().doubleValue();
        double max = listDistri.get(listDistri.size()-1).getTbPopulation().doubleValue();
        double kc = 1.2;
        for(int i=0;i<=9;i++){
            listRange.add((Math.round((min+kc*i) * 10.0) / 10.0));
            listCou.add(0);
        }
        for(int j=0 ;j<listRange.size();j++){
            for(int i = 0;i<listDistri.size();i++){
                if(j==0){
                    if(listDistri.get(i).getTbPopulation().doubleValue()<=listRange.get(j).doubleValue()){
                        listCou.set(j,listCou.get(j)+1);
                    }
                }else {
                    if(listDistri.get(i).getTbPopulation().doubleValue()<=listRange.get(j).doubleValue()
                            &&listDistri.get(i).getTbPopulation().doubleValue()>listRange.get(j-1).doubleValue()){
                        listCou.set(j,listCou.get(j)+1);
                    }
                }
            }
        }
        for (int i = 0; i < listRange.size(); i++) {
            dataset.addValue(listCou.get(i), "Migration Rate",listRange.get(i).doubleValue() + "" );
        }
        return dataset;
    }
    private CategoryDataset formatDataIMMigrationRate(List<DataProvinceInVietNam> data) {
        List<String> listCity = new ArrayList<>();
        List<DemoClass> listDistri = new ArrayList<>();
        List<Double> listRange = new ArrayList<>();
        List<Integer> listCou = new ArrayList<>();
        List<Distribution> listResult = new ArrayList<>();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //city
        for (int i = 0; i < data.size(); i++) {
            if (!listCity.contains(data.get(i).getName()) && data.get(i).getCheckCountry() == false&& data.get(i).getMigration()!=0.0) {
                listCity.add(data.get(i).getName());
            }
        }
        // av
        for (int j = 0; j < listCity.size(); j++) {
            int count = 0;
            double tong = 0;
            for (int i = 0; i < data.size(); i++) {

                if (data.get(i).getName().equals(listCity.get(j))&& data.get(i).getMigration()!=0.0) {
                    count++;
                    tong += data.get(i).getImmigration();
                }
            }
            double av = tong / count;
            DemoClass objDis = new DemoClass();
            objDis.setName(listCity.get(j));
            objDis.setTbPopulation(Math.round(av * 10.0) / 10.0);
            listDistri.add(objDis);//city,av
        }
        Collections.sort(listDistri);
        double min = listDistri.get(0).getTbPopulation().doubleValue();
        double max = listDistri.get(listDistri.size()-1).getTbPopulation().doubleValue();
        double kc = 6;

        for(int i=0;i<=9;i++){
            listRange.add((Math.round((min+kc*i) * 10.0) / 10.0));
            listCou.add(0);
        }
        for(int j=0 ;j<listRange.size();j++){
            for(int i = 0;i<listDistri.size();i++){
                if(j==0){
                    if(listDistri.get(i).getTbPopulation().doubleValue()<=listRange.get(j).doubleValue()){
                        listCou.set(j,listCou.get(j)+1);
                    }
                }else {
                    if(listDistri.get(i).getTbPopulation().doubleValue()<=listRange.get(j).doubleValue()
                            &&listDistri.get(i).getTbPopulation().doubleValue()>listRange.get(j-1).doubleValue()){
                        listCou.set(j,listCou.get(j)+1);
                    }
                }
            }
        }
        for (int i = 0; i < listRange.size(); i++) {
            dataset.addValue(listCou.get(i), "Immigration Rate",listRange.get(i).doubleValue() + "" );
        }
        return dataset;
    }
    // code hoang anh
    @Override
    public void capitalBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatData1(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void economicBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatData2(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    @Override
    public void distributionBarChar(List<DataProvinceInVietNam> data, String applicationTitle, String chartTitle, String dataX, String dataY, PlotOrientation plotOrientation, Boolean legend, Boolean tolltips, Boolean urls, int width, int height) {
        CategoryDataset categoryDataset = this.formatData3(data);
        BaseBarChart barChar = new BaseBarChart(applicationTitle, chartTitle, dataX, dataY, categoryDataset, plotOrientation, legend, tolltips, urls, width, height);
        barChar.pack();
        RefineryUtilities.centerFrameOnScreen(barChar);
        barChar.setVisible(true);
    }

    private CategoryDataset formatData1(List<DataProvinceInVietNam> data) {
        List<DataProvinceInVietNam> Hanoi = data.stream().filter(item -> item.getName().equals("Hà Nội")).toList();

        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for (DataProvinceInVietNam province : Hanoi) {
            if (province.getAcreage() != 0) {
                Double doubleAcreage = province.getAcreage();
                Number numberAcreage = (Number) doubleAcreage;
                dataset.addValue(numberAcreage, province.getName(), province.getYear());
            }
        }
        return dataset;
    }

    private CategoryDataset formatData2(List<DataProvinceInVietNam> data) {
        List<String> listCity = new ArrayList<>();
        listCity.add("Hải Phòng");
        listCity.add("Quảng Ninh");
        listCity.add("Thanh Hóa");
        listCity.add("Hà Tĩnh");
        listCity.add("Quảng Bình");
        listCity.add("Nghệ An");
        listCity.add("Quảng Nam");
        listCity.add("Quảng Ngãi");
        listCity.add("Bình Định");
        listCity.add("Thừa Thiên Huế");
        listCity.add("Phú Yên");
        listCity.add("Trà Vinh");
        listCity.add("Cà Mau");
        listCity.add("Kiên Giang");
        listCity.add("Quảng Trị");
        listCity.add("Thái Bình");
        listCity.add("Nam Định");

        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();
        for (int j = 0; j < data.size(); j++) {
            for (int i = 0; i < listCity.size(); i++) {
                if (data.get(j).getName().equals(listCity.get(i))) {
                    if (data.get(j).getAcreage() != 0) {
                        Double doubleAcreage = data.get(j).getAcreage();
                        Number numberAcreage = (Number) doubleAcreage;
                        dataset.addValue(numberAcreage, data.get(j).getName(), data.get(j).getYear());
                    }
                }
            }
        }
        return dataset;
    }


    private CategoryDataset formatData3(List<DataProvinceInVietNam> data) {
        List<String> listCity = new ArrayList<>();
        List<DistributionHA> listDistri = new ArrayList<>();
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for (int i = 0; i < data.size(); i++) {
            if (!listCity.contains(data.get(i).getName()) && data.get(i).getCheckCountry() == false && !data.get(i).getName().equals("Hà Tây")) {
                listCity.add(data.get(i).getName());
            }
        }

        for (int j = 0; j < listCity.size(); j++) {
            double citySum = 0;
            int count = 0;
            double ave = 0;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).getName().equals(listCity.get(j)) &&data.get(i).getPopulationDensity()!=0.0) {
                    citySum += data.get(i).getPopulationDensity();
                    count++;
                }
            }
            ave = citySum / count;
            DistributionHA ds = new DistributionHA();
            ds.setAve(Math.round(ave * 10.0) / 10.0);
            ds.setName(listCity.get(j));
            listDistri.add(ds);
        }
        Collections.sort(listDistri);

        int min = listDistri.get(0).getAve().intValue();
        int max = Collections.max(listDistri).getAve().intValue();

        int kc = (max - min) / 9;
        List<Integer> list = new ArrayList<>();
        List<Integer> listCou = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(min + kc * i);
            listCou.add(0);
        }
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < listDistri.size(); i++) {
                if (j == 0) {
                    if (listDistri.get(i).getAve() <= list.get(j)) {
                        listCou.set(j, listCou.get(j) + 1);
                    }
                } else {
                    if (listDistri.get(i).getAve() > list.get(j) && listDistri.get(i).getAve() >= list.get(j - 1)) {
                        listCou.set(j, listCou.get(j) + 1);
                    }
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            dataset.addValue(listCou.get(i), "Population Density", list.get(i) + "");
        }
        return dataset;
    }
}
