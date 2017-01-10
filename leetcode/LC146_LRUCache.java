package leetcode;

import java.util.*;

public class LC146_LRUCache {
	static class LRUCache {
		private class Item {
			int key, value;
			Item(int key, int value) {
				this.key = key;
				this.value = value;
			}
			public String toString() {
				return "(" + key + ", " + value + ")";
			}
		}

		private Deque<Item> items;
		private Map<Integer, Item> cache;
		private int capacity;

		public LRUCache(int capacity_) {
			items = new LinkedList<Item>();
			cache = new HashMap<Integer, Item>();
			capacity = capacity_;
		}

		public int get(int key) {
			if (cache.containsKey(key)) {
				Item item = cache.get(key);
				updateItem(key);
				return item.value;
			} else {
				return -1;
			}
		}

		public void set(int key, int value) {
			if (cache.containsKey(key)) {
				Item item = cache.get(key);
				item.value = value;
				updateItem(key);
			} else {
				if (items.size() == capacity) {
					Item first = items.peekFirst();
					cache.remove(first.key);
					items.removeFirst(); // remove LRU
				}
				Item item = new Item(key, value);
				items.addLast(item);
				cache.put(key, item);
			}
		}

		private void updateItem(int key) {
			Item item = cache.get(key);
			items.remove(item);
			items.addLast(item);// move item to MRU position
		}
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		
		cache.set(2, 1);
		System.out.println(cache.get(2));
		cache.set(3, 2);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
	}
}
