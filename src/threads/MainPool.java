package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnablePool {
    public static void main(String[] args) {

        // Create a thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        // Submit multiple tasks to the thread pool
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                ThreadUtils.whileWithRandomIterations();
                System.out.println("Current thread name: " + Thread.currentThread().getName());
            });
        }

        // Shut down the executor service
        executorService.shutdown();
    }
}
