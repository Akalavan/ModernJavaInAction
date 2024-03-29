package chap06;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class Summarizing {

    public static void main(String[] args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostDishComparator());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    private static long howManyDishes() {
        return Dish.menu.stream().collect(Collectors.counting());
    }

    private static Dish findMostCaloricDish() {
        return Dish.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static Dish findMostDishComparator() {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorie = Dish.menu
                .stream()
                .collect(Collectors.maxBy(dishComparator));
        return mostCalorie.orElse(null);
    }

    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
    }

    private static double calculateAverageCalories() {
        return Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
    }

    private static String getShortMenuCommaSeparated() {
        return Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
    }
}
