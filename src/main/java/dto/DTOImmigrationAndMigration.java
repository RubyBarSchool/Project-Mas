package dto;

import java.util.ArrayList;
import java.util.List;

public class DTOImmigrationAndMigration {
    List<String> allNameProvince;
    List<String> allTypeImmigrationAndMigration;
    List<Integer> years;
    List<Double> value;

    public DTOImmigrationAndMigration() {
        this.allNameProvince = new ArrayList<>();
        this.allTypeImmigrationAndMigration = new ArrayList<>();
        this.years = new ArrayList<>();
        this.value = new ArrayList<>();
    }

    public List<String> getAllNameProvince() {
        return allNameProvince;
    }

    public void setAllNameProvince(List<String> allNameProvince) {
        this.allNameProvince = allNameProvince;
    }

    public List<String> getAllTypeImmigrationAndMigration() {
        return allTypeImmigrationAndMigration;
    }

    public void setAllTypeImmigrationAndMigration(List<String> allTypeImmigrationAndMigration) {
        this.allTypeImmigrationAndMigration = allTypeImmigrationAndMigration;
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
