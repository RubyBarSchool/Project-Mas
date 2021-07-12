package repository.impl;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import repository.ImmigrationAndMigration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImmigrationAndMigrationImpl implements ImmigrationAndMigration {
    @Override
    public JSONObject getAllImmigrationAndMigration() {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("ImmigrationAndMigration.json"));
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
