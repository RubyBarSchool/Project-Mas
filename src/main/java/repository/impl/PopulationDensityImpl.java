package repository.impl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import repository.PopulationDensity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PopulationDensityImpl implements PopulationDensity {
    @Override
    public JSONObject getAllPopulationAndMigration() {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("PopulationDensity.json"));
            return (JSONObject) jsonObject.get("dataset");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
