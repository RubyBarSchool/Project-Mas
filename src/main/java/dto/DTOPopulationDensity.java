package dto;

import java.util.ArrayList;
import java.util.List;

public class DTOPopulationDensity {
    List<String> allNameProvince;
    List<String> allTypePopulationDensity;
    List<Integer> years;
    List<Double> value;
    public DTOPopulationDensity() {
        this.allNameProvince = new ArrayList<>();
        this.allTypePopulationDensity = new ArrayList<>();
        this.years = new ArrayList<>();
        this.value = new ArrayList<>();
    }

    public List<String> getAllNameProvince() {
        return allNameProvince;
    }

    public void setAllNameProvince(List<String> allNameProvince) {
        this.allNameProvince = allNameProvince;
    }

    public List<String> getAllTypePopulationDensity() {
        return allTypePopulationDensity;
    }

    public void setAllTypePopulationDensity(List<String> allTypePopulationDensity) {
        this.allTypePopulationDensity = allTypePopulationDensity;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<Double> getValue() {
        return value;
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }
}
