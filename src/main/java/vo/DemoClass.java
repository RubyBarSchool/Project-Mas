package vo;

public class DemoClass implements Comparable<DemoClass>{
    private String name;
    private Double tbPopulation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTbPopulation() {
        return tbPopulation;
    }

    public void setTbPopulation(Double tbPopulation) {
        this.tbPopulation = tbPopulation;
    }

    @Override
    public String toString() {
        return "DemoClass{" +
                "name='" + name + '\'' +
                ", tbPopulation=" + tbPopulation +
                '}';
    }

    @Override
    public int compareTo(DemoClass o) {
        if(o.getTbPopulation()>this.getTbPopulation()){
            return -1;
        }
        else  if(o.getTbPopulation()<this.getTbPopulation()){
            return 1;
        }
        else {
            return 0;
        }
    }
}

