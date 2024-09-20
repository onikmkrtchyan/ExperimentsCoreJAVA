package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> delay = () -> {
            Random random = new Random();
            int anInt = random.nextInt(100);
            Thread.sleep(anInt);
            return anInt;
        };

// How many threads to use?
        ExecutorService executor = Executors.newFixedThreadPool(1);

// Submit all tasks (callables)
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<Integer> future = executor.submit(delay);
            futures.add(future);
        }

// Fetch results
        int completed = 0;
        int totalWait = 0;
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            totalWait += futures.get(i).get();
            completed++;
        }

        System.out.println("Completed tasks: " + completed);
        System.out.println("Total wait: " + totalWait);
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}
