package threads;

public class DifferentLocks {
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void testMethod1() {
        synchronized(lock1) {
            // lock1 is acquired by a thread
        }
    }

    public void testMethod2() {
        synchronized(lock2) {
            // lock2 is acquired by another thread
        }
    }

    public static void main(String[] args) {
        DifferentLocks differentLocks = new DifferentLocks();
        Thread thread1 = new Thread(differentLocks::testMethod1);
        Thread thread2 = new Thread(differentLocks::testMethod2);

        thread1.start();
        thread2.start();
    }
}
