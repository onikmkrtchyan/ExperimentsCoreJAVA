package threads;

import java.util.concurrent.ForkJoinPool;
import java.util.List;
import java.util.Arrays;

public class CustomForkJoinPoolExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ForkJoinPool customPool = new ForkJoinPool(4);  // Custom ForkJoinPool with 4 threads
        try {
            int sum = customPool.submit(() -> 
                numbers.parallelStream()
                       .mapToInt(Integer::intValue)
                       .sum()
            ).get();

            System.out.println("Sum: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customPool.shutdown();
        }
    }
}


// Tood sream api