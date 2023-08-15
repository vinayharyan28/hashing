import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HashMapTest {
    public static void main(String[] args){
        // Create
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Insertion
        hashMap.put("India", 120);
        hashMap.put("China", 180);
        hashMap.put("Japan", 150);

        // Overlap if exit else create new key
        hashMap.put("India", 115);
        hashMap.put("Russia", 400);

        // Search
        System.out.println(hashMap.containsKey("India"));
        System.out.println(hashMap.containsKey("Iran"));

        System.out.println(hashMap.get("India"));
        System.out.println(hashMap.get("Iran"));

        hashMap.remove("China");

        // Iterate
        System.out.println(hashMap);
        for (Map.Entry<String, Integer> hm: hashMap.entrySet()){
            System.out.println(hm.getKey()+ " " + hm.getValue());
        }

        Set<String> keys = hashMap.keySet();
        for (String key: keys){
            System.out.println(key + " " + hashMap.get(key));
        }


    }
}
