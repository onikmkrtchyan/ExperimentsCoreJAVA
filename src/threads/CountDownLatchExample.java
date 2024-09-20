package threads;

import java.util.concurrent.*;

public class CountDownLatchExample {
    private static final int TOTAL_TASKS = 6;
    private static final CountDownLatch latch = new CountDownLatch(TOTAL_TASKS);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < TOTAL_TASKS; i++) {
            new Thread(new Task(i)).start();
        }

        System.out.println("Main thread is waiting for tasks to finish...");
        latch.await(); // Correctly waiting for all tasks to complete
        System.out.println("All tasks finished. Main thread proceeds.");
    }

    static class Task implements Runnable {
        private final int id;

        Task(int id) {
            this.id = id;
        }

        public void run() {
            try {
                // Simulate work
                Thread.sleep(5000);
                System.out.println("Task " + id + " completed.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Task " + id + " is decrementing the latch...");
                latch.countDown(); // Correctly decrementing the latch
            }
        }
    }
}
