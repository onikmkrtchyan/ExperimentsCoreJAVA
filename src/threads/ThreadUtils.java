package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadUtils {
    public static void sleep(final int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void whileTrue() {
        while (true) ; // do nothing
    }

    public static void whileWithRandomIterations() {
        final long iterations = (long) (Math.random() * 999999999) + 999999999;
        System.out.println("Iterations: " + iterations);
        for (int i = 0; i < iterations; i++) {

            if (i % 100000000 == 0) {
                System.out.println("Iteration: " + i);
            }

        }
    }

    public static synchronized void whileTrueSynchronized() {
        while (true) ; // do nothing
    }

    public static void sleepRandom() {
        final int seconds = (int) (Math.random() * 10) + 5;
        System.out.println("Sleeping for " + seconds + " seconds");
        sleep(seconds);
    }

    public static String allocatedMemory() {
        long free = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        String format = String.format("%,d", free);
        return format + " bytes";
    }

    public static List<String> largeArray(int n) {
        try {
            List<String> value = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String string = String.valueOf(i);
                value.add(string);
            }
            return value;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    protected static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
