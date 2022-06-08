package chap05;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tasks {

    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.TRANSACTIONS.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getPrice))
                .collect(Collectors.toList());

        System.out.println(transactions);

        List<String> traders = Transaction.TRANSACTIONS.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(traders);

        List<Trader> tradersFromMoscow = Transaction.TRANSACTIONS.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Moscow".equals(t.getCity()))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println(tradersFromMoscow);

        String strAllTraders = Transaction.TRANSACTIONS.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .collect(Collectors.joining());

        System.out.println(strAllTraders);

        boolean oneBerezniki = Transaction.TRANSACTIONS.stream()
                .map(t -> t.getTrader().getCity())
                .anyMatch("Berezniki"::equals);

        System.out.println(oneBerezniki);

        Transaction.TRANSACTIONS.stream()
                .filter(t -> "SPB".equals(t.getTrader().getCity()))
                .map(Transaction::getPrice)
                .forEach(System.out::println);


        double max = Transaction.TRANSACTIONS.stream()
                .map(Transaction::getPrice)
                .reduce(0.0, Double::max);

        System.out.println(max);

        Optional<Double> min = Transaction.TRANSACTIONS.stream()
                .map(Transaction::getPrice)
                .reduce(Double::min);

        min.ifPresent(System.out::println);

        Optional<Transaction> minTr = Transaction.TRANSACTIONS.stream()
                .min(Comparator.comparing(Transaction::getPrice));

        System.out.println(minTr.map(String::valueOf).orElse("Not fount"));

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100)
                        .boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                        );

        pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100)
                        .boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0)
                        );

        pythagoreanTriples2.limit(5).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
