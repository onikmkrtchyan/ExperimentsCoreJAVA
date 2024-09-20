package streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> listOfListsStr = List.of(
                List.of("a", "b", "c"),
                List.of("d", "e", "f"),
                List.of("g", "h", "i")
        );

        // Flatten the list of lists into a single list
        List<String> flatList = listOfListsStr.stream()
                .flatMap(List::stream)
                .toList();

        System.out.println(flatList); // Output: [a, b, c, d, e, f, g, h, i]


        List<List<Integer>> listOfLists2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists2.stream()
                .flatMap(List::stream) // Converts each List<Integer> into Stream<Integer>
                .toList();

        flattenedList.forEach(System.out::println);


        List<String> sentences = Arrays.asList(
                "The quick brown fox",
                "jumps over the lazy dog",
                "Java Streams are powerful"
        );

        List<String> words = sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" "))) // Split sentences into words
                .toList();

        words.forEach(System.out::println);

        List<Optional<String>> optionalList = Arrays.asList(
                Optional.of("Hello"),
                Optional.empty(),
                Optional.of("World")
        );

        List<String> nonEmptyValues = optionalList.stream()
                .flatMap(Optional::stream) // Convert Optional<String> to Stream<String>
                .toList();

        nonEmptyValues.forEach(System.out::println);

        List<String> phrases = Arrays.asList(
                "apple, orange, banana",
                "grape, watermelon",
                "pineapple mango"
        );

        List<String> allWords = phrases.stream()
                .flatMap(phrase -> Arrays.stream(phrase.split("[, ]+"))) // Split by commas and spaces
                .toList();

        allWords.forEach(System.out::println);

        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        final IntSummaryStatistics intSummaryStatistics = listOfLists.stream()
                .flatMap(List::stream) // Convert each List<Integer> to Stream<Integer>
                .map(integer -> integer * 2) // Multiply each integer by 2
                .mapToInt(Integer::intValue) // Convert Stream<Integer> to IntStream
                .summaryStatistics();// Convert Stream<Integer> to IntStream

        final long sum = intSummaryStatistics.getSum();// 45

        System.out.println(sum); // Output: 45


    }

}