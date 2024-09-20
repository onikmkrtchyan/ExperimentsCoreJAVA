package threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final ReentrantLock lock = new ReentrantLock();

    public void performAction() {
        lock.lock(); // First lock
        try {
            System.out.println("Performing first action");
            nestedAction(); // This also needs the lock
        } finally {
            lock.unlock(); // First unlock
        }
    }

    public void nestedAction() {
        lock.lock(); // Lock again (same thread)
        try {
            System.out.println("Performing nested action");
        } finally {
            lock.unlock(); // Unlock the second lock
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        example.performAction();
    }
}
