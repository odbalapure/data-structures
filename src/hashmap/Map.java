package hashmap;

import java.util.ArrayList;
import java.util.List;

public class Map<K, V> {
    private List<MapNode<K, V>> buckets;
    private int count;
    private int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 20;
        for (int i=0; i<numBuckets; i++) {
            buckets.add(null);
        }
    }

    /*Helper function to calculate the index in a bucket*/
    private int getBucketIndex(K key) {
        int hc = key.hashCode();
        int index = hc % numBuckets;
        return index;
    }

    /*Insert a node in a hashmap*/
    public void insert(K key, V value) {
        // first we check whether the passed key exists or not
        // if it does then just update the value of THAT key
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // if the passed key does not exist
        // then get the head of the linked list
        head = buckets.get(bucketIndex);
        // create a new node and make it a head node
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);

        // new node inserted, increase the count of nodes
        count++;

        // NOTE: insert, search and delete operation can be optimized to O(1)
        //  iff we maintain the LOAD FACTOR
        double loadFactor = loadFactor();
        if (loadFactor > 0.7) {
            reHash();
        }
    }

    /*Returns load factor*/
    private double loadFactor() {
        return (1.0 *count)/numBuckets;
    }

    /*Rehash function to keep track of load factor*/
    private void reHash() {
        // create backup of original bucket to create a copy
        List<MapNode<K, V>> temp = buckets;
        // reinitialize the original bucket
        buckets = new ArrayList<>();
        for (int i=0; i<2*numBuckets; i++) {
            // initialize the new bucket indices to null
            buckets.add(null);
        }
        // as we creating a new bucket set count as 0
        count = 0;
        numBuckets = numBuckets * 2;
        for (int i=0; i<temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                // iterate through the list
                head = head.next;
            }
        }
    }

    /*Returns number of nodes in the map*/
    public int size() {
        return count;
    }

    /*Search value of a key*/
    public V getValue(K key) {
        // get the index of the key
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                // if key is present then return the value
                return head.value;
            }
            head = head.next;
        }

        // return null if key does not exist
        return null;
    }

    /*Delete a key from hashmap*/
    public V removeKey(K key) {
        // get the index of the key to delete
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }

        // return null if key does not exist
        return null;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        for (int i=0; i<20; i++) {
            map.insert("abc" + i, i+1);
            System.out.println("Load factor: " + map.loadFactor());
        }

        map.removeKey("abc3");
        map.removeKey("abc7");

        System.out.println("########################################");
        System.out.println("HashMap entries are: ");
        for (int i=0; i<20; i++) {
            System.out.println("abc" + i +": " + map.getValue("abc"+i));
        }
    }
}
