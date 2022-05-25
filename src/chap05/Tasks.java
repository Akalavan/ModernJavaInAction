package chap05;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .reduce("", (a, b) -> a + " " + b);

        System.out.println(strAllTraders);

        boolean oneBerezniki = Transaction.TRANSACTIONS.stream()
                .map(t -> t.getTrader().getCity())
                .anyMatch("Berezniki"::equals);

        System.out.println(oneBerezniki);

        double sum = Transaction.TRANSACTIONS.stream()
                .filter(t -> "SPB".equals(t.getTrader().getCity()))
                .map(Transaction::getPrice)
                .reduce(0.0, Double::sum);

        System.out.println(sum);

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
    }
}
