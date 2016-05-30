package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2958 (11858 - Frosh Week) */
/* SUBMISSION: 10044869 */
/* SUBMISSION TIME: 2012-04-27 16:28:14 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11858_FroshWeek {
	
	static long merge(long[] A, int l, int mid, int r) {
		long cnt = 0;
		int n1 = mid - l + 1;
		int n2 = r - mid;
		
		long[] L = new long[n1 + 1]; // A[l..mid]
		long[] R = new long[n2 + 1]; // A[mid+1..r]
		
		for (int i = 0; i < n1; ++i)
			L[i] = A[l + i];
		for (int i = 0; i < n2; ++i)
			R[i] = A[mid + i + 1];
		L[n1] = Long.MAX_VALUE;
		R[n2] = Long.MAX_VALUE;
		
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
	
	static long mergesort(long[] A, int l, int r) {
		
		if (l >= r)
			return 0;
		
		int mid = (l + r) / 2;
		long cnt = 0;
		cnt += mergesort(A, l, mid);
		cnt += mergesort(A, mid + 1, r);
		
		cnt += merge(A, l, mid, r);
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			long[] list = new long[N];
			
			for (int i = 0; i < N; ++i)
				list[i] = Long.parseLong(in.readLine());
			
			System.out.println(mergesort(list, 0, N - 1));
		}
		
		in.close();
		System.exit(0);
	}
}
