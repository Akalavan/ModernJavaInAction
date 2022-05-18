package chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples {

    public static class Apple {

        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d", color, weight);
        }
    }

    enum Color {
        RED,
        GREEN,
        BROWN
    }

    // before java 8
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :
                inventory) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :
                inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    // after java 8
    public static boolean isGreenApple(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple :
                inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heaveApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heaveApples);

        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> Color.GREEN.equals(a.getColor()));
        System.out.println(greenApples2);

        List<Apple> heaveApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heaveApples2);

        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() > 80 || Color.BROWN.equals(a.getColor()));
        System.out.println(weirdApples);

        //последовательная обработка
        List<Apple> heaveApples3 = inventory.stream().filter(a -> a.getWeight() > 150).collect(Collectors.toList());
        //параллельная обработка
        List<Apple> heaveApples4 = inventory.parallelStream().filter(a -> a.getWeight() > 150).collect(Collectors.toList());

        List<Integer> listInt = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Apple> redApples = filter(inventory, apple -> Color.RED.equals(apple.getColor()));
        List<Integer> evenNumbers = filter(listInt, i -> i % 2 == 0);

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t :
                list) {
            if (p.test(t)) {
                result.add(t);
            }
        }

        return result;
    }
}
