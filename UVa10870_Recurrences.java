package uva;

import java.util.*;
import java.io.*;

public class UVa10870_Recurrences {
	
	static long[][] eye(int n) {
		long[][] I = new long[n][n];
		for (int i = 0; i < n; ++i) {
			I[i][i] = 1;
		}
		return I;
	}
	
	static long[][] multiply(long[][] A, long[][] B, long m) {
		int N = A.length;
		
		long[][] C = new long[N][N];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				for (int k = 0; k < N; ++k)
					C[i][j] = (C[i][j] + ((A[i][k] % m) * (B[k][j] % m)) % m) % m;
		
		return C;
	}
	
	static long[][] fastPow(long[][] mat, long e, long m) {
		int n = mat.length;
		if (e == 0) return eye(n);
		if (e == 1) return mat;
		if (e % 2 == 0) {
			long[][] tmp = fastPow(mat, e / 2, m);
			return multiply(tmp, tmp, m);
		} else {
			long[][] tmp = fastPow(mat, e - 1, m);
			return multiply(mat, tmp, m);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		boolean first = true;
		while (true) {
			if (first) first = false; else in.readLine();
			stk = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(stk.nextToken());
			long n = Long.parseLong(stk.nextToken());
			long m = Long.parseLong(stk.nextToken());
			
			if (d == 0 && n == 0 && m == 0) break;
			
			long[] a = new long[d];
			long[] f0 = new long[d];
			
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < d; ++i)
				a[i] = Long.parseLong(stk.nextToken());
			
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < d; ++i)
				f0[i] = Long.parseLong(stk.nextToken());
			
			long[][] mat = new long[d][d];
			for (int i = 0; i < d; ++i)
				mat[0][i] = a[i];
			
			for (int i = 1; i < d; ++i)
				mat[i][i - 1] = 1;

			mat = fastPow(mat, n - d, m);
			
			long ans = 0;
			for (int i = 0; i < d; ++i)
				ans = (ans + (mat[0][i] * f0[d - 1 - i]) % m) % m;
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
