package dto;

import java.util.ArrayList;
import java.util.List;

public class DTOAveragePopulation {
    List<String> allNameProvince;
    List<String> allTypeAveragePopulation;
    List<Integer> years;
    List<Double> value;

    public DTOAveragePopulation() {
        this.allNameProvince = new ArrayList<>();
        this.allTypeAveragePopulation = new ArrayList<>();
        this.years = new ArrayList<>();
        this.value = new ArrayList<>();
    }

    public List<String> getAllNameProvince() {
        return allNameProvince;
    }

    public void setAllNameProvince(List<String> allNameProvince) {
        this.allNameProvince = allNameProvince;
    }

    public List<String> getAllTypeAveragePopulation() {
        return allTypeAveragePopulation;
    }

    public void setAllTypeAveragePopulation(List<String> allTypeAveragePopulation) {
        this.allTypeAveragePopulation = allTypeAveragePopulation;
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
