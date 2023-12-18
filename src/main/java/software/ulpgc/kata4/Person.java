package software.ulpgc.kata4;

import java.util.Objects;

public class Person {
    private final int id;
    private final double height;
    private final double weight;

    public Person(int id, double height, double weight) {
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Double.compare(height, person.height) == 0 && Double.compare(weight, person.weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, weight);
    }

    public int getId() {
        return id;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
}
