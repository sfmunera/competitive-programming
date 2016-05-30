package datastructures;

import java.io.*;

public class HeapMain {
	static class Heap {
		
		private int[] A;
		private int size;
		private int MAXN = 10001;
		
		public Heap() {
			this.size = 0;
			A = new int[MAXN];
		}
		private void swap(int i, int j) {
			int t = A[i];
			A[i] = A[j];
			A[j] = t;
		}
		public int minimum() {
			return A[1];
		}
		public int extractMin() {
			int ans = A[1];
			A[1] = A[size--];
			int p = 1;
			while (true) {
				int min = p;
				int l = p << 1;
				int r = l + 1;
				if (l <= size && A[l] < A[min])
					min = l;
				if (r <= size && A[r] < A[min])
					min = r;
				if (min == p) break;
				
				swap(p, min);
				p = min;
			}
			return ans;
		}
		public void insert(int x) {
			A[++size] = x;
			int i = size;
			while (i > 1 && A[i >> 1] > A[i]) {
				swap(i, i >> 1);
				i >>= 1;
			}
		}
		public int size() {
			return this.size;
		}
		public boolean isEmpty() {
			return size == 0;
		}
	}
	
	// Problem: UVa 10954 - Add All
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			String[] parts = in.readLine().split("[ ]+");
			Heap Q = new Heap();
			
			for (String s : parts)
				Q.insert(Integer.parseInt(s));
			long cost = 0;
			
			while (Q.size() > 1) {
				int n1 = Q.extractMin();
				int n2 = Q.extractMin();
				cost += n1 + n2;
				Q.insert(n1 + n2);
			}
			System.out.println(cost);
		}
		
		in.close();
		System.exit(0);
	}
}
