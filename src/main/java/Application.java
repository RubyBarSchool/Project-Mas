import service.GetAllDataOfJSON;
import service.impl.GetAllDataOfJSONImpl;

public class Application {
    public static void main(String[] args) {
        GetAllDataOfJSON iam = new GetAllDataOfJSONImpl();
        iam.getAll();
        System.out.println("Hello");
    }
}
