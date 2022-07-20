package chap11;

import java.util.Optional;

/**
 * @author Вагин Михаил
 * date 19.07.2022
 */
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
