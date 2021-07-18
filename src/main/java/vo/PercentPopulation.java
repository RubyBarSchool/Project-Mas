package vo;

public class PercentPopulation implements Comparable<PercentPopulation>{
    private int percentPolulation;
    private int repeate;

    public PercentPopulation() {
    }

    public PercentPopulation(int percentPolulation, int repeate) {
        this.percentPolulation = percentPolulation;
        this.repeate = repeate;
    }

    public int getPercentPolulation() {
        return percentPolulation;
    }

    public void setPercentPolulation(int percentPolulation) {
        this.percentPolulation = percentPolulation;
    }

    public int getRepeate() {
        return repeate;
    }

    public void setRepeate(int repeate) {
        this.repeate = repeate;
    }

    @Override
    public int compareTo(PercentPopulation o) {
        if(o.getPercentPolulation()>this.getPercentPolulation()){
            return -1;
        }else if(o.getPercentPolulation()<this.getPercentPolulation()){
            return 1;
        }else {
            return 0;
        }
    }
}