package threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class IncorrectReadWriteLockExample {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    private int sharedData = 0;

    // Incorrectly using read lock for both read and write operations
    public void incorrectReadWrite() {
        readLock.lock();  // Acquiring read lock instead of write lock
        try {
            System.out.println(Thread.currentThread().getName() + " is modifying data incorrectly.");
            sharedData++;
        } finally {
            readLock.unlock();  // Releasing the read lock
        }
    }

    public static void main(String[] args) {
        IncorrectReadWriteLockExample example = new IncorrectReadWriteLockExample();

        Thread writer1 = new Thread(example::incorrectReadWrite, "Writer 1");
        Thread writer2 = new Thread(example::incorrectReadWrite, "Writer 2");

        writer1.start();
        writer2.start();
    }
}
