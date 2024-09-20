package threads;

public class StartupWaitAndNotify {

    private static final Object lock = new Object();

    private static boolean initialized = false;

    public static void main(String[] args) throws InterruptedException {

        Thread guard = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (!initialized) {  // why not "if"?
                        System.out.println(Thread.currentThread().getName() + ": Waiting to initialize...");
                        lock.wait(10000);
                    }
                    System.out.println(Thread.currentThread().getName() + ": Program is initialized");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        guard.setName("Guarding Thread");

        Thread initializer = new Thread(() -> {
            //                Thread.sleep(3000);
            ThreadUtils.sleepRandom();
            System.out.println(Thread.currentThread().getName() + ": Ready to go");
            synchronized (lock) {
                initialized = true;
                lock.notify();
            }
        });

        initializer.setName("Initializer Thread");

		// What if initialization is never done?
		initializer.start();
        guard.start();

    }
}
