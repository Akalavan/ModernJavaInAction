package chap03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecuteAround {

    public static void main(String[] args) throws IOException {

        String oneLine = processFile(BufferedReader::readLine);

        String twoLine = processFile(br -> br.readLine() + br.readLine());

        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                String::length
        );

    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader reader) throws IOException;
    }


    // before java8
    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/chap05/data.txt"))) {
            return br.readLine();
        }
    }

    // after java8
    public static String processFile(BufferedReaderProcessor brp) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/chap05/data.txt"))) {
            return brp.process(br);
        }
    }

    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t :
                list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
