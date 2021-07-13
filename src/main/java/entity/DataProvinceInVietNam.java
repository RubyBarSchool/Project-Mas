package entity;

public class DataProvinceInVietNam {
    private String name;
    private int year;
    private double averagePopulation = 0.0;
    private double averagePopulationCity = 0.0;
    private double averagePopulationCountryside  = 0.0;
    private Boolean checkCountry = false;
    private double acreage = 0.0;
    private double populationDensity = 0.0;
    private double immigration = 0.0;
    private double migration = 0.0;

    public DataProvinceInVietNam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public double getAveragePopulation() {
        return averagePopulation;
    }

    public void setAveragePopulation(double averagePopulation) {
        this.averagePopulation = averagePopulation;
    }

    public double getAveragePopulationCity() {
        return averagePopulationCity;
    }

    public void setAveragePopulationCity(double averagePopulationCity) {
        this.averagePopulationCity = averagePopulationCity;
    }

    public double getAveragePopulationCountryside() {
        return averagePopulationCountryside;
    }

    public void setAveragePopulationCountryside(double averagePopulationCountryside) {
        this.averagePopulationCountryside = averagePopulationCountryside;
    }

    public Boolean getCheckCountry() {
        return checkCountry;
    }

    public void setCheckCountry(Boolean checkCountry) {
        this.checkCountry = checkCountry;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public double getPopulationDensity() {
        return populationDensity;
    }

    public void setPopulationDensity(double populationDensity) {
        this.populationDensity = populationDensity;
    }

    public double getImmigration() {
        return immigration;
    }

    public void setImmigration(double immigration) {
        this.immigration = immigration;
    }

    public double getMigration() {
        return migration;
    }

    public void setMigration(double migration) {
        this.migration = migration;
    }
}
