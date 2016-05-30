package datastructures;

import java.util.*;

public class SegmentTreeRSQMain {
	static class SegmentTree {
		private int[] S;
		private int[] A;
		
		public SegmentTree(int[] _A) {
			A = _A.clone();
			int N = A.length;
			int exp = (int)(Math.log(N) / Math.log(2.0)) + 1; // floor(log2(N)) + 1
			int size = 1 << (exp + 1);
			
			S = new int[size];
			Arrays.fill(S, 0);
			init(1, 0, N - 1);
		}
		public void init(int node, int l, int r) {
			if (l == r)
				S[node] = A[l];
			else {
				int left = 2 * node;
				int right = left + 1;
				int mid = (l + r) / 2;
				
				init(left, l, mid);
				init(right, mid + 1, r);
				
				S[node] = S[left] + S[right];
			}
		}
		public int query(int node, int l, int r, int i, int j) {
			if (i > r || j < l) return 0;
			if (i <= l && r <= j) return S[node];
			
			int left = 2 * node;
			int right = left + 1;
			int mid = (l + r) / 2;
			
			int p1 = query(left, l, mid, i, j);
			int p2 = query(right, mid + 1, r, i, j);

			return p1 + p2;
		}
		public int query(int i, int j) {
			return query(1, 0, A.length - 1, i, j);
		}
		public void update(int node, int l, int r, int pos, int val) {
			if (l == r)
				S[node] = A[l];
			else {
				int left = 2 * node;
				int right = left + 1;
				int mid = (l + r) / 2;
				
				if (pos <= mid)
					update(left, l, mid, pos, val);
				else
					update(right, mid + 1, r, pos, val);
				
				S[node] = S[left] + S[right];
			}
		}
		public void update(int pos, int val) {
			A[pos] = val;
			update(1, 0, A.length - 1, pos, val);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {7, 234, -23, 54, 76, 0, -123, 4, 1000, 374, 11, 100, 423, -1235, 857, 48, 99, -1};
		SegmentTree st = new SegmentTree(A);
		
		System.out.println(st.query(3, 8)); // 1011
		System.out.println(st.query(10, 17)); // 302
		System.out.println(st.query(1, 10)); // 1607
		System.out.println(st.query(0, 17)); // 1905
		System.out.println(st.query(7, 12)); // 1912
		
		st.update(13, 1235);
		System.out.println();
		System.out.println(st.query(3, 8)); // 1011
		System.out.println(st.query(10, 17)); // 2772
		System.out.println(st.query(1, 10)); // 1607
		System.out.println(st.query(0, 17)); // 4375
		System.out.println(st.query(7, 12)); // 1912
	}
}
