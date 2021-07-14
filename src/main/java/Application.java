import entity.DataProvinceInVietNam;
import org.jfree.chart.plot.PlotOrientation;
import service.BarChart;
import service.GetAllDataOfJSON;
import service.LineChart;
import service.impl.BarChartImpl;
import service.impl.GetAllDataOfJSONImpl;
import service.impl.LineChartImpl;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        GetAllDataOfJSON iam = new GetAllDataOfJSONImpl();
        List<DataProvinceInVietNam> data = iam.getAll();
        BarChart barChart = new BarChartImpl();
        barChart.demoBarChar(data,"Car Usage Statistics","Which car do you like?","Năm",
                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,560,367);

        LineChart lineChart = new LineChartImpl();
        lineChart.demoLineChar(data,"Dan so trung binh","Dan so trung binh","Năm",
                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,560,367);


        System.out.println("Size data "+data.size());
    }
}
