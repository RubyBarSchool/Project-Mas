package service.impl;

import dto.DTOAveragePopulation;
import dto.DTOImmigrationAndMigration;
import dto.DTOPopulationDensity;
import entity.DataProvinceInVietNam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import repository.AveragePopulation;
import repository.ImmigrationAndMigration;
import repository.PopulationDensity;
import repository.impl.AveragePopulationImpl;
import repository.impl.ImmigrationAndMigrationImpl;
import repository.impl.PopulationDensityImpl;
import service.GetAllDataOfJSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetAllDataOfJSONImpl implements GetAllDataOfJSON {
    private ImmigrationAndMigration immigrationAndMigration;
    private AveragePopulation averagePopulation;
    private PopulationDensity populationDensity;

    public GetAllDataOfJSONImpl() {
        this.immigrationAndMigration = new ImmigrationAndMigrationImpl();
        this.averagePopulation = new AveragePopulationImpl();
        this.populationDensity = new PopulationDensityImpl();
    }


    @Override
    public List<DataProvinceInVietNam> getAll() {
        try {

            // mapstruct data json and DTOAveragePopulation
            JSONObject averJSON = this.averagePopulation.getAllAveragePopulation();
            DTOAveragePopulation averagePopulation = new DTOAveragePopulation();
            JSONArray jsonArray = (JSONArray) averJSON.get("value");
            List<Double> listDataValueAver = new ArrayList<>();
            for (Object obj : jsonArray) {
                String convert = (obj != null) ? obj + "" : "0.0";
                if (!convert.contains(".")) {
                    convert += ".0";
                }
                listDataValueAver.add(Double.valueOf(convert));
            }
            averagePopulation.setValue(listDataValueAver);
            JSONObject dataNameProvince = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) averJSON.get("dimension")).get("Tỉnh, thành phố")).get("category"))).get("label");
            List<String> listNameProvince = new ArrayList<>();
            List<Integer> dataKeyNameProvince = new ArrayList<>();
            for (Object keys : dataNameProvince.keySet()) {
                dataKeyNameProvince.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyNameProvince);
            for (Integer keys : dataKeyNameProvince) {
                listNameProvince.add((String) dataNameProvince.get(keys + ""));
            }
            averagePopulation.setAllNameProvince(listNameProvince);
            JSONObject dataTypeAveragePopulation = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) averJSON.get("dimension")).get("Dân số trung bình")).get("category"))).get("label");
            List<String> listTypeAveragePopulation = new ArrayList<>();
            List<Integer> dataKeyTypeAveragePopulation = new ArrayList<>();
            for (Object keys : dataTypeAveragePopulation.keySet()) {
                dataKeyTypeAveragePopulation.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyTypeAveragePopulation);
            for (Integer keys : dataKeyTypeAveragePopulation) {
                listTypeAveragePopulation.add((String) dataTypeAveragePopulation.get(keys + ""));
            }
            averagePopulation.setAllTypeAveragePopulation(listTypeAveragePopulation);
            JSONObject dataYears = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) averJSON.get("dimension")).get("Năm")).get("category"))).get("label");
            List<Integer> listYears = new ArrayList<>();
            List<Integer> dataKeyYears = new ArrayList<>();
            for (Object keys : dataYears.keySet()) {
                dataKeyYears.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyYears);
            for (Integer keys : dataKeyYears) {
                listYears.add(Integer.valueOf((String) dataYears.get(keys + "")));
            }
            averagePopulation.setYears(listYears);
            // mapstruct data json and DTOImmigrationAndMigration
            JSONObject immiJSON = this.immigrationAndMigration.getAllImmigrationAndMigration();
            DTOImmigrationAndMigration immigrationAndMigration = new DTOImmigrationAndMigration();
            JSONArray jsonArray1 = (JSONArray) immiJSON.get("value");
            List<Double> listDataValueAver1 = new ArrayList<>();
            for (Object obj : jsonArray1) {
                String convert = (obj != null) ? obj + "" : "0.0";
                if (!convert.contains(".")) {
                    convert += ".0";
                }
                listDataValueAver1.add(Double.valueOf(convert));
            }
            immigrationAndMigration.setValue(listDataValueAver1);
            JSONObject dataNameProvinceImi = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) immiJSON.get("dimension")).get("Tỉnh/Thành phố")).get("category"))).get("label");
            List<String> listNameProvinceImi = new ArrayList<>();
            List<Integer> dataKeyNameProvinceImi = new ArrayList<>();
            for (Object keys : dataNameProvinceImi.keySet()) {
                dataKeyNameProvinceImi.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyNameProvinceImi);
            for (Integer keys : dataKeyNameProvinceImi) {
                listNameProvinceImi.add((String) dataNameProvinceImi.get(keys + ""));
            }
            immigrationAndMigration.setAllNameProvince(listNameProvinceImi);
            JSONObject dataAllTypeImmigrationAndMigration = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) immiJSON.get("dimension")).get("Tỷ suất")).get("category"))).get("label");
            List<String> listAllTypeImmigrationAndMigration = new ArrayList<>();
            List<Integer> dataKeyAllTypeImmigrationAndMigration = new ArrayList<>();
            for (Object keys : dataAllTypeImmigrationAndMigration.keySet()) {
                dataKeyAllTypeImmigrationAndMigration.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyAllTypeImmigrationAndMigration);
            for (Integer keys : dataKeyAllTypeImmigrationAndMigration) {
                listAllTypeImmigrationAndMigration.add((String) dataAllTypeImmigrationAndMigration.get(keys + ""));
            }
            immigrationAndMigration.setAllTypeImmigrationAndMigration(listAllTypeImmigrationAndMigration);
            JSONObject dataYearsImi = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) immiJSON.get("dimension")).get("Năm")).get("category"))).get("label");
            List<Integer> listYearsImi = new ArrayList<>();
            List<Integer> dataKeyYearsImi = new ArrayList<>();
            for (Object keys : dataYearsImi.keySet()) {
                dataKeyYearsImi.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyYearsImi);
            for (Integer keys : dataKeyYearsImi) {
                listYearsImi.add(Integer.valueOf((String) dataYearsImi.get(keys + "")));
            }
            immigrationAndMigration.setYears(listYearsImi);


            // mapstruct data json and DTOPopulationDensity
            JSONObject dpJSON = this.populationDensity.getAllPopulationAndMigration();
            DTOPopulationDensity populationDensity = new DTOPopulationDensity();
            JSONArray jsonArray2 = (JSONArray) dpJSON.get("value");
            List<Double> listDataValueAver2 = new ArrayList<>();
            for (Object obj : jsonArray2) {
                String convert = (obj != null) ? obj + "" : "0.0";
                if (!convert.contains(".")) {
                    convert += ".0";
                }
                listDataValueAver2.add(Double.valueOf(convert));
            }
            populationDensity.setValue(listDataValueAver2);
            JSONObject dataAllNameProvince = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) dpJSON.get("dimension")).get("Địa phương")).get("category"))).get("label");
            List<String> listAllNameProvince = new ArrayList<>();

            List<Integer> dataKeyAllNameProvince = new ArrayList<>();
            for (Object keys : dataNameProvinceImi.keySet()) {
                dataKeyAllNameProvince.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyAllNameProvince);
            for (Integer keys : dataKeyAllNameProvince) {
                listAllNameProvince.add((String) dataAllNameProvince.get(keys + ""));
            }
            populationDensity.setAllNameProvince(listAllNameProvince);

            JSONObject dataAllTypePopulationDensity = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) dpJSON.get("dimension")).get("Chỉ tiêu")).get("category"))).get("label");
            List<String> listAllTypePopulationDensity = new ArrayList<>();

            List<Integer> dataKeyAllTypePopulationDensity = new ArrayList<>();
            for (Object keys : dataAllTypePopulationDensity.keySet()) {
                dataKeyAllTypePopulationDensity.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyAllTypePopulationDensity);
            for (Integer keys : dataKeyAllTypePopulationDensity) {
                listAllTypePopulationDensity.add((String) dataAllTypePopulationDensity.get(keys + ""));
            }
            populationDensity.setAllTypePopulationDensity(listAllTypePopulationDensity);

            JSONObject dataYearspd = (JSONObject) ((JSONObject) (((JSONObject) ((JSONObject) dpJSON.get("dimension")).get("Năm")).get("category"))).get("label");
            List<Integer> listYearspd = new ArrayList<>();
            List<Integer> dataKeyYearspd = new ArrayList<>();
            for (Object keys : dataYearspd.keySet()) {
                dataKeyYearspd.add(Integer.valueOf((String) keys));
            }
            Collections.sort(dataKeyYearspd);
            for (Integer keys : dataKeyYearspd) {
                listYearspd.add(Integer.valueOf((String) dataYearspd.get(keys + "")));
            }
            populationDensity.setYears(listYearspd);
            List<DataProvinceInVietNam> dataProvinceInVietNams = new ArrayList<>();

            //mapper province and count
            int countProvince = 0;
            for (String province : averagePopulation.getAllNameProvince()) {
                int countYear = 0;
                for (Integer year : averagePopulation.getYears()) {
                    DataProvinceInVietNam dataProvinceInVietNam = new DataProvinceInVietNam();
                    dataProvinceInVietNam.setYear(year);
                    dataProvinceInVietNam.setName(province);
                    dataProvinceInVietNam.setCheckCountry(province.equals("CẢ NƯỚC") ? true : false);
                    int count = 0;
                    for (String typeAveragePopulation : averagePopulation.getAllTypeAveragePopulation()) {
                        if (count == 0) {
                            dataProvinceInVietNam.setAveragePopulation(averagePopulation.getValue().get((countProvince * averagePopulation.getYears().size() * averagePopulation.getAllTypeAveragePopulation().size()) + count * averagePopulation.getYears().size() + countYear));
                        } else if (count == 1) {
                            dataProvinceInVietNam.setAveragePopulationCity(averagePopulation.getValue().get((countProvince * averagePopulation.getYears().size() * averagePopulation.getAllTypeAveragePopulation().size()) + count * averagePopulation.getYears().size() + countYear));
                        } else {
                            dataProvinceInVietNam.setAveragePopulationCountryside(averagePopulation.getValue().get((countProvince * averagePopulation.getYears().size() * averagePopulation.getAllTypeAveragePopulation().size()) + count * averagePopulation.getYears().size() + countYear));
                        }
                        count++;
                    }
                    dataProvinceInVietNams.add(dataProvinceInVietNam);
                    countYear++;
                }
                countProvince++;
            }


            //mapper immigration and migration
            countProvince = 0;
            for (String province : immigrationAndMigration.getAllNameProvince()) {
                int count = 0;
                for (String typeAveragePopulation : immigrationAndMigration.getAllTypeImmigrationAndMigration()) {
                    int countYear = 0;
                    for (Integer year : immigrationAndMigration.getYears()) {
                        for (DataProvinceInVietNam dataProvinceInVietNam : dataProvinceInVietNams) {
                            if (dataProvinceInVietNam.getName().equals(province) && dataProvinceInVietNam.getYear() == year) {
                                if (count == 0) {
                                    dataProvinceInVietNam.setImmigration(immigrationAndMigration.getValue().get((countProvince * immigrationAndMigration.getYears().size() * immigrationAndMigration.getAllTypeImmigrationAndMigration().size()) + count * immigrationAndMigration.getYears().size() + countYear));
                                } else {
                                    dataProvinceInVietNam.setMigration(immigrationAndMigration.getValue().get((countProvince * immigrationAndMigration.getYears().size() * immigrationAndMigration.getAllTypeImmigrationAndMigration().size()) + count * immigrationAndMigration.getYears().size() + countYear));
                                }
                                break;
                            }
                        }
                        countYear++;
                    }
                    count++;
                }
                countProvince++;
            }
            // mapper density and acreage
            countProvince = 0;
            for (String province : populationDensity.getAllNameProvince()) {
                int countYear = 0;
                for (Integer year : populationDensity.getYears()) {
                    for (DataProvinceInVietNam dataProvinceInVietNam : dataProvinceInVietNams) {
                        if (dataProvinceInVietNam.getName().equals(province) && dataProvinceInVietNam.getYear() == year) {
                            dataProvinceInVietNam.setAcreage(populationDensity.getValue().get(countProvince * populationDensity.getYears().size() * 2 + 2 * countYear));
                            dataProvinceInVietNam.setPopulationDensity(populationDensity.getValue().get(countProvince * populationDensity.getYears().size() * 2 + 2 * countYear + 1));
                            break;
                        }
                    }
                    countYear++;
                }
                countProvince++;
            }
            return  dataProvinceInVietNams;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
