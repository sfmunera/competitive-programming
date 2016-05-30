package codeforces;

import java.io.*;
import java.util.*;


public class XeniaAndBitOperations {
	
	static int n;
	
	static class SegmentTree {
		private int[] A;
		private int[] S;
		
		public SegmentTree(int[] _A) {
			A = _A.clone();
			int N = A.length;
			int exp = (int)Math.ceil((Math.log(N) / Math.log(2.0)));
			int size = 1 << (exp + 1);
			 
			S = new int[size];
			init(1, 0, N - 1, n);
		}
		
		public void init(int node, int l, int r, int level) {
			if (l == r) {
				S[node] = A[l];
				return;
			}
			int left = 2 * node;
			int right = left + 1;
			int mid = (l + r) / 2;
			
			init(left, l, mid, level - 1);
			init(right, mid + 1, r, level - 1);
			
			if (level % 2 == 1)
				S[node] = S[left] | S[right];
			else
				S[node] = S[left] ^ S[right];
		}
		
		public void update(int node, int l, int r, int pos, int val, int level) {
			if (l == r) {
				S[node] = A[l];
				return;
			}
			int left = 2 * node;
			int right = left + 1;
			int mid = (l + r) / 2;
			
			if (pos <= mid)
				update(left, l, mid, pos, val, level - 1);
			else
				update(right, mid + 1, r, pos, val, level - 1);
			
			if (level % 2 == 1)
				S[node] = S[left] | S[right];
			else
				S[node] = S[left] ^ S[right];
		}
		
		public void update(int pos, int val) {
			A[pos] = val;
			update(1, 0, A.length - 1, pos, val, n);
		}
		
		public int query() {
			return S[1];
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		n = in.nextInt();
		int m = in.nextInt();
		
		int[] a = new int[1 << n];
		for (int i = 0; i < (1 << n); ++i)
			a[i] = in.nextInt();
		
		SegmentTree st = new SegmentTree(a);
		
		for (int i = 0; i < m; ++i) {
			int p = in.nextInt();
			int b = in.nextInt();
			
			st.update(p - 1, b);
			System.out.println(st.query());
		}
	}
	

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = new StringTokenizer("");
		}

		public String next() {
			try {
				while (!tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = new StringTokenizer("");
				line =  reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
	}
}
