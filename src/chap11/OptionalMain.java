package chap11;

import java.util.Optional;

/**
 * @author Вагин Михаил
 * date 19.07.2022
 */
public class OptionalMain {

    public String getCarInsuranceName(PersonV1 person) {
        if (person != null) {
            CarV1 car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }

        return "Unknown";
    }

    public String getCarInsuranceNameNullSafeV2(PersonV1 person) {
        if (person == null) {
            return "Unknown";
        }
        CarV1 car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }

    // Doesn't compile:
    // - In (1), we try to invoke map(Person::getCar) on an Optional<Person>.
    //   Switching to flatMap() solves this issue.
    // - Then in (2), we try to invoke map(Car::getInsurance) on an Optional<Car>.
    //   Switching to flatMap() solves this issue.
    // There is no need to further "flatMap" since Insurance::getName returns
    // a plain String.
  /*public String getCarInsuranceName(Person person) {
    Optional<Person> optPerson = Optional.of(person);
    Optional<String> name = optPerson.map(Person::getCar) // (1)
        .map(Car::getInsurance) // (2)
        .map(Insurance::getName);
    return name.orElse("Unknown");
  }*/
    public String getCarInsuranceName(Optional<Person> person) {
        return person
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
