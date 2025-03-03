import java.util.HashMap;
import java.util.Map;

public class hash_map {
  public static void main(String[] args) {
    /* Initialize hash table */
    Map<Integer, String> map = new HashMap<>();

    /* Add operation */
    // Add key-value pair (key, value) to hash table
    map.put(12836, "Xiao Ha");
    map.put(15937, "Xiao Luo");
    map.put(16750, "Xiao Suan");
    map.put(13276, "Xiao Fa");
    map.put(10583, "Xiao Ya");

    /* Query operation */
    // Input key into hash table, get value
    String name = map.get(15937);

    /* Delete operation */
    // Delete key-value pair (key, value) from hash table
    map.remove(10583);

    /* Traverse hash table */
    // Traverse key-value pairs key->value
    for (Map.Entry<Integer, String> kv : map.entrySet()) {
      System.out.println(kv.getKey() + " -> " + kv.getValue());
    }
    // Traverse keys only
    for (int key : map.keySet()) {
      System.out.println(key);
    }
    // Traverse values only
    for (String val : map.values()) {
      System.out.println(val);
    }
  }
}
