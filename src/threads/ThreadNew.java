package threads;

import java.util.concurrent.TimeUnit;

public class ThreadNew {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("Thread_!!!!!!!!!!");



        Thread a = new Thread(ThreadNew::sleep);
        a.setName("Thread A");

        Thread b = new Thread(ThreadNew::safeMethod);
        b.setName("Thread B");


        System.out.println("Starting threads in 17 seconds");
        TimeUnit.SECONDS.sleep(17);
        System.out.println("Starting threads now");

        a.start();
        b.start();
        b.run();

    }

    public static synchronized void sleep() {
        try {
            Thread.sleep(11_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void safeMethod() {
        while (true); // do nothing
    }
}
