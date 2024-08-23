package threads;

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

    public static synchronized void whileTrueSynchronized() {
        while (true) ; // do nothing
    }

    public static void sleepRandom() {
        final int seconds = (int) (Math.random() * 10) + 5;
        System.out.println("Sleeping for " + seconds + " seconds");
        sleep(seconds);
    }

}
