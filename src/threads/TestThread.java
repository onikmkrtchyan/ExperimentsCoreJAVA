package threads;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

class Loader extends Thread {

    @Override
    public void run() {
        for (long i = 0; i < 1_000_000_000_000L; i++) {
            if (i == 50_000_000_000L)
                System.out.println("i = " + i);
        }
        System.out.println("Hello" + 878768 + "yuqweutwey".toUpperCase() + "ertertwert".substring(5) + Arrays.toString("werwerwer".getBytes(StandardCharsets.UTF_8)) /*+ Thread.currentThread().getName()*/);
    }

    @Override
    public synchronized void start() {
        super.start();//Put debug here to compare results
        System.out.println("Hi there " + 878768 + "yuqweutwey".toUpperCase() + "ertertwert".substring(5) + Arrays.toString("werwerwer".getBytes(StandardCharsets.UTF_8)) + "34523452345"/*+ Thread.currentThread().getName()*/);
    }
}

class MyClass {
    public static void main(String[] args) {
        Loader obj = new Loader();
        obj.start();
    }
}
