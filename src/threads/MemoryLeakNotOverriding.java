package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static threads.ThreadUtils.*;

public class MemoryLeakNotOverriding {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        localMethod();

        Runnable monitor = () -> {
            while (true) {
                System.out.println(allocatedMemory());
                sleep(1000);
            }
        };
        executor.execute(monitor);
    }

    public static void localMethod() {
        Map<WrongKey, Object> map = new HashMap<>();

        Runnable addObjects = () -> {
            while (true) {
                WrongKey key = new WrongKey();
                key.name = "Alice";
                map.put(key, largeArray(1_000_000));
                System.out.println("Map size = " + map.size());
                sleep(10);
            }
        };

        executor.execute(addObjects);
    }
}

class WrongKey {
    String name;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WrongKey wrongKey = (WrongKey) o;
//        return name.equals(wrongKey.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
