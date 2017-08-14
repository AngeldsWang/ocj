/**
 * Created by wang-zhenjun on 9/2/16.
 */

import java.util.*;

public class LRUCache {
    int capacity;
    LinkedList<CacheNode> list;
    HashMap<Integer, CacheNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        CacheNode refresh = new CacheNode(key, cache.get(key).value);

        list.remove(cache.get(key));

        // move to the head
        list.addFirst(refresh);

        // update cache
        cache.put(key, refresh);

        return refresh.value;
    }

    public void set(int key, int value) {
        if (!cache.containsKey(key)) {
            if (list.size() == capacity) {
                CacheNode LRU = list.pollLast();
                cache.remove(LRU.key);
            }
            CacheNode node = new CacheNode(key, value);
            list.addFirst(node);
            cache.put(key, node);
        } else {
            CacheNode refresh = new CacheNode(key, value);
            list.remove(cache.get(key));
            list.addFirst(refresh);
            cache.put(key, refresh);
        }
    }

    public static void main(String args[]) {
        LRUCache s = new LRUCache(4);
        s.set(1, 2);
        s.set(3, 7);
        System.out.println(s.get(9));
        System.out.println(s.get(3));
    }
}

class CacheNode {
    int key;
    int value;
    CacheNode(int k, int v) {
        this.key = k;
        this.value = v;
    }
}
