package threads;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Current thread name: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start(); // Starts the thread, which calls the run() method
    }
}
