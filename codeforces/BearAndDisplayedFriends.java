package codeforces;

import java.util.*;

public class BearAndDisplayedFriends {
	
	static class Item implements Comparable<Item> {
		int id, t;
		Item(int id, int t) {
			this.id = id;
			this.t = t;
		}
		@Override
		public int compareTo(Item that) {
			return this.t - that.t;
		}
		@Override
		public int hashCode() {
			return id;
		}
		@Override
		public boolean equals(Object o) {
			if (o == null) return false;
			if (this == o) return true;
			if (!(o instanceof Item)) return false;
			
			Item that = (Item) o;
			return this.id == that.id;
		}
		@Override 
		public String toString() {
			return t + "[" + id + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();
		
		int[] t = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = in.nextInt();
		}
		
		PriorityQueue<Item> Q = new PriorityQueue<Item>();
		for (int i = 0; i < q; ++i) {
			int type = in.nextInt();
			int id = in.nextInt() - 1;
			
			if (type == 1) {
				Q.add(new Item(id, t[id]));
				if (Q.size() > k) {
					Q.poll();
				}
			} else {
				System.out.println(Q.contains(new Item(id, t[id])) ? "YES" : "NO");
			}
		}
		
		in.close();
		System.exit(0);
	}
}
