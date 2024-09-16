package org.example.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


// Explanation: https://youtu.be/9RQvjzszwsg?si=y7L5vH1ZBwfA3fp0
// Time constant: O(1)
// Space constant: O(N)

public class LC0146_LRUCache {
    private int capacity;
    private Map<Integer, CacheItem> cache;
    private LinkedList<CacheItem> lruList;

    public LC0146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    private class CacheItem {
        private int key;
        private int value;

        public CacheItem(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int get(int key) {
        CacheItem found = cache.get(key);
        if( found != null)
        {
            lruList.removeLast();
            lruList.addFirst(new CacheItem(key, found.value));
            return found.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        CacheItem newItem = new CacheItem(key, value);
        if(cache.get(key) != null)
        {
            lruList.removeLast();
            lruList.addFirst(newItem);
            cache.put(key, newItem);
        }
        else {
            if(cache.size() < capacity)
            {
                cache.put(key, newItem);
                lruList.addFirst(newItem);
            }
            else {
                CacheItem removed = lruList.removeLast();
                cache.remove(removed.key);
                cache.put(key, newItem);
                lruList.addFirst(newItem);

            }
        }
    }

    public static void main(String[] args) {
        LC0146_LRUCache lruCache = new LC0146_LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1));    // return 1
        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2));    // returns -1 (not found)
        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1));    // return -1 (not found)
        System.out.println(lruCache.get(3));    // return 3
        System.out.println(lruCache.get(4));    // return 4
    }
}
