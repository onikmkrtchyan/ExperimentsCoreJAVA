import java.util.concurrent.TimeUnit;

class StopThread1 {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            if (!stopRequested)
                    i++;
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(4);
        stopRequested = true;
    }
}

// Properly synchronized cooperative thread termination
public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args)
            throws InterruptedException {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested())
                System.out.println(i++);
        });


        backgroundThread.start();
        TimeUnit.SECONDS.sleep(20);
        requestStop();
    }
}