package com.huabin.topk;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author huabin
 * @DateTime 2023-07-26 09:14
 * @Desc LRU 缓存机制
 */
public class Q004_LRUCahe {

    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        public LRUCache(int capacity) {
            // Set the access-order to true to maintain the order based on access time
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            // Remove the oldest element when the size exceeds the capacity
            return size() > capacity;
        }

        public synchronized V get(Object key) {
            return super.get(key);
        }

        public synchronized V put(K key, V value) {
            super.put(key, value);
            return value;
        }

        public synchronized int getCacheSize() {
            return size();
        }
    }

    public static void main(String[] args) {
        // Usage example
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println(cache.getCacheSize()); // Output: 3

        cache.get(2);
        cache.put(4, "Four"); // This will remove the least recently used element "1"

        System.out.println(cache.get(1)); // Output: null (element "1" was removed from the cache)
        System.out.println(cache.get(2)); // Output: Two (element "2" was accessed, making it the most recently used)
        System.out.println(cache.get(3)); // Output: Three
        System.out.println(cache.get(4)); // Output: Four
    }

}
