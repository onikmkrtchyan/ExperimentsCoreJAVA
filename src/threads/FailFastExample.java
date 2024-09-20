package threads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastExample {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();// will throw ConcurrentModificationException because of fail-fast iterator
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();// will not throw ConcurrentModificationException because of fail-safe iterator
        list.add(1);
        list.add(2);
        list.add(3);
        
        // Creating a thread that modifies the list
        Thread modifyingThread = new Thread(() -> list.add(4));

        Iterator<Integer> iterator = list.iterator();

        modifyingThread.start(); // Start the modifying thread
        
        while (iterator.hasNext()) {
            // Will throw ConcurrentModificationException
            System.out.println(iterator.next());
        }
    }
}
