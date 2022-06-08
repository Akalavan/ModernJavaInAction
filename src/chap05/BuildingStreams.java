package chap05;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern", "java", "in", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        String homeValue = System.getProperty("home");
        Stream<String> homeValueStream = homeValue == null ? Stream.empty() : Stream.of(homeValue);

        Stream<String> homeValueStream1 = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        
    }
}
