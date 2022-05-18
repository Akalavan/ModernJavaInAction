package chap03;

import java.util.Comparator;

public class Lambdas {

    Comparator<Apple> byWeightBeforeJava8 = new Comparator<Apple>() {
        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight() - a2.getWeight();
        }
    };

    Comparator<Apple> byWeightJava8 = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };

        Runnable r2 = () -> System.out.println("Hello world");


    }
}
