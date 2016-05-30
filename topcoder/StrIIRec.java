package topcoder;


import java.util.*;

public class StrIIRec {
	
	static void swap(char[] c, int i, int j) {
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static int merge(char[] A, int l, int mid, int r) {
		int cnt = 0;
		int n1 = mid - l + 1;
		int n2 = r - mid;
		
		char[] L = new char[n1 + 1]; // A[l..mid]
		char[] R = new char[n2 + 1]; // A[mid+1..r]
		
		for (int i = 0; i < n1; ++i)
			L[i] = A[l + i];
		for (int i = 0; i < n2; ++i)
			R[i] = A[mid + i + 1];
		L[n1] = Character.MAX_VALUE;
		R[n2] = Character.MAX_VALUE;
		
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
	
	static int mergesort(char[] A, int l, int r) {
		
		if (l >= r)
			return 0;
		
		int mid = (l + r) / 2;
		int cnt = 0;
		cnt += mergesort(A, l, mid);
		cnt += mergesort(A, mid + 1, r);
		
		cnt += merge(A, l, mid, r);
		
		return cnt;
	}
	
    public String recovstr(int n, int minInv, String minStr) {
    	int m = minStr.length();
    	String abc = "abcdefghijklmnopqrstuvwxyz";
    	boolean[] taken = new boolean[26];
    	for (int i = 0; i < m; ++i)
    		taken[minStr.charAt(i) - 'a'] = true;
    	
    	int j = 0;
    	while (minStr.length() < n) {
    		if (!taken[abc.charAt(j) - 'a'])
    			minStr += abc.charAt(j);
    		++j;
    	}
    	
        char[] str = minStr.toCharArray();
        
        String res = "";

        char[] tmp = str.clone();
        int inv = mergesort(tmp, 0, n - 1);
        
        while (true) {
        	if (inv >= minInv) {
        		res = String.valueOf(str);
        		break;
        	}
        	for (int i = n - 1; i > 0; --i) {
        		if (str[i] > str[i - 1]) {
        			int sw = n - 1;
        			for (int l = i; l < n; ++l) {
        				if (str[i - 1] < str[l])
        					sw = l;
        			}
        			swap(str, i - 1, sw);
        			break;
        		}
        	}
        	tmp = str.clone();
	        inv = mergesort(tmp, 0, n - 1);
        }
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(StrIIRec.class, "test.*");
    }

	public void test0() {
		RETester.eq(recovstr(2, 1, "ab"), "ba");
	}

	public void test1() {
		RETester.eq(recovstr(9, 1, "efcdgab"), "efcdgabhi");
	}

	public void test2() {
		RETester.eq(recovstr(11, 55, "debgikjfc"), "kjihgfedcba");
	}

	public void test3() {
		RETester.eq(recovstr(15, 0, "e"), "eabcdfghijklmno");
	}

	public void test4() {
		RETester.eq(recovstr(9, 20, "fcdebiha"), "fcdehigba");
	}

// END CUT HERE
}
