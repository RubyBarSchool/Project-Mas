package vo;

public class DescriptiveStatistics {
    double count;
    double mean;
    double std;
    double min;
    double firstQuartile;
    double secondQuartile;
    double thirdQuartile;
    double max;

    public DescriptiveStatistics() {
    }

    public DescriptiveStatistics(double count, double mean, double std, double min, double firstQuartile, double secondQuartile, double thirdQuartile, double max) {
        this.count = count;
        this.mean = mean;
        this.std = std;
        this.min = min;
        this.firstQuartile = firstQuartile;
        this.secondQuartile = secondQuartile;
        this.thirdQuartile = thirdQuartile;
        this.max = max;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStd() {
        return std;
    }

    public void setStd(double std) {
        this.std = std;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getFirstQuartile() {
        return firstQuartile;
    }

    public void setFirstQuartile(double firstQuartile) {
        this.firstQuartile = firstQuartile;
    }

    public double getSecondQuartile() {
        return secondQuartile;
    }

    public void setSecondQuartile(double secondQuartile) {
        this.secondQuartile = secondQuartile;
    }

    public double getThirdQuartile() {
        return thirdQuartile;
    }

    public void setThirdQuartile(double thirdQuartile) {
        this.thirdQuartile = thirdQuartile;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
