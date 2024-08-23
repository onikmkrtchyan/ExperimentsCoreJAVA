package threads;

public class Visibility {


    public static void main(String[] args) {
        Visibility v = new Visibility();
        v.function();
    }

    boolean ready = false;

    void function() {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            while (!ready) ;
            System.out.println("Thread 1 complete");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            ready = true;
            System.out.println("Thread 2 complete");
        });

        thread1.start();
        ThreadUtils.sleepRandom();
        thread2.start();
    }

}
