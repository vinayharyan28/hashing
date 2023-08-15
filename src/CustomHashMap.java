import java.util.ArrayList;
import java.util.LinkedList;


public class CustomHashMap<K, V> {
    private class Node{
        K key;
        V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }


    private int numberOfNodes, numberOfBuckets;
    private LinkedList<Node>[] buckets;

    public CustomHashMap(){
        this.numberOfBuckets = 4;
        this.numberOfNodes = 0;
        this.buckets = new LinkedList[4];
        for(int i=0; i<4; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key){
        int bucketIndex = key.hashCode();
        return Math.abs(bucketIndex) % numberOfBuckets;
    }

    private int searchInLinkedList(K key, int bucketIndex){
        LinkedList<Node> linkedList = buckets[bucketIndex];
        for (int i=0; i<linkedList.size(); i++){
            if (linkedList.get(i).key == key){
                return i;
            }
        }return -1;
    }

    private void rehashing(){
        LinkedList<Node>[] oldBuckets = buckets;
        buckets = new LinkedList[numberOfBuckets*2];

        for (int i=0; i<numberOfBuckets*2; i++){
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Node> linkedList : oldBuckets) {
            for (Node node : linkedList) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value){
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLinkedList(key, bucketIndex);
        if (dataIndex == -1){
            buckets[bucketIndex].add(new Node(key, value));
            numberOfNodes++;
        }else {
            Node data = buckets[bucketIndex].get(dataIndex);
            data.value = value;
        }
        double lambda = (double) numberOfNodes/numberOfBuckets;

        if (lambda > 2.0){
            rehashing();
        }
    }

    public V get(K key){
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLinkedList(key, bucketIndex);
        if (bucketIndex == -1){
            return null;
        }else{
            Node node = buckets[bucketIndex].get(dataIndex);
            return node.value;
        }
    }

    public boolean containsKey(K key){
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLinkedList(key, bucketIndex);
        return dataIndex != -1;
    }

    public V remove(K key){
        int bucketIndex = hashFunction(key);
        int dataIndex = searchInLinkedList(key, bucketIndex);
        if (dataIndex==-1){
            return null;
        }else {
            Node node = buckets[bucketIndex].remove(dataIndex);
            numberOfNodes--;
            return node.value;
        }
    }

    public boolean isEmpty(){
        return numberOfNodes==0;
    }

    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();
        for (LinkedList<Node> linkedList : buckets) {
            for (Node node : linkedList) {
                keys.add(node.key);
            }
        }return keys;
    }

    public static void main(String[] args){
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("India", 22);
        customHashMap.put("China", 23);
        customHashMap.put("Iran", 24);
        customHashMap.put("Japan", 33);

        customHashMap.remove("Iran");

        ArrayList<String> keys = customHashMap.keySet();
        for (String key: keys){
            System.out.println(key + " " + customHashMap.get(key));
        }

        System.out.println(customHashMap.containsKey("India"));
        System.out.println(customHashMap.keySet());

    }
}


