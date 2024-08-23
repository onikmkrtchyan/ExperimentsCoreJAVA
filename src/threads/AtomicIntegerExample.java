package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    // Shared counter
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // Create two threads that increment the counter
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The final value should be 2000
        System.out.println("Final Counter Value: " + counter.get());
    }

    // Task that increments the counter 1000 times
    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Atomic increment
            }
        }
    }
}
