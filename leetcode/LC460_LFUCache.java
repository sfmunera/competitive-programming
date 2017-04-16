package leetcode;

import java.util.*;

public class LC460_LFUCache {
    public class LFUCache {
        private int time;
        private int capacity;
        private int size;
        private Map<Integer, Element> map;
        private TreeSet<Element> lfu;

        private class Element implements Comparable<Element> {
            int key, value, count, timestamp;
            Element(int key, int value) {
                this.key = key;
                this.value = value;
                this.count = 0;
                touch();
            }
            void touch() {
                this.timestamp = time++;
                this.count++;
            }
            void touch(int value) {
                this.value = value;
                touch();
            }
            @Override
            public int compareTo(Element that) {
                if (this.count != that.count) {
                    return this.count - that.count;
                }
                return this.timestamp - that.timestamp;
            }
            @Override
            public boolean equals(Object o) {
                Element that = (Element) o;
                return this.key == that.key;
            }
            @Override
            public int hashCode() {
                return this.key;
            }
        }

        public LFUCache(int capacity_) {
            capacity = capacity_;
            size = 0;
            time = 0;
            map = new HashMap<Integer, Element>();
            lfu = new TreeSet<Element>();
        }
        
        public int get(int key) {
            if (map.containsKey(key)) {
                Element e = map.get(key);
                lfu.remove(e);
                e.touch();
                lfu.add(e);
                return e.value;
            } else {
                return -1;
            }
        }
        
        public void put(int key, int value) {
            if (capacity > 0) {
                Element e;
                if (map.containsKey(key)) {
                    e = map.get(key);
                    lfu.remove(e);
                    map.remove(key);
                    e.touch(value);
                    size--;
                } else {
                    e = new Element(key, value);
                    if (size == capacity) {
                        map.remove(lfu.pollFirst().key);
                        size--;
                    }
                }
                lfu.add(e);
                map.put(key, e);
                size++;
            }
        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
}
