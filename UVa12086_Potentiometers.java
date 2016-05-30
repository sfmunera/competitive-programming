package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3238 (12086 - Potentiometers) */
/* SUBMISSION: 11534969 */
/* SUBMISSION TIME: 2013-03-31 05:08:16 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12086_Potentiometers {
	
	static class SegmentTree {
		private int[] A;
		private int[] S;
		
		public SegmentTree(int[] _A) {
			A = _A.clone();
			int N = A.length;
			int exp = (int)(Math.log(N) / Math.log(2.0)) + 1;
			int size = 1 << (exp + 1);
			 
			S = new int[size];
			init(1, 0, N - 1);
		}
		
		public void init(int node, int l, int r) {
			if (l == r) {
				S[node] = A[l];
				return;
			}
			int left = 2 * node;
			int right = left + 1;
			int mid = (l + r) / 2;
			
			init(left, l, mid);
			init(right, mid + 1, r);
			
			S[node] = S[left] + S[right];
		}
		
		public void update(int node, int l, int r, int pos, int val) {
			if (l == r) {
				S[node] = A[l];
				return;
			}
			int left = 2 * node;
			int right = left + 1;
			int mid = (l + r) / 2;
			
			if (pos <= mid)
				update(left, l, mid, pos, val);
			else
				update(right, mid + 1, r, pos, val);
			S[node] = S[left] + S[right];
		}
		
		public void update(int pos, int val) {
			A[pos] = val;
			update(1, 0, A.length - 1, pos, val);
		}
		
		public int query(int node, int l, int r, int i, int j) {
			if (l > j || r < i) return 0;
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
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder ans = new StringBuilder();
		
		int t = 1;
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			
			int[] A = new int[N];
			for (int i = 0; i < N; ++i)
				A[i] = Integer.parseInt(in.readLine());
			
			SegmentTree st = new SegmentTree(A);
			
			if (t > 1) ans.append("\n");
			ans.append("Case " + t + ":\n");
			
			String line;
			while (!(line = in.readLine()).equals("END")) {
				StringTokenizer stk = new StringTokenizer(line);
				char command = stk.nextToken().charAt(0);
				int a = Integer.parseInt(stk.nextToken()) - 1;
				int b = Integer.parseInt(stk.nextToken());
				
				if (command == 'S') {
					st.update(a, b);
				} else {
					--b;
					ans.append(st.query(a, b) + "\n");
				}
			}
			
			++t;
		}
		System.out.print(ans);
		
		in.close();
		System.exit(0);
	}
}
