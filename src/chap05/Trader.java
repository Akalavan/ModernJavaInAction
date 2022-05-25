package chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Trader {

    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trader trader = (Trader) o;
        return name.equals(trader.name) &&
                city.equals(trader.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static final List<Trader> TRADERS = Arrays.asList(
            new Trader("Vany", "Perm"),
            new Trader("Misha", "Berezniki"),
            new Trader("Ily", "Vladivostok"),
            new Trader("Sasha", "Moscow"),
            new Trader("Sofia", "Moscow"),
            new Trader("Dima", "SPB"),
            new Trader("Masha", "SPB")
    );
}
