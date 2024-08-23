package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnablePool implements Runnable {
    @Override
    public void run() {
        ThreadUtils.whileTrue();
        System.out.println("Current thread name: " + Thread.currentThread().getName());
    }
}

public class MainPool {
    public static void main(String[] args) {
        // Create a thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Submit multiple tasks to the thread pool
        for (int i = 0; i < 30; i++) {
            executorService.submit(new MyRunnablePool());
        }

        // Shut down the executor service
        executorService.shutdown();
    }
}
