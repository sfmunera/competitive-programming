package datastructures;

import java.util.Arrays;

public class SegmentTreeRMQMain {
	static class SegmentTree {
		private int[] M;
		private int[] A;
		
		public SegmentTree(int[] _A) {
			A = _A.clone();
			int N = A.length;
			int exp = (int)(Math.log(N) / Math.log(2.0)) + 1; // floor(log2(N)) + 1
			int size = 1 << (exp + 1);
			
			M = new int[size];
			Arrays.fill(M, -1);
			init(1, 0, N - 1);
		}
		public void init(int node, int l, int r) {
			if (l == r)
				M[node] = l;
			else {
				int left = 2 * node;
				int right = left + 1;
				int mid = (l + r) / 2;
				
				init(left, l, mid);
				init(right, mid + 1, r);
				
				M[node] = A[M[left]] <= A[M[right]] ? M[left] : M[right];
			}
		}
		public int query(int node, int l, int r, int i, int j) {
			if (i > r || j < l) return -1;
			if (i <= l && r <= j) return M[node];
			
			int left = 2 * node;
			int right = left + 1;
			int mid = (l + r) / 2;
			
			int p1 = query(left, l, mid, i, j);
			int p2 = query(right, mid + 1, r, i, j);
			
			if (p1 == -1) return p2;
			if (p2 == -1) return p1;
			return A[p1] <= A[p2] ? p1 : p2;
		}
		public int query(int i, int j) {
			return query(1, 0, A.length - 1, i, j);
		}
		public void update(int node, int l, int r, int pos, int val) {
			if (l == r)
				M[node] = l;
			else {
				int left = 2 * node;
				int right = left + 1;
				int mid = (l + r) / 2;
				
				if (pos <= mid)
					update(left, l, mid, pos, val);
				else
					update(right, mid + 1, r, pos, val);
				
				M[node] = A[M[left]] <= A[M[right]] ? M[left] : M[right];
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
		
		System.out.println(A[st.query(3, 8)]); // -123
		System.out.println(A[st.query(10, 17)]); // -1235
		System.out.println(A[st.query(1, 10)]); // -123
		System.out.println(A[st.query(0, 17)]); // -1235
		System.out.println(A[st.query(7, 12)]); // 4
		
		st.update(13, 1235);
		
		System.out.println(A[st.query(3, 8)]); // -123
		System.out.println(A[st.query(10, 17)]); // -1
		System.out.println(A[st.query(1, 10)]); // -123
		System.out.println(A[st.query(0, 17)]); // -123
		System.out.println(A[st.query(7, 12)]); // 4
	}
}
