package vo;

public class Distribution  {
    private int count;
    private Double value;

    public Distribution() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "count=" + count +
                ", value=" + value +
                '}';
    }

}