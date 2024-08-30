package threads;

public class Visibility {

    public static void main(String[] args) {
        Visibility v = new Visibility();
        v.function();
    }

    boolean ready = false;
    // volatile boolean ready = false;

    void function() {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            while (!ready) {
            }
            System.out.println("Thread 1 complete");
        });

        thread1.setName("Thread____1");
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            ready = true;
            System.out.println("Thread 2 complete sleep");
            ThreadUtils.sleepRandom();

            System.out.println("Thread 2 complete");
        });
        thread2.setName("Thread____2");

        thread1.start();
        ThreadUtils.sleepRandom();
        thread2.start();

    }

}
