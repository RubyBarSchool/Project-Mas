package vo;

public class DistributionHA implements  Comparable<DistributionHA> {
    private String name;
    private Double ave;

    public DistributionHA() {
    }

    public DistributionHA(String name, Double ave) {
        this.name = name;
        this.ave = ave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAve() {
        return ave;
    }

    public void setAve(Double ave) {
        this.ave = ave;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "name='" + name + '\'' +
                ", ave=" + ave +
                '}';
    }

    @Override
    public int compareTo(DistributionHA o) {
        if (o.getAve() > this.getAve()) {
            return -1;
        } else if (o.getAve() < this.getAve()) {
            return 1;
        } else {
            return 0;
        }
    }
}
