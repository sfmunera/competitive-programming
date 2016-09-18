package uva;

import java.util.*;
import java.io.*;

public class UVa11495_BubblesAndBuckets {

	static int merge(int[] A, int l, int mid, int r) {
		int cnt = 0;
		int n1 = mid - l + 1;
		int n2 = r - mid;

		int[] L = new int[n1 + 1]; // A[l..mid]
		int[] R = new int[n2 + 1]; // A[mid+1..r]

		for (int i = 0; i < n1; ++i)
			L[i] = A[l + i];
		for (int i = 0; i < n2; ++i)
			R[i] = A[mid + i + 1];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		for (int k = l; k <= r; ++k)
			if (L[i] <= R[j]) {
				A[k] = L[i];
				++i;
			} else {
				A[k] = R[j];
				++j;
				cnt += n1 - i; // Count inversions as remaining elements in left array
			}
		return cnt;
	}

	static int mergesort(int[] A, int l, int r) {

		if (l >= r)
			return 0;

		int mid = (l + r) / 2;
		int cnt = 0;
		cnt += mergesort(A, l, mid);
		cnt += mergesort(A, mid + 1, r);

		cnt += merge(A, l, mid, r);

		return cnt;
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		while (true) {
			int N = in.nextInt();
			if (N == 0)
				break;

			int[] A = new int[N];
			for (int i = 0; i < N; ++i)
				A[i] = in.nextInt();

			int cnt = mergesort(A, 0, N - 1);
			System.out.println(cnt % 2 == 0 ? "Carlos" : "Marcelo");
		}
		
		System.exit(0);
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
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
	}
}
