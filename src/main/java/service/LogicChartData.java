package service;

import entity.DataProvinceInVietNam;

import java.util.List;

public interface LogicChartData {
    void descriptiveStatistics(List<DataProvinceInVietNam> data);
    void dataWithPopulation(List<DataProvinceInVietNam> data);
    void dataWithPopulationDensity(List<DataProvinceInVietNam> data);
    void dataWithImmigrationAndMigrationOfHaNOi(List<DataProvinceInVietNam> data);
    void dataWithImmigrationAndMigrationOfHoChiMInh(List<DataProvinceInVietNam> data);
    void dataWithImmigrationAndMigrationOfHoChiMInhAndHaNoi(List<DataProvinceInVietNam> data);
    void dataWithPopulationOfHoChiMInhAndHaNoi(List<DataProvinceInVietNam> data);


}
