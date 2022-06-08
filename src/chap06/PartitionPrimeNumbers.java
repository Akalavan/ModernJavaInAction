package chap06;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PartitionPrimeNumbers {

    public static void main(String[] args) {
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));
    }

    public static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate)
                .limit((long) Math.floor(Math.sqrt(candidate)) - 1)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(PartitionPrimeNumbers::isPrime));
    }
}
