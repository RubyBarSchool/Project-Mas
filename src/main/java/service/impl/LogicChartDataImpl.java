package service.impl;

import entity.DataProvinceInVietNam;
import service.LogicChartData;
import vo.AllProviceAvePopulation;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

public class LogicChartDataImpl implements LogicChartData {

    @Override
    public void descriptiveStatistics(List<DataProvinceInVietNam> data) {
        List<Double> listYear = new ArrayList<>();
        List<Double> listAveragePopulation = new ArrayList<>();
        List<Double> listAveragePopulationCity = new ArrayList<>();
        List<Double> listAveragePopulationCountryside = new ArrayList<>();
        List<Double> listAcreage = new ArrayList<>();
        List<Double> listPopulationDensity = new ArrayList<>();
        List<Double> listImmigration = new ArrayList<>();
        List<Double> listMigration = new ArrayList<>();
        // add data in list
        for (DataProvinceInVietNam dataProvinceInVietNam : data){
            if((double) dataProvinceInVietNam.getYear() !=0){
                listYear.add((double) dataProvinceInVietNam.getYear());
            }
            if(dataProvinceInVietNam.getAveragePopulation()!=0){
                listAveragePopulation.add(dataProvinceInVietNam.getAveragePopulation());
            }
            if(dataProvinceInVietNam.getAveragePopulationCity()!=0){
                listAveragePopulationCity.add(dataProvinceInVietNam.getAveragePopulationCity());
            }
            if(dataProvinceInVietNam.getAveragePopulationCountryside()!=0){
                listAveragePopulationCountryside.add(dataProvinceInVietNam.getAveragePopulationCountryside());
            }
            if(dataProvinceInVietNam.getAcreage()!=0){
                listAcreage.add(dataProvinceInVietNam.getAcreage());
            }
            if(dataProvinceInVietNam.getPopulationDensity()!=0){
                listPopulationDensity.add(dataProvinceInVietNam.getPopulationDensity());
            }
            if(dataProvinceInVietNam.getImmigration()!=0){
                listImmigration.add(dataProvinceInVietNam.getImmigration());
            }
            if(dataProvinceInVietNam.getMigration()!=0){
                listMigration.add(dataProvinceInVietNam.getMigration());
            }
        }
        // sort theo chieu tang dan de làm q1 q2 q3
        Collections.sort(listYear);
        Collections.sort(listAveragePopulation);
        Collections.sort(listAveragePopulationCity);
        Collections.sort(listAveragePopulationCountryside);
        Collections.sort(listAcreage);
        Collections.sort(listPopulationDensity);
        Collections.sort(listImmigration);
        Collections.sort(listMigration);

        List<Double> dataShow = new ArrayList<>();
        // add count
        dataShow.add((double) listYear.size());
        dataShow.add((double) listAveragePopulation.size());
        dataShow.add((double) listAveragePopulationCity.size());
        dataShow.add((double) listAveragePopulationCountryside.size());
        dataShow.add((double) listAcreage.size());
        dataShow.add((double) listPopulationDensity.size());
        dataShow.add((double) listImmigration.size());
        dataShow.add((double) listMigration.size());
        // add mean
        double meanYear = meanDescriptiveStatistics(listYear);
        double meanAveragePopulation = meanDescriptiveStatistics(listAveragePopulation);
        double meanAveragePopulationCity = meanDescriptiveStatistics(listAveragePopulationCity);
        double meanAveragePopulationCountryside = meanDescriptiveStatistics(listAveragePopulationCountryside);
        double meanAcreage = meanDescriptiveStatistics(listAcreage);
        double meanPopulationDensity = meanDescriptiveStatistics(listPopulationDensity);
        double meanImmigration = meanDescriptiveStatistics(listImmigration);
        double meanMigration = meanDescriptiveStatistics(listMigration);
        dataShow.add(meanYear);
        dataShow.add(meanAveragePopulation);
        dataShow.add(meanAveragePopulationCity);
        dataShow.add(meanAveragePopulationCountryside);
        dataShow.add(meanAcreage);
        dataShow.add(meanPopulationDensity);
        dataShow.add(meanImmigration);
        dataShow.add(meanMigration);
        // add variance
        dataShow.add(varianceDescriptiveStatistics(meanYear,listYear));
        dataShow.add(varianceDescriptiveStatistics(meanAveragePopulation,listAveragePopulation));
        dataShow.add(varianceDescriptiveStatistics(meanAveragePopulationCity,listAveragePopulationCity));
        dataShow.add(varianceDescriptiveStatistics(meanAveragePopulationCountryside,listAveragePopulationCountryside));
        dataShow.add(varianceDescriptiveStatistics(meanAcreage,listAcreage));
        dataShow.add(varianceDescriptiveStatistics(meanPopulationDensity,listPopulationDensity));
        dataShow.add(varianceDescriptiveStatistics(meanImmigration,listImmigration));
        dataShow.add(varianceDescriptiveStatistics(meanMigration,listMigration));
        // add min
        dataShow.add(listYear.get(0));
        dataShow.add(listAveragePopulation.get(0));
        dataShow.add(listAveragePopulationCity.get(0));
        dataShow.add(listAveragePopulationCountryside.get(0));
        dataShow.add(listAcreage.get(0));
        dataShow.add(listPopulationDensity.get(0));
        dataShow.add(listImmigration.get(0));
        dataShow.add(listMigration.get(0));
        // Q1
        dataShow.add(listYear.get((int) ((1+listYear.size())*0.25)));
        dataShow.add(listAveragePopulation.get((int) ((1+listAveragePopulation.size())*0.25)));
        dataShow.add(listAveragePopulationCity.get((int) ((1+listAveragePopulationCity.size())*0.25)));
        dataShow.add(listAveragePopulationCountryside.get((int) ((1+listAveragePopulationCountryside.size())*0.25)));
        dataShow.add(listAcreage.get((int) ((1+listAcreage.size())*0.25)));
        dataShow.add(listPopulationDensity.get((int) ((1+listPopulationDensity.size())*0.25)));
        dataShow.add(listImmigration.get((int) ((1+listImmigration.size())*0.25)));
        dataShow.add(listMigration.get((int) ((1+listMigration.size())*0.25)));
        // Q2
        dataShow.add(listYear.get((int) ((1+listYear.size())*0.5)));
        dataShow.add(listAveragePopulation.get((int) ((1+listAveragePopulation.size())*0.5)));
        dataShow.add(listAveragePopulationCity.get((int) ((1+listAveragePopulationCity.size())*0.5)));
        dataShow.add(listAveragePopulationCountryside.get((int) ((1+listAveragePopulationCountryside.size())*0.5)));
        dataShow.add(listAcreage.get((int) ((1+listAcreage.size())*0.5)));
        dataShow.add(listPopulationDensity.get((int) ((1+listPopulationDensity.size())*0.5)));
        dataShow.add(listImmigration.get((int) ((1+listImmigration.size())*0.5)));
        dataShow.add(listMigration.get((int) ((1+listMigration.size())*0.5)));
        //Q3
        dataShow.add(listYear.get((int) ((1+listYear.size())*0.75)));
        dataShow.add(listAveragePopulation.get((int) ((1+listAveragePopulation.size())*0.75)));
        dataShow.add(listAveragePopulationCity.get((int) ((1+listAveragePopulationCity.size())*0.75)));
        dataShow.add(listAveragePopulationCountryside.get((int) ((1+listAveragePopulationCountryside.size())*0.75)));
        dataShow.add(listAcreage.get((int) ((1+listAcreage.size())*0.75)));
        dataShow.add(listPopulationDensity.get((int) ((1+listPopulationDensity.size())*0.75)));
        dataShow.add(listImmigration.get((int) ((1+listImmigration.size())*0.75)));
        dataShow.add(listMigration.get((int) ((1+listMigration.size())*0.75)));
        // add max
        dataShow.add(listYear.get(listYear.size()-1));
        dataShow.add(listAveragePopulation.get(listAveragePopulation.size()-1));
        dataShow.add(listAveragePopulationCity.get(listAveragePopulationCity.size()-1));
        dataShow.add(listAveragePopulationCountryside.get(listAveragePopulationCountryside.size()-1));
        dataShow.add(listAcreage.get(listAcreage.size()-1));
        dataShow.add(listPopulationDensity.get(listPopulationDensity.size()-1));
        dataShow.add(listImmigration.get(listImmigration.size()-1));
        dataShow.add(listMigration.get(listMigration.size()-1));

        System.out.println("                              "+"Year                          "+
                "AveragePopulation             "+"AveragePopulationCity         "+"AveragePopulationCountryside  "
                +"Acreage                       "+"PopulationDensity             "+"Immigration                   "+"Migration                     ");
        for(int i = 0 ; i < 8 ; i++ ){
            String show = "";
            if(i == 0){
                show += "Count"+"                              ".substring(5);
            }else if(i == 1 ){
                show += "Mean"+"                              ".substring(4);
            }
            else if(i == 2 ){
                show += "Std"+"                              ".substring(3);
            }
            else if(i == 3 ){
                show += "Min"+"                              ".substring(3);
            }else if(i == 4 ){
                show += "Q1:25%"+"                              ".substring(6);
            }else if(i == 5 ){
                show += "Q2:50%"+"                              ".substring(6);
            }else if(i == 6 ){
                show += "Q3:75%"+"                              ".substring(6);
            }else if(i == 7 ){
                show += "Max"+"                              ".substring(3);
            }
            for (int j = 0 ; j < 8 ; j++){
                String x = dataShow.get(i*8+j)+"";
                show+=x+"                              ".substring(x.length());
            }
            System.out.println(show);
        }
    }

    Double meanDescriptiveStatistics(List<Double> data){
        Double total = 0.0;
        for (Double d : data){
            total+= d;
        }
        return (double) Math.round(total/data.size() * 10) / 10 ;
    }

    Double varianceDescriptiveStatistics(Double mean,List<Double> data){
        Double va = 0.0;
        for (Double d : data) {
            va += Math.pow((d - mean), 2);
        }
        return (double) Math.round(Math.sqrt(va / (data.size() - 1)) * 10) / 10 ;
    }



    @Override
    public void dataWithPopulation(List<DataProvinceInVietNam> data) {
        List<DataProvinceInVietNam> dataProvinceInVietNams = new ArrayList<>();
        List<String> namePlace = new ArrayList<>();
        namePlace.add("Đồng bằng sông Hồng");
        namePlace.add("Trung du và miền núi phía Bắc");
        namePlace.add("Bắc Trung Bộ và Duyên hải miền Trung");
        namePlace.add("Đồng bằng sông Cửu Long");
        namePlace.add("Đông Nam Bộ");
        namePlace.add("CẢ NƯỚC");
        System.out.println("Top 10 max and top 10 min population\n");
        for (DataProvinceInVietNam dataProvinceInVietNam : data) {
            if (dataProvinceInVietNam.getYear() == 2018 && !dataProvinceInVietNam.getCheckCountry() && dataProvinceInVietNam.getAveragePopulation() != 0 && !namePlace.contains(dataProvinceInVietNam.getName())) {
                dataProvinceInVietNams.add(dataProvinceInVietNam);
            }
        }
        dataProvinceInVietNams.sort(new Comparator<DataProvinceInVietNam>() {
            @Override
            public int compare(DataProvinceInVietNam o1, DataProvinceInVietNam o2) {
                if (o1.getAveragePopulation() == o2.getAveragePopulation()) {
                    return 0;
                } else if (o1.getAveragePopulation() > o2.getAveragePopulation()) {
                    return 1;
                }
                return -1;
            }
        }.reversed());
        List<String> names = new ArrayList<>();
        System.out.println("Name ---------- Population\n");
        for (int i = 0; i < dataProvinceInVietNams.size(); i++) {
            if (i < 10 || i >= dataProvinceInVietNams.size() - 10) {
                System.out.println(dataProvinceInVietNams.get(i).getName() + " ---------- " + dataProvinceInVietNams.get(i).getAveragePopulation());
                names.add(dataProvinceInVietNams.get(i).getName());
            }
        }
        AllProviceAvePopulation allProviceAvePopulationSample = new AllProviceAvePopulation();
        List<AllProviceAvePopulation> allProviceAvePopulationsSample = new ArrayList<>();
        AllProviceAvePopulation allProviceAvePopulation = new AllProviceAvePopulation();
        List<AllProviceAvePopulation> allProviceAvePopulations = new ArrayList<>();
        for (DataProvinceInVietNam datax : data) {
            if (names.contains(datax.getName()) && datax.getYear() == 1995 && !namePlace.contains(datax.getName())) {
                if (!datax.getName().equals(allProviceAvePopulationSample.getName())) {
                    allProviceAvePopulationsSample.add(allProviceAvePopulationSample);
                    allProviceAvePopulationSample = new AllProviceAvePopulation();
                }
                allProviceAvePopulationSample.setName(datax.getName());
                allProviceAvePopulationSample.setTotal(allProviceAvePopulationSample.getTotal() + datax.getAveragePopulation());
                allProviceAvePopulationSample.setCount(allProviceAvePopulationSample.getCount() + 1);
            }

            if (datax.getYear() == 1995 && !namePlace.contains(datax.getName())) {
                if (!datax.getName().equals(allProviceAvePopulation.getName())) {
                    allProviceAvePopulations.add(allProviceAvePopulation);
                    allProviceAvePopulation = new AllProviceAvePopulation();
                }
                allProviceAvePopulation.setName(datax.getName());
                allProviceAvePopulation.setTotal(allProviceAvePopulation.getTotal() + datax.getAveragePopulation());
                allProviceAvePopulation.setCount(allProviceAvePopulation.getCount() + 1);
            }
        }
        allProviceAvePopulationsSample.add(allProviceAvePopulationSample);
        allProviceAvePopulationsSample.remove(0);
        allProviceAvePopulations.add(allProviceAvePopulation);
        allProviceAvePopulations.remove(0);
        for (AllProviceAvePopulation allProviceAvePopulation1 : allProviceAvePopulationsSample) {
            allProviceAvePopulation1.setTotal(allProviceAvePopulation1.getTotal() / allProviceAvePopulationSample.getCount());
        }
        for (AllProviceAvePopulation allProviceAvePopulation1 : allProviceAvePopulations) {
            allProviceAvePopulation1.setTotal(allProviceAvePopulation1.getTotal() / allProviceAvePopulation1.getCount());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("n sample: " + allProviceAvePopulationsSample.size());
        Double mean = this.mean(allProviceAvePopulationsSample);
        System.out.println("mean: " + mean.doubleValue());
        Double variance = this.variance(mean, allProviceAvePopulationsSample);
        System.out.println("variance: " + variance.doubleValue());
        // 95 % t0.025,19
        Double t_score = 2.093;
        System.out.println("t_score: " + t_score.doubleValue());
        System.out.println("The lower of the 95% confidence interval of the average length of country population in 1995:" + min_t(mean, variance, t_score, allProviceAvePopulationsSample.size()).doubleValue());
        System.out.println("The upper of the 95% confidence interval of the average length of country population in 1995:" + max_t(mean, variance, t_score, allProviceAvePopulationsSample.size()).doubleValue());
        System.out.println("Mean population in 1995: " + mean(allProviceAvePopulations).doubleValue());


        allProviceAvePopulationSample = new AllProviceAvePopulation();
        allProviceAvePopulationsSample = new ArrayList<>();
        allProviceAvePopulation = new AllProviceAvePopulation();
        allProviceAvePopulations = new ArrayList<>();
        for (DataProvinceInVietNam datax : data) {
            if (names.contains(datax.getName()) && !namePlace.contains(datax.getName())) {
                if (!datax.getName().equals(allProviceAvePopulationSample.getName())) {
                    allProviceAvePopulationsSample.add(allProviceAvePopulationSample);
                    allProviceAvePopulationSample = new AllProviceAvePopulation();
                }
                allProviceAvePopulationSample.setName(datax.getName());
                allProviceAvePopulationSample.setTotal(allProviceAvePopulationSample.getTotal() + datax.getAveragePopulation());
                allProviceAvePopulationSample.setCount(allProviceAvePopulationSample.getCount() + 1);
            }

            if (!namePlace.contains(datax.getName())) {
                if (!datax.getName().equals(allProviceAvePopulation.getName())) {
                    allProviceAvePopulations.add(allProviceAvePopulation);
                    allProviceAvePopulation = new AllProviceAvePopulation();
                }
                allProviceAvePopulation.setName(datax.getName());
                allProviceAvePopulation.setTotal(allProviceAvePopulation.getTotal() + datax.getAveragePopulation());
                allProviceAvePopulation.setCount(allProviceAvePopulation.getCount() + 1);
            }
        }
        allProviceAvePopulationsSample.add(allProviceAvePopulationSample);
        allProviceAvePopulationsSample.remove(0);
        allProviceAvePopulations.add(allProviceAvePopulation);
        allProviceAvePopulations.remove(0);
        for (AllProviceAvePopulation allProviceAvePopulation1 : allProviceAvePopulationsSample) {
            allProviceAvePopulation1.setTotal(allProviceAvePopulation1.getTotal() / allProviceAvePopulationSample.getCount());
        }
        for (AllProviceAvePopulation allProviceAvePopulation1 : allProviceAvePopulations) {
            allProviceAvePopulation1.setTotal(allProviceAvePopulation1.getTotal() / allProviceAvePopulation1.getCount());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("n sample: " + allProviceAvePopulationsSample.size());
        mean = this.mean(allProviceAvePopulationsSample);
        System.out.println("mean: " + mean.doubleValue());
        variance = this.variance(mean, allProviceAvePopulationsSample);
        System.out.println("variance: " + variance.doubleValue());
        System.out.println("t_score: " + t_score.doubleValue());
        System.out.println("The lower of the 95% confidence interval of the average length of country population:" + min_t(mean, variance, t_score, allProviceAvePopulationsSample.size()).doubleValue());
        System.out.println("The upper of the 95% confidence interval of the average length of country population:" + max_t(mean, variance, t_score, allProviceAvePopulationsSample.size()).doubleValue());
        System.out.println("Mean population: " + mean(allProviceAvePopulations).doubleValue());

    }

    @Override
    public void dataWithPopulationDensity(List<DataProvinceInVietNam> data) {
        List<DataProvinceInVietNam> dataProvinceInVietNams = new ArrayList<>();
        List<String> namePlace = new ArrayList<>();
        namePlace.add("Đồng bằng sông Hồng");
        namePlace.add("Trung du và miền núi phía Bắc");
        namePlace.add("Bắc Trung Bộ và Duyên hải miền Trung");
        namePlace.add("Đồng bằng sông Cửu Long");
        namePlace.add("Đông Nam Bộ");
        namePlace.add("CẢ NƯỚC");
        System.out.println("Top 10 max and top 10 min population density\n");
        for (DataProvinceInVietNam dataProvinceInVietNam : data) {
            if (dataProvinceInVietNam.getYear() == 2018 && !dataProvinceInVietNam.getCheckCountry() && dataProvinceInVietNam.getPopulationDensity() != 0 && !namePlace.contains(dataProvinceInVietNam.getName())) {
                dataProvinceInVietNams.add(dataProvinceInVietNam);
            }
        }
        dataProvinceInVietNams.sort(new Comparator<DataProvinceInVietNam>() {
            @Override
            public int compare(DataProvinceInVietNam o1, DataProvinceInVietNam o2) {
                if (o1.getPopulationDensity() == o2.getPopulationDensity()) {
                    return 0;
                } else if (o1.getPopulationDensity() > o2.getPopulationDensity()) {
                    return 1;
                }
                return -1;
            }
        }.reversed());
        List<String> names = new ArrayList<>();

        System.out.println("Name ---------- Population Density\n");
        for (int i = 0; i < dataProvinceInVietNams.size(); i++) {
            if (i < 10 || i >= dataProvinceInVietNams.size() - 10) {
                System.out.println(dataProvinceInVietNams.get(i).getName() + " ---------- " + dataProvinceInVietNams.get(i).getPopulationDensity());
                names.add(dataProvinceInVietNams.get(i).getName());
            }
        }
        AllProviceAvePopulation allProviceAvePopulationSample = new AllProviceAvePopulation();
        List<AllProviceAvePopulation> allProviceAvePopulationsSample = new ArrayList<>();
        AllProviceAvePopulation allProviceAvePopulation = new AllProviceAvePopulation();
        List<AllProviceAvePopulation> allProviceAvePopulations = new ArrayList<>();
        for (DataProvinceInVietNam datax : data) {
            if (names.contains(datax.getName()) && datax.getYear() == 2011 && !namePlace.contains(datax.getName())) {
                if (!datax.getName().equals(allProviceAvePopulationSample.getName())) {
                    allProviceAvePopulationsSample.add(allProviceAvePopulationSample);
                    allProviceAvePopulationSample = new AllProviceAvePopulation();
                }
                allProviceAvePopulationSample.setName(datax.getName());
                allProviceAvePopulationSample.setTotal(allProviceAvePopulationSample.getTotal() + datax.getPopulationDensity());
                allProviceAvePopulationSample.setCount(allProviceAvePopulationSample.getCount() + 1);
            }

            if (datax.getYear() == 2011 && !namePlace.contains(datax.getName())) {
                if (!datax.getName().equals(allProviceAvePopulation.getName())) {
                    allProviceAvePopulations.add(allProviceAvePopulation);
                    allProviceAvePopulation = new AllProviceAvePopulation();
                }
                allProviceAvePopulation.setName(datax.getName());
                allProviceAvePopulation.setTotal(allProviceAvePopulation.getTotal() + datax.getPopulationDensity());
                allProviceAvePopulation.setCount(allProviceAvePopulation.getCount() + 1);
            }
        }
        allProviceAvePopulationsSample.add(allProviceAvePopulationSample);
        allProviceAvePopulationsSample.remove(0);

        allProviceAvePopulations.add(allProviceAvePopulation);
        allProviceAvePopulations.remove(0);

        for (AllProviceAvePopulation allProviceAvePopulation1 : allProviceAvePopulationsSample) {
            allProviceAvePopulation1.setTotal(allProviceAvePopulation1.getTotal() / allProviceAvePopulationSample.getCount());
        }

        for (AllProviceAvePopulation allProviceAvePopulation1 : allProviceAvePopulations) {
            allProviceAvePopulation1.setTotal(allProviceAvePopulation1.getTotal() / allProviceAvePopulation1.getCount());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("n sample: " + allProviceAvePopulationsSample.size());
        Double mean = this.mean(allProviceAvePopulationsSample);
        System.out.println("mean: " + mean.doubleValue());
        Double variance = this.variance(mean, allProviceAvePopulationsSample);
        System.out.println("variance: " + variance.doubleValue());
        // 95 % t0.025,19
        Double t_score = 2.093;
        System.out.println("t_score: " + t_score.doubleValue());
        System.out.println("The lower of the 95% confidence interval of the average length of country population density in 2011:" + min_t(mean, variance, t_score, allProviceAvePopulationsSample.size()).doubleValue());
        System.out.println("The upper of the 95% confidence interval of the average length of country population density in 2011:" + max_t(mean, variance, t_score, allProviceAvePopulationsSample.size()).doubleValue());
        System.out.println("Mean population in 2011: " + mean(allProviceAvePopulations).doubleValue());


        allProviceAvePopulationSample = new AllProviceAvePopulation();
        allProviceAvePopulationsSample = new ArrayList<>();
        allProviceAvePopulation = new AllProviceAvePopulation();
        allProviceAvePopulations = new ArrayList<>();
        for (DataProvinceInVietNam datax : data) {
            if (names.contains(datax.getName()) && !namePlace.contains(datax.getName())) {
                if (!datax.getName().equals(allProviceAvePopulationSample.getName())) {
                    allProviceAvePopulationsSample.add(allProviceAvePopulationSample);
                    allProviceAvePopulationSample = new AllProviceAvePopulation();
                }
                allProviceAvePopulationSample.setName(datax.getName());
                allProviceAvePopulationSample.setTotal(allProviceAvePopulationSample.getTotal() + datax.getAveragePopulation());
                allProviceAvePopulationSample.setCount(allProviceAvePopulationSample.getCount() + 1);
            }

            if (!namePlace.contains(datax.getName())) {
                if (!datax.getName().equals(allProviceAvePopulation.getName())) {
                    allProviceAvePopulations.add(allProviceAvePopulation);
                    allProviceAvePopulation = new AllProviceAvePopulation();
                }
                allProviceAvePopulation.setName(datax.getName());
                allProviceAvePopulation.setTotal(allProviceAvePopulation.getTotal() + datax.getAveragePopulation());
                allProviceAvePopulation.setCount(allProviceAvePopulation.getCount() + 1);
            }
        }
        allProviceAvePopulationsSample.add(allProviceAvePopulationSample);
        allProviceAvePopulationsSample.remove(0);

        allProviceAvePopulations.add(allProviceAvePopulation);
        allProviceAvePopulations.remove(0);

        for (AllProviceAvePopulation allProviceAvePopulation1 : allProviceAvePopulationsSample) {
            allProviceAvePopulation1.setTotal(allProviceAvePopulation1.getTotal() / allProviceAvePopulationSample.getCount());
        }

        for (AllProviceAvePopulation allProviceAvePopulation1 : allProviceAvePopulations) {
            allProviceAvePopulation1.setTotal(allProviceAvePopulation1.getTotal() / allProviceAvePopulation1.getCount());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("n sample: " + allProviceAvePopulationsSample.size());
        mean = this.mean(allProviceAvePopulationsSample);
        System.out.println("mean: " + mean.doubleValue());
        variance = this.variance(mean, allProviceAvePopulationsSample);
        System.out.println("variance: " + variance.doubleValue());
        System.out.println("t_score: " + t_score.doubleValue());
        System.out.println("The lower of the 95% confidence interval of the average length of country population:" + min_t(mean, variance, t_score, allProviceAvePopulationsSample.size()).doubleValue());
        System.out.println("The upper of the 95% confidence interval of the average length of country population:" + max_t(mean, variance, t_score, allProviceAvePopulationsSample.size()).doubleValue());
        System.out.println("Mean population: " + mean(allProviceAvePopulations).doubleValue());
    }

    @Override
    public void dataWithImmigrationAndMigrationOfHaNOi(List<DataProvinceInVietNam> data) {
        List<DataProvinceInVietNam> dataProvinceInVietNams = new ArrayList<>();
        for (DataProvinceInVietNam dataProvinceInVietNam : data) {
            if (dataProvinceInVietNam.getName().equals("Hà Nội") && dataProvinceInVietNam.getMigration() != 0.0 && dataProvinceInVietNam.getImmigration() != 0.0) {
                dataProvinceInVietNams.add(dataProvinceInVietNam);
            }
        }
        int count = 0;
        for (DataProvinceInVietNam dataProvinceInVietNam : dataProvinceInVietNams) {
            Double inverse = dataProvinceInVietNam.getImmigration() / dataProvinceInVietNam.getMigration();
            if (inverse > 1) {
                count++;
            }
        }
        // 95% = (1-a)  za/2
        Double z_score = 1.96;
        System.out.println("Z_SCROE: " + z_score);
        int n = dataProvinceInVietNams.size();
        System.out.println("n of sample: " + n);
        double proportion_sample = count * 1.0 / n;
        System.out.println("proportion of observations sample: " + proportion_sample);
        System.out.println("The lower of the 95% confidence interval of the proportion that immigration and migration of Ha Noi more than 1: " + min_p(proportion_sample, z_score, n));
        System.out.println("The upper of the 95% confidence interval of the proportion that immigration and migration of Ha Noi more than 1: " + max_p(proportion_sample, z_score, n));

    }

    @Override
    public void dataWithImmigrationAndMigrationOfHoChiMInhAndHaNoi(List<DataProvinceInVietNam> data) {
        List<DataProvinceInVietNam> dataProvinceInVietNams = new ArrayList<>();
        List<DataProvinceInVietNam> dataProvinceInVietNamsHCM = new ArrayList<>();
        for (DataProvinceInVietNam dataProvinceInVietNam : data) {
            if (dataProvinceInVietNam.getName().equals("Hà Nội") && dataProvinceInVietNam.getMigration() != 0.0 && dataProvinceInVietNam.getImmigration() != 0.0) {
                dataProvinceInVietNams.add(dataProvinceInVietNam);
            }
            if (dataProvinceInVietNam.getName().equals("TP.Hồ Chí Minh") && dataProvinceInVietNam.getMigration() != 0.0 && dataProvinceInVietNam.getImmigration() != 0.0) {
                dataProvinceInVietNamsHCM.add(dataProvinceInVietNam);
            }
        }
        int count = 0;
        int countHCM = 0;
        for (DataProvinceInVietNam dataProvinceInVietNam : dataProvinceInVietNams) {
            Double inverse = dataProvinceInVietNam.getImmigration() / dataProvinceInVietNam.getMigration();
            if (inverse > 2) {
                count++;
            }
        }
        for (DataProvinceInVietNam dataProvinceInVietNam : dataProvinceInVietNamsHCM) {
            Double inverse = dataProvinceInVietNam.getImmigration() / dataProvinceInVietNam.getMigration();
            if (inverse > 2) {
                countHCM++;
            }
        }
        // 95% za
        System.out.println("H0: p1 = p2");
        System.out.println("H1: p1 > p2");
        Double z_score = 1.64;
        System.out.println("Z_SCROE: " + z_score);
        int n = dataProvinceInVietNams.size();
        System.out.println("n of sample Ha Noi: " + n);
        int nhcm = dataProvinceInVietNams.size();
        System.out.println("n of sample Ho Chi Minh: " + nhcm);
        double proportion_sample = count * 1.0 / n;
        System.out.println("proportion of observations sample HN: " + proportion_sample);
        double proportion_sample_hcm = countHCM * 1.0 / nhcm;
        System.out.println("proportion of observations sample HCM: " + proportion_sample_hcm);
        double proportion = (count + countHCM) * 1.0 / (n + nhcm);
        System.out.println("proportion of observations sample HCM and HN: " + proportion);
        double testStatic = (proportion_sample_hcm - proportion_sample) / Math.sqrt(proportion * (1 - proportion) * ((1.0 / n) + (1.0 / nhcm)));
        System.out.println("z0 = " + testStatic);
        System.out.println("Since z0 > z_score ,corect rejection creiteria then reject the null hypothesis");
    }

    @Override
    public void dataWithPopulationOfHoChiMInhAndHaNoi(List<DataProvinceInVietNam> data) {
        List<AllProviceAvePopulation> dataProvinceInVietNams = new ArrayList<>();
        List<AllProviceAvePopulation> dataProvinceInVietNamsHCM = new ArrayList<>();
        for (DataProvinceInVietNam dataProvinceInVietNam : data) {
            if (dataProvinceInVietNam.getName().equals("Hà Nội")) {
                AllProviceAvePopulation allProviceAvePopulation = new AllProviceAvePopulation();
                allProviceAvePopulation.setTotal(dataProvinceInVietNam.getAveragePopulation());
                allProviceAvePopulation.setCount(allProviceAvePopulation.getCount() + 1);
                dataProvinceInVietNams.add(allProviceAvePopulation);
            }
            if (dataProvinceInVietNam.getName().equals("TP.Hồ Chí Minh")) {
                AllProviceAvePopulation allProviceAvePopulation = new AllProviceAvePopulation();
                allProviceAvePopulation.setTotal(dataProvinceInVietNam.getAveragePopulation());
                allProviceAvePopulation.setCount(allProviceAvePopulation.getCount() + 1);
                dataProvinceInVietNamsHCM.add(allProviceAvePopulation);
            }
        }
        System.out.println("H0: u1  = u2");
        System.out.println("H1: u1 != u2");
        System.out.println("Ta nhận thấy là biến thiên về dân cư 2 thành phố khác nhau khá rõ rệt cùng với tốc độ nhập cư và tăng dân số khác nhau lên ta giả sử  O1^2 != O2^2");
        int nHN = dataProvinceInVietNams.size();
        System.out.println("N of HN: " + nHN);
        int nHCM = dataProvinceInVietNamsHCM.size();
        System.out.println("N of HCM: " + nHCM);
        double meanHN = mean(dataProvinceInVietNams);
        System.out.println("mean sample of HN: " + meanHN);
        double meanHCM = mean(dataProvinceInVietNamsHCM);
        System.out.println("mean sample of HCM: " + meanHCM);
        double varianceHN = variance(meanHN, dataProvinceInVietNams);
        System.out.println("variance sample of HN: " + varianceHN);
        double varianceHCM = variance(meanHCM, dataProvinceInVietNamsHCM);
        System.out.println("variance sample of HCM: " + varianceHCM);
        double t0 = (meanHN - meanHCM) / Math.sqrt((Math.pow(varianceHN, 2) / nHN) + Math.pow(varianceHCM, 2) / nHCM);
        System.out.println("Test static: " + t0);
        double degrees_of_free = Math.pow(((Math.pow(varianceHN, 2) / nHN) + (Math.pow(varianceHCM,2)/nHCM)), 2)/((Math.pow((Math.pow(varianceHN,2)/nHN),2)/(nHN-1))+(Math.pow((Math.pow(varianceHCM,2)/nHCM),2)/(nHCM-1)));
        System.out.println("degrees_of_free: " + degrees_of_free);
        System.out.println("Using  t of 0.025,38 = 2.024");
        System.out.println("Reject hypothesis because t0 < -t0.25,38");
    }



    @Override
    public void dataWithImmigrationAndMigrationOfHoChiMInh(List<DataProvinceInVietNam> data) {
        List<DataProvinceInVietNam> dataProvinceInVietNams = new ArrayList<>();
        for (DataProvinceInVietNam dataProvinceInVietNam : data) {
            if (dataProvinceInVietNam.getName().equals("TP.Hồ Chí Minh") && dataProvinceInVietNam.getMigration() != 0.0 && dataProvinceInVietNam.getImmigration() != 0.0) {
                dataProvinceInVietNams.add(dataProvinceInVietNam);
            }
        }
        int count = 0;
        for (DataProvinceInVietNam dataProvinceInVietNam : dataProvinceInVietNams) {
            Double inverse = dataProvinceInVietNam.getImmigration() / dataProvinceInVietNam.getMigration();
            if (inverse > 2) {
                count++;
            }
        }
        // 95% za/2
        Double z_score = 1.96;
        System.out.println("Z_SCROE: " + z_score);
        int n = dataProvinceInVietNams.size();
        System.out.println("n of sample: " + n);
        double proportion_sample = count * 1.0 / n;
        System.out.println("proportion of observations sample: " + proportion_sample);
        System.out.println("The lower of the 95% confidence interval of the proportion that immigration and migration of Ho Chi Minh more than 2: " + min_p(proportion_sample, z_score, n));
        System.out.println("The upper of the 95% confidence interval of the proportion that immigration and migration of Ho Chi Minh more than 2: " + max_p(proportion_sample, z_score, n));

    }

    Double min_p(Double proportion, Double z_score, int size) {
        return proportion - z_score * Math.sqrt(proportion * (1 - proportion) / size);
    }

    Double max_p(Double proportion, Double z_score, int size) {
        return proportion + z_score * Math.sqrt(proportion * (1 - proportion) / size);
    }

    Double min_t(Double mean, Double variance, Double t_score, int size) {
        return mean - t_score * variance / Math.sqrt(size);
    }

    Double max_t(Double mean, Double variance, Double t_score, int size) {
        return mean + t_score * variance / Math.sqrt(size);
    }

    Double mean(List<AllProviceAvePopulation> allProviceAvePopulations) {
        Double aDouble = 0.0;
        for (AllProviceAvePopulation allProviceAvePopulation : allProviceAvePopulations) {
            aDouble += allProviceAvePopulation.getTotal();
        }
        return aDouble / allProviceAvePopulations.size();
    }

    Double variance(Double mean, List<AllProviceAvePopulation> allProviceAvePopulations) {
        Double va = 0.0;
        for (AllProviceAvePopulation allProviceAvePopulation : allProviceAvePopulations) {
            va += Math.pow((allProviceAvePopulation.getTotal() - mean), 2);
        }
        return Math.sqrt(va / (allProviceAvePopulations.size() - 1));
    }


}
