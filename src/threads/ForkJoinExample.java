package threads;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class FibonacciTask extends RecursiveTask<Integer> {
    private final int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FibonacciTask task1 = new FibonacciTask(n - 1);
        task1.fork();

        FibonacciTask task2 = new FibonacciTask(n - 2);

        HashMap<String, String> map2 = new LinkedHashMap<>();

        final TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();


        Object object = new Object();

        object.hashCode();

        return task2.compute() + task1.join();
    }
}


public class ForkJoinExample {
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(21);

        int result = pool.invoke(task);
        System.out.println("Sum: " + result);
    }
}
