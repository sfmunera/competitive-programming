package topcoder;

import java.util.*;

class Store {
	int open, close, duration;
	public Store(int open, int close, int duration) {
		this.open = open;
		this.close = close;
		this.duration = duration;
	}
}

public class TravellingPurchasingMan {
    public int maxStores(int N, String[] is, String[] roads) {
        int M = is.length;
        Store[] stores = new Store[M];
        for (int i = 0; i < M; ++i) {
        	String[] parts = is[i].split("[ ]");
        	int open = Integer.parseInt(parts[0]);
        	int close = Integer.parseInt(parts[1]);
        	int duration = Integer.parseInt(parts[2]);
        	stores[i] = new Store(open, close, duration);
        }
        
        int[][] adj = new int[N][N];
        for (int i = 0; i < roads.length; ++i) {
        	String[] parts = is[i].split("[ ]");
        	int A = Integer.parseInt(parts[0]);
        	int B = Integer.parseInt(parts[1]);
        	int length = Integer.parseInt(parts[2]);
        	adj[A][B] = adj[B][A] = length;
        }
        
        
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TravellingPurchasingMan.class, "test.*");
    }

	public void test0() {
		RETester.eq(maxStores(3, new String[] {"1 10 10" , "1 55 31", "10 50 100" }, new String[] {"1 2 10"}), 1);
	}

	public void test1() {
		RETester.eq(maxStores(3, new String[] {"1 10 10" , "1 55 30", "10 50 100" }, new String[] {"1 2 10"}), 2);
	}

	public void test2() {
		RETester.eq(maxStores(5, new String[] {"0 1000 17"}, new String[] {"2 3 400", "4 1 500", "4 3 300", "1 0 700", "0 2 400"}), 0);
	}

// END CUT HERE
}
