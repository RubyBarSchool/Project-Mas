package vo;

public class DemoClassHA {
    private int count;
    private Double valueDensity;

    public DemoClassHA() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getValueDensity() {
        return valueDensity;
    }

    public void setValueDensity(Double valueDensity) {
        this.valueDensity = valueDensity;
    }

    @Override
    public String toString() {
        return "DemoClass{" +
                "count=" + count +
                ", valueDensity=" + valueDensity +
                '}';
    }
}
