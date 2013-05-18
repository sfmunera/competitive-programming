package uva;

import java.util.*;

public class UVa10327_FlipSort {
	
	static final int INF = (int)(1e9);
	
	static int countInversions(int[] seq, int l, int r) {
		if (l >= r) return 0;
		int mid = (l + r) / 2;
		
		int ans = 0;
		ans += countInversions(seq, l, mid);
		ans += countInversions(seq, mid + 1, r);
		ans += merge(seq, l, mid, r);
		
		return ans;
	}
	
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
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextInt()) {
			int N = in.nextInt();
			
			int[] seq = new int[N];
			for (int i = 0; i < N; ++i)
				seq[i] = in.nextInt();
			
			System.out.print("Minimum exchange operations : ");
			System.out.println(countInversions(seq, 0, N - 1));
		}
		
		in.close();
		System.exit(0);
	}
}
