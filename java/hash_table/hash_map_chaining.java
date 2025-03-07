/* Chained address hash table */

import java.util.ArrayList;
import java.util.List;

class HashMapChaining {
    int size; // Number of key-value pairs
    int capacity; // Hash table capacity
    double loadThres; // Load factor threshold for triggering expansion
    int extendRatio; // Expansion multiplier
    List<List<Pair>> buckets; // Bucket array

    /* Constructor */
    public HashMapChaining() {
        size = 0;
        capacity = 4;
        loadThres = 2.0 / 3.0;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    /* Hash function */
    int hashFunc(int key) {
        return key % capacity;
    }

    /* Load factor */
    double loadFactor() {
        return (double) size / capacity;
    }

    /* Query operation */
    String get(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        // Traverse the bucket, if the key is found, return the corresponding val
        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.val;
            }
        }
        // If key is not found, return null
        return null;
    }

    /* Add operation */
    void put(int key, String val) {
        // When the load factor exceeds the threshold, perform expansion
        if (loadFactor() > loadThres) {
            extend();
        }
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        // Traverse the bucket, if the specified key is encountered, update the corresponding val and return
        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.val = val;
                return;
            }
        }
        // If the key is not found, add the key-value pair to the end
        Pair pair = new Pair(key, val);
        bucket.add(pair);
        size++;
    }

    /* Remove operation */
    void remove(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        // Traverse the bucket, remove the key-value pair from it
        for (Pair pair : bucket) {
            if (pair.key == key) {
                bucket.remove(pair);
                size--;
                break;
            }
        }
    }

    /* Extend hash table */
    void extend() {
        // Temporarily store the original hash table
        List<List<Pair>> bucketsTmp = buckets;
        // Initialize the extended new hash table
        capacity *= extendRatio;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
        size = 0;
        // Move key-value pairs from the original hash table to the new hash table
        for (List<Pair> bucket : bucketsTmp) {
            for (Pair pair : bucket) {
                put(pair.key, pair.val);
            }
        }
    }

    /* Print hash table */
    void print() {
        for (List<Pair> bucket : buckets) {
            List<String> res = new ArrayList<>();
            for (Pair pair : bucket) {
                res.add(pair.key + " -> " + pair.val);
            }
            System.out.println(res);
        }
    }
}
