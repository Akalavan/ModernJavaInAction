package chap04;

import java.util.*;
import java.util.stream.Collectors;

public class StreamBasic {

    public static void main(String[] args) {
        //Java 7
        getDishJava7(Dish.menu).forEach(System.out::println);

        System.out.println("============");

        //Java8
        getDishJava8(Dish.menu).forEach(System.out::println);

    }

    public static List<String> getDishJava7(List<Dish> dishes) {
        List<Dish> lowCaloric = new ArrayList<>();

        for (Dish d :
                dishes) {
            if (d.getCalories() < 400) {
                lowCaloric.add(d);
            }
        }

        List<String> nameDish = new ArrayList<>();

        Collections.sort(lowCaloric, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        for (Dish d :
                lowCaloric) {
            nameDish.add(d.getName());
        }

        return nameDish;
    }

    public static List<String> getDishJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
