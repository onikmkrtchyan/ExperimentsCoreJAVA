package threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    private int sharedData = 0;

    // Method for reading shared data
    public void readData() {
        readLock.lock();  // Acquire the read lock
        try {
            System.out.println(Thread.currentThread().getName() + " is reading data: " + sharedData);
        } finally {
            readLock.unlock();  // Release the read lock
        }
    }

    // Method for writing shared data
    public void writeData(int data) {
        writeLock.lock();  // Acquire the write lock
        try {
            ThreadUtils.sleepRandom();
            System.out.println(Thread.currentThread().getName() + " is writing data: " + data);
            sharedData = data;
        } finally {
            writeLock.unlock();  // Release the write lock
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockExample example = new ReentrantReadWriteLockExample();

        // Multiple threads reading simultaneously
        Thread reader1 = new Thread(example::readData, "Reader 1");
        Thread reader2 = new Thread(example::readData, "Reader 2");

        // One thread writing
        Thread writer = new Thread(() -> example.writeData(42), "Writer");

        reader1.start();
        reader2.start();
        writer.start();


        // iterate till writer thread is locked
        while (writer.isAlive()) {
            new ReentrantReadWriteLockExample().readData();
            new ReentrantReadWriteLockExample().writeData(42);
            System.out.println("Waiting for writer to finish");
        }


    }
}
