import java.util.Objects;

import static java.lang.Integer.*;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private Integer weight;

    public Toy(int id, String name, Integer weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Toy() {
        this.name = null;

    }


    @Override
    public int compareTo(Toy o) {
        return compare(parseInt(getWeight().toString()), parseInt(o.getWeight().toString()));
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        if (!Objects.equals(this.name, "")) {
            this.name = name;
        } else {
            this.name += " " + name;
        }
    }



}