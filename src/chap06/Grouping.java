package chap06;

import static chap06.Dish.menu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {

    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(Collectors.groupingBy(Dish::getType));
    }
}
