import entity.DataProvinceInVietNam;
import service.GetAllDataOfJSON;
import service.impl.GetAllDataOfJSONImpl;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GetAllDataOfJSON iam = new GetAllDataOfJSONImpl();
        List<DataProvinceInVietNam> data = iam.getAll();
        System.out.println("Size data "+data.size());
    }
}
