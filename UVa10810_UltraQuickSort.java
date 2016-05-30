package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1751 (10810 - Ultra-QuickSort) */
/* SUBMISSION: 10044773 */
/* SUBMISSION TIME: 2012-04-27 16:12:58 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10810_UltraQuickSort {
	
	static long merge(int[] A, int l, int mid, int r) {
		long cnt = 0;
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
	
	static long mergesort(int[] A, int l, int r) {
		
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
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			int[] A = new int[N];
			for (int i = 0; i < N; ++i)
				A[i] = Integer.parseInt(in.readLine());
			
			System.out.println(mergesort(A, 0, N - 1));
		}
		
		in.close();
		System.exit(0);
	}
}
