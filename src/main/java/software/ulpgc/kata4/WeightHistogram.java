package software.ulpgc.kata4;

import java.util.List;

public class WeightHistogram implements Histogram {
    private final List<Person> people;

    public WeightHistogram(List<Person> people) {
        this.people = people;
    }

    @Override
    public int bins() {
        return 6;
    }

    @Override
    public double[] values() {
        double[] values = new double[people.size()];
        for (int i = 0; i < people.size() ; i++) {
            values[i] = people.get(i).getWeight();
        }
        return values;
    }
}
