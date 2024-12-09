/* Key-value pair */
struct Pair {
public:
  int key;
  string val;
  Pair(int key, string val) {
    this->key = key;
    this->val = val;
  }
};

/* Chained address hash table */
class HashMapChaining {
private:
  int size;         // Number of key-value pairs
  int capacity;     // Hash table capacity
  double loadThres; // Load factor threshold for triggering expansion
  int extendRatio;  // Expansion multiplier
  vector<vector<Pair *>> buckets; // Bucket array

public:
  /* Constructor */
  HashMapChaining()
      : size(0), capacity(4), loadThres(2.0 / 3.0), extendRatio(2) {
    buckets.resize(capacity);
  }

  /* Destructor */
  ~HashMapChaining() {
    for (auto &bucket : buckets) {
      for (Pair *pair : bucket) {
        // Free memory
        delete pair;
      }
    }
  }

  /* Hash function */
  int hashFunc(int key) { return key % capacity; }

  /* Load factor */
  double loadFactor() { return (double)size / (double)capacity; }

  /* Query operation */
  string get(int key) {
    int index = hashFunc(key);
    // Traverse the bucket, if the key is found, return the corresponding val
    for (Pair *pair : buckets[index]) {
      if (pair->key == key) {
        return pair->val;
      }
    }
    // If key not found, return an empty string
    return "";
  }

  /* Add operation */
  void put(int key, string val) {
    // When the load factor exceeds the threshold, perform expansion
    if (loadFactor() > loadThres) {
      extend();
    }
    int index = hashFunc(key);
    // Traverse the bucket, if the specified key is encountered, update the
    // corresponding val and return
    for (Pair *pair : buckets[index]) {
      if (pair->key == key) {
        pair->val = val;
        return;
      }
    }
    // If the key is not found, add the key-value pair to the end
    buckets[index].push_back(new Pair(key, val));
    size++;
  }

  /* Remove operation */
  void remove(int key) {
    int index = hashFunc(key);
    auto &bucket = buckets[index];
    // Traverse the bucket, remove the key-value pair from it
    for (int i = 0; i < bucket.size(); i++) {
      if (bucket[i]->key == key) {
        Pair *tmp = bucket[i];
        bucket.erase(bucket.begin() + i); // Remove key-value pair
        delete tmp;                       // Free memory
        size--;
        return;
      }
    }
  }

  /* Extend hash table */
  void extend() {
    // Temporarily store the original hash table
    vector<vector<Pair *>> bucketsTmp = buckets;
    // Initialize the extended new hash table
    capacity *= extendRatio;
    buckets.clear();
    buckets.resize(capacity);
    size = 0;
    // Move key-value pairs from the original hash table to the new hash table
    for (auto &bucket : bucketsTmp) {
      for (Pair *pair : bucket) {
        put(pair->key, pair->val);
        // Free memory
        delete pair;
      }
    }
  }

  /* Print hash table */
  void print() {
    for (auto &bucket : buckets) {
      cout << "[";
      for (Pair *pair : bucket) {
        cout << pair->key << " -> " << pair->val << ", ";
      }
      cout << "]\n";
    }
  }
};