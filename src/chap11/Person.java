package chap11;

import java.util.Optional;

/**
 * @author Вагин Михаил
 * date 19.07.2022
 */
public class Person {

    private Optional<Car> car;
    private int age;

    public Optional<Car> getCar() {
        return car;
    }

    public int getAge() {
        return age;
    }
}
