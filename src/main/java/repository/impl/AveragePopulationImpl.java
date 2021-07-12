package repository.impl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import repository.AveragePopulation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AveragePopulationImpl implements AveragePopulation {
    @Override
    public JSONObject getAllAveragePopulation() {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("AveragePopulation.json"));
            return ((JSONObject) jsonObject.get("dataset"));
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
