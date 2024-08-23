import java.util.HashMap;
import java.util.Map;

public class Integers {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put(null, "value");
        map.put(null, "value2");

        System.out.println(map.get(null));

        map.put("key", null);
        map.put("key2", null);

        System.out.println("MAP " + map);
    }
}
