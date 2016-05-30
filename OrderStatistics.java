import java.util.*;

public class OrderStatistics {

	static void quicksort(int[] A, int l, int r) {
		if (l < r) {
			int pivot = partition(A, l, r);
			quicksort(A, l, pivot - 1);
			quicksort(A, pivot + 1, r);
		}
	}
	
	static void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
	
	static int partition(int[] A, int l, int r) {
		assert (l <= r);
		
		int i = l + 1;
		int j = r;
		while (i <= j) {
			if (A[i] > A[l]) {
				swap(A, i, j);
				--j;
			} else {
				++i;
			}
		}
		swap(A, l, j);
		return j;
	}
	
	static int kthElement(int[] A, int l, int r, int k) {
		if (l == r)
			return A[l];
		
		int pivot = partition(A, l, r);
		if (k < pivot)
			return kthElement(A, l, pivot - 1, k);
		else if (k > pivot)
			return kthElement(A, pivot + 1, r, k);
		else
			return A[pivot];
	}
	
	public static void main(String[] args) {
		int[] A = {0, 2, -10, 50, 2, -12, 3, 90};
		//quicksort(A, 0, A.length - 1);
		
		System.out.println(Arrays.toString(A));
		
		System.out.println(kthElement(A, 0, A.length - 1, 10));
	}
}
