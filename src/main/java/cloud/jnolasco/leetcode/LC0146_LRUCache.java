package cloud.jnolasco.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


// Explanation: https://youtu.be/9RQvjzszwsg?si=y7L5vH1ZBwfA3fp0
// Time constant: O(1)
// Space constant: O(N)

public class LC0146_LRUCache {
    private int capacity;
    private Map<Integer, CacheNode> cache;
    private LinkedList<CacheNode> lruList;

    public LC0146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    private class CacheNode {
        private int key;
        private int value;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            lruList.remove(node);
            lruList.addFirst(node);

            return node.value;  // make sure to return value
        }

        return -1;
    }

    public void put(int key, int value) {
        // if key is already in cache might update value
        if(cache.containsKey(key))
        {
            CacheNode node = cache.get(key);
            // remove from LRU list
            lruList.remove(node);
            // update value and add to front
            node.value = value;
            // add to LRU list at front
            lruList.addFirst(node);
        } else {

            // check if cache is full and remove last element (meaning last used)
            if(cache.size() == capacity) {
                CacheNode node = lruList.removeLast();
                cache.remove(node.key);
            }

            // add new element
            CacheNode node = new CacheNode(key, value);
            lruList.addFirst(node);
            cache.put(key, node);

        }
    }

    public static void main(String[] args) {
        /*
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
        */

        LC0146_LRUCache lruCache = new LC0146_LRUCache(1);
        lruCache.put(2, 1); // cache is {1=1}
        System.out.println(lruCache.get(2));    // return 1

    }
}
