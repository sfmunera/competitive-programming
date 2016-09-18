package uva;

import java.util.*;
import java.io.*;

public class UVa00714_CopyingBooks {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			stk = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
			
			int[] p = new int[m];
			
			long lo = 0;
			long hi = 0;
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < m; ++i) {
				p[i] = Integer.parseInt(stk.nextToken());
				lo = Math.max(lo, (long)p[i]);
				hi += (long)p[i];
			}
			
			while (lo < hi) {
				long mid = (lo + hi) / 2;
				int cnt = 1;
				long sum = 0;
				for (int i = 0; i < m; ++i) {
					if (sum + p[i] > mid) {
						++cnt;
						sum = 0;
					}
					sum += p[i];
				}
				
				// If number of assignments is > k, increase number of pages
				if (cnt > k)
					lo = mid + 1;
				else
					hi = mid;
			}
			// put / after p[i]
			boolean[] put = new boolean[m];
			long sum = 0;
			int j = 0;
			for (int i = m - 1; i >= 0; --i) {
				if (sum + p[i] > lo) {
					if (i > 0) {
						++j;
						put[i] = true;
					}
					sum = 0;
				}
				sum += p[i];
			}
			for (int i = 0; i < m && j < k - 1; ++i) {
				if (!put[i]) {
					put[i] = true;
					++j;
				}
			}
			for (int i = 0; i < m; ++i) {
				if (i > 0) System.out.print(" ");
				System.out.print(p[i]);
				if (put[i]) System.out.print(" /");
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
