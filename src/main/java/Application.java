import entity.DataProvinceInVietNam;
import service.GetAllDataOfJSON;
import service.impl.GetAllDataOfJSONImpl;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        GetAllDataOfJSON iam = new GetAllDataOfJSONImpl();
        List<DataProvinceInVietNam> data = iam.getAll();
//        BarChart barChart = new BarChartImpl();
//        barChart.demoBarChar(data,"Car Usage Statistics","Which car do you like?","Năm",
//                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,560,367);
//
//        LineChart lineChart = new LineChartImpl();
//        lineChart.demoLineChar(data,"Dan so trung binh","Dan so trung binh","Năm",
//                "Dân số(nghìn người)", PlotOrientation.VERTICAL,true,true,false,560,367);
//
//        DoubleBarChar doubleBarChar = new DoubleBarCharImpl();
//        doubleBarChar.demoDoublrBarChar(data,"Dan so trung binh","Stacked Bar Chart Demo 4","Category",
//                "value", PlotOrientation.VERTICAL,true,true,false,590,350);

        System.out.println("Size data "+data.size());
        for(DataProvinceInVietNam datax : data){
            System.out.println("Data: "+datax.toString());
        }
    }
}
