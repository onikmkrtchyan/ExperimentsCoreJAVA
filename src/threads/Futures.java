package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        final Future<?> future = executor.submit(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        while (!future.isDone()) {
            // do nothing
            System.out.println("Waiting for the future to be done");
        }
        System.out.println("Done");
        executor.shutdown();
    }
}
