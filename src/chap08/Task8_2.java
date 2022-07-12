package chap08;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

/**
 * @author Вагин Михаил
 * date 12.07.2022
 */
public class Task8_2 {
    public static void main(String[] args) {
        Map<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);

        movies.entrySet().removeIf(entry -> entry.getValue() < 10);

        System.out.println(movies);
    }
}
