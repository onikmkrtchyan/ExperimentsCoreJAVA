package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> sentences = List.of("hello world", "java streams", "flat map");

        // Split each sentence into words and flatten the result
        List<String> words = sentences.stream()
                .map(sentence -> sentence.split(" "))
                .flatMap(Stream::of)
                .collect(Collectors.toList());

        System.out.println(words); // Output: [hello, world, java, streams, flat, map]

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        Stream<Integer> streamOfNumbers = numbers.stream();


        numbers.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

        System.out.println();

        numbers.stream().map(i -> i * 2).forEach(System.out::println);

        System.out.println();

        numbers.stream().filter(i -> i % 2 == 0).map(i -> i * 2).forEach(System.out::println);

        System.out.println();

        numbers.stream().filter(i -> i % 2 == 0).map(i -> i * 2).map(i -> "Number = " + i).forEach(System.out::println);



    }
}