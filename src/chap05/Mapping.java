package chap05;

import chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "world");

//        List<String> uniqueCharacters = words
//                .stream()
//                .map(word -> word.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());

        List<String> uniqueCharacters = words
                .stream()
                .flatMap(str -> Arrays.stream(str.split("")))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueCharacters);

        List<Integer> listInt = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squaresInt = listInt
                .stream()
                .map(i -> i * i)
                .collect(Collectors.toList());

        System.out.println(squaresInt);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers1
                .stream()
                .flatMap(i -> numbers2
                        .stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        pairs.forEach(ints -> System.out.println(Arrays.toString(ints)));

        List<int[]> pairs1 = numbers1
                .stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (j + i) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        pairs1.forEach(ints -> System.out.println(Arrays.toString(ints)));

        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));


        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> findFirst = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();

        System.out.println(findFirst.isPresent() ? findFirst.get() : "");
    }
}
