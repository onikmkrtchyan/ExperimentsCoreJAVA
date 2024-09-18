package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static threads.ThreadUtils.*;

public class MemoryLeakStaticField {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executor.execute(() -> {
            while (true) {
                new Counter();
                sleep(10);
            }
        });

        Runnable monitor = () -> {
            while (true) {
                System.out.println(allocatedMemory());
                sleep(1);
            }
        };
        executor.execute(monitor);
    }
}

class Counter {
    public static int COUNT = 0;
    public int num;

    Counter() {
        Map<String, Object> map = new HashMap<>();
        COUNT++;

        for (int i = 0; i < 999999999; i++) {
            map.put("key" + i, largeArray(1_000_000));
            System.out.println("Map size = " + map.size());
            sleep(1);
        }

        num++;
    }
}
