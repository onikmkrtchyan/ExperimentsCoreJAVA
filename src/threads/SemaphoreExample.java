package threads;

import java.util.concurrent.*;

public class SemaphoreExample {
    private static final int MAX_PERMITS = 5;
    private static final Semaphore semaphore = new Semaphore(MAX_PERMITS);

    public static void main(String[] args) {
        for (int i = 0; i < 170; i++) {
            new Thread(new Worker(i)).start();
        }
    }

    static class Worker implements Runnable {
        private final int id;

        Worker(int id) {
            this.id = id;
        }

        public void run() {
            try {
                System.out.println("Thread " + id + " is waiting for permit...");
                semaphore.acquire(); // Correctly acquiring the semaphore
                System.out.println("Thread " + id + " got the permit!");

                // Simulate work
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("Thread " + id + " is releasing the permit...");
                semaphore.release(); // Correctly releasing the semaphore
            }
        }
    }
}
