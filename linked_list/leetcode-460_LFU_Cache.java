// https://leetcode.com/problems/lfu-cache/description/

import java.util.*;

class Pair
{
    public static <T, U> Map.Entry<T, U> of(T first, U second) {
        return new AbstractMap.SimpleEntry<>(first, second);
    }
}

class LFUCache {
    Map<Integer, Map.Entry<Integer, Integer>> cache;
    Map<Integer, LinkedHashSet<Integer>> freqs;
    int capacity, minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        cache = new HashMap<>();
        freqs = new HashMap<>();
    }
    
    public int get(int key) {
        Map.Entry<Integer, Integer> pair = cache.get(key);

        if (pair == null) {
            return -1;
        }

        int freq = pair.getKey();
        int value = pair.getValue();
        Set<Integer> keys = freqs.get(freq);

        keys.remove(key);
        if (keys.isEmpty() && minFreq == freq) {
            minFreq++;
        }

        insert(key, value, freq+1);
        return value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Map.Entry<Integer, Integer> pair = cache.get(key);
        if (pair != null) {
            cache.put(key, Pair.of(pair.getKey(), value));
            get(key);
            return;
        }

        if (capacity == cache.size()) {
            final Set<Integer> keys = freqs.get(minFreq);
            final int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);     
        }

        minFreq = 1;
        insert(key, value, 1);
    }

    private void insert(int key, int value, int freq) {
        cache.put(key, Pair.of(freq, value));
        freqs.putIfAbsent(freq, new LinkedHashSet<>());
        freqs.get(freq).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
