package threads;

public class BlockThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            ThreadUtils.sleepRandom();
            System.out.println("Thread A is waiting for Thread B to release the lock");
        });
        a.setName("Thread A");

        Thread b = new Thread(ThreadUtils::sleepRandom);
        b.setName("Thread B");

        a.start();
        b.start();
    }

}
