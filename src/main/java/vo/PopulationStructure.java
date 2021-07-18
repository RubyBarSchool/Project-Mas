package vo;

public class PopulationStructure {
    private  double SumPopulation = 0;
    private  double sumPopulationCity = 0;
    private  double sumPopulationCountrySide = 0;
    private int countYear = 0;
    private double tbAveragePopulation = 0;
    private double tbAveragePopulationCity = 0;
    private double tbAveragePopulationCountryside = 0;

    public PopulationStructure() {
    }

    public PopulationStructure(double sumPopulation, double sumPopulationCity, double sumPopulationCountrySide, int countYear, double tbAveragePopulation, double tbAveragePopulationCity, double tbAveragePopulationCountryside) {
        SumPopulation = sumPopulation;
        this.sumPopulationCity = sumPopulationCity;
        this.sumPopulationCountrySide = sumPopulationCountrySide;
        this.countYear = countYear;
        this.tbAveragePopulation = tbAveragePopulation;
        this.tbAveragePopulationCity = tbAveragePopulationCity;
        this.tbAveragePopulationCountryside = tbAveragePopulationCountryside;
    }

    public double getSumPopulation() {
        return SumPopulation;
    }

    public void setSumPopulation(double sumPopulation) {
        SumPopulation = sumPopulation;
    }

    public double getSumPopulationCity() {
        return sumPopulationCity;
    }

    public void setSumPopulationCity(double sumPopulationCity) {
        this.sumPopulationCity = sumPopulationCity;
    }

    public double getSumPopulationCountrySide() {
        return sumPopulationCountrySide;
    }

    public void setSumPopulationCountrySide(double sumPopulationCountrySide) {
        this.sumPopulationCountrySide = sumPopulationCountrySide;
    }

    public int getCountYear() {
        return countYear;
    }

    public void setCountYear(int countYear) {
        this.countYear = countYear;
    }

    public double getTbAveragePopulation() {
        return tbAveragePopulation;
    }

    public void setTbAveragePopulation(double tbAveragePopulation) {
        this.tbAveragePopulation = tbAveragePopulation;
    }

    public double getTbAveragePopulationCity() {
        return tbAveragePopulationCity;
    }

    public void setTbAveragePopulationCity(double tbAveragePopulationCity) {
        this.tbAveragePopulationCity = tbAveragePopulationCity;
    }

    public double getTbAveragePopulationCountryside() {
        return tbAveragePopulationCountryside;
    }

    public void setTbAveragePopulationCountryside(double tbAveragePopulationCountryside) {
        this.tbAveragePopulationCountryside = tbAveragePopulationCountryside;
    }


}
