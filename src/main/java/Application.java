import entity.DataProvinceInVietNam;
import org.jfree.chart.plot.PlotOrientation;
import service.*;
import service.impl.*;
import vo.DemoClass;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        GetAllDataOfJSON iam = new GetAllDataOfJSONImpl();
        List<DataProvinceInVietNam> data = iam.getAll();
        LogicChartData logicChartData = new LogicChartDataImpl();
        System.out.println("-------------------------Descriptive Statistics---------------------------");
        logicChartData.descriptiveStatistics(data);
        System.out.println("--------------------------Question 1---------------------------");
        logicChartData.dataWithPopulation(data);
        System.out.println("--------------------------Question 2---------------------------");
        logicChartData.dataWithPopulationDensity(data);
        System.out.println("--------------------------Question 3---------------------------");
        logicChartData.dataWithImmigrationAndMigrationOfHaNOi(data);
        System.out.println("--------------------------Question 4---------------------------");
        logicChartData.dataWithImmigrationAndMigrationOfHoChiMInh(data);
        System.out.println("--------------------------Question 5---------------------------");
        logicChartData.dataWithImmigrationAndMigrationOfHoChiMInhAndHaNoi(data);
        System.out.println("--------------------------Question 6---------------------------");
        logicChartData.dataWithPopulationOfHoChiMInhAndHaNoi(data);


        // code phong
        BarChart barChart = new BarChartImpl();
        barChart.barCharCity(data,"Histogram of the percent people live in City of Area",
                "Histogram of the percent people live in City of Area", "Percent",
                "Area", PlotOrientation.VERTICAL,true,true,false,560,367);
        barChart.barCharCoutrySide(data,"Histogram of the percent people live in Country Side of Area",
                "Histogram of the percent people live in Country Side of Area", "Percent",
                "Area", PlotOrientation.VERTICAL,true,true,false,560,367);


        DoubleBarChar doubleBarChar = new DoubleBarCharImpl();
        doubleBarChar.countryPopulation(data,"Percentage of population living in City and Country Side areas by years",
                "Percentage of population living in City and Country Side areas by years","Category",
                "value", PlotOrientation.VERTICAL,true,true,false,800,500);
        doubleBarChar.largeArea(data,"Percentage of population living in City in four big area",
                "Percentage of population living in City in four big area","Category",
                "value", PlotOrientation.VERTICAL,true,true,false,800,500);

         //code minh
        BarChart barChartDacKhu = new BarChartImpl();
        barChartDacKhu.avgPopulationBarChar(data,"Các đặc khu kinh tế","Các đặc khu kinh tế","Năm",
                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,560,367);

        DoubleBarChar doubleBarCharDacKhu = new DoubleBarCharImpl();
        doubleBarCharDacKhu.avgPopulationDoubleBarChar(data,"Các đặc khu kinh tế","Các đặc khu kinh tế","Năm",
                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,590,350);

        //3 MIEN
        BarChart barChartMB = new BarChartImpl();
        barChartMB.avgPopulationBarCharMB(data,"Các vùng kinh tế","Miền Bắc","Năm",
                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,560,367);

        BarChart barChartMN = new BarChartImpl();
        barChartMB.avgPopulationBarCharMN(data,"Các vùng kinh tế","Miền Nam","Năm",
                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,560,367);

        BarChart barChartMT = new BarChartImpl();
        barChartMB.avgPopulationBarCharMT(data,"Các vùng kinh tế","Miền Trung","Năm",
                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,560,367);

        //Ca Nuoc
        BarChart distributeCaNuoc = new BarChartImpl();
        distributeCaNuoc.avgPopulationBarCharCaNuoc(data,"Histogram of average population of provinces by population interval","histogram of average population of provinces by population interval","Dân số(nghìn người)",
                "Số lượng", PlotOrientation.VERTICAL,true,true,false,560,367);

        // code ngoc
        BarChart barChartNgoc = new BarChartImpl();
        barChart.distributionMigrationRate(data,"Migration Rate Distribution","Migration Rate Distribution (2005-2019)‰","",
                "", PlotOrientation.VERTICAL,true,true,false,560,367);
        barChart.distributionIMMigrationRate(data,"Immigration Rate Distribution","Immigration Rate Distribution(2005-2019)‰","",
                "", PlotOrientation.VERTICAL,true,true,false,560,367);
        DoubleBarChar doubleBarCharNgoc = new DoubleBarCharImpl();
        doubleBarChar.doubleBarCharMigration(data,"","Migration Rate(2005-2018)‰ ","",
                "‰", PlotOrientation.VERTICAL,true,true,false,590,350);
        doubleBarChar.doubleBarCharImMigration(data,"","ImMigration Rate(2005-2018)‰ ","",
                "‰", PlotOrientation.VERTICAL,true,true,false,590,350);

        // code Hoang anh
        BarChart barChartHoangAnh = new BarChartImpl();
        barChart.capitalBarChar(data,"Acreage","Acreage of the capital Hanoi","Year",
                "km2", PlotOrientation.VERTICAL,true,true,false,560,367);

        BarChart barChart2 = new BarChartImpl();
        barChart2.economicBarChar(data,"Acreage","Acreage of Provinces With Special  Zones","Year",
                "km2", PlotOrientation.VERTICAL,true,true,false,560,367);

        BarChart barChart3 = new BarChartImpl();
        barChart3.distributionBarChar(data,"Distribution","A Histogram Of Population Density","Person/km2",
                "Number", PlotOrientation.VERTICAL,true,true,false,560,367);
    }
}
