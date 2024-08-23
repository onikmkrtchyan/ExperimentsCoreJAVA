package threads;

import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class RaceCondition {

    public static void main(String[] args) {
        new RaceCondition().function();

        Date date = new Date();

        final IntSummaryStatistics intSummaryStatistics = Stream.of(1, 2, 34, 5, 6, 7, 8, 9, 2).mapToInt(Integer::intValue).summaryStatistics();
        final int max = intSummaryStatistics.getMax();


    }


    volatile int value = 0;

    void function() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Submit multiple tasks to the thread pool
        for (int i = 0; i < 300; i++) {
            executorService.submit(this::increment);
        }

        // Shut down the executor service
        executorService.shutdown();

        System.out.println("Final value: " + value);
        System.out.println("Final value: " + value);
        System.out.println("Final value: " + value);
    }

    public synchronized void increment() {
        value++;
    }
}
