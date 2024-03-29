package chap04;

import java.util.List;
import java.util.stream.Collectors;

public class HighCaloriesNames {

    public static void main(String[] args) {
        List<String> nameDish = Dish.menu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        

        System.out.println(nameDish);

        List<Dish> dishMeat = Dish.menu
                .stream()
                .filter(dish -> Dish.Type.MEAT.equals(dish.getType()))
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(dishMeat);


    }
}
