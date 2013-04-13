package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3370 (12218 - An Industrial Spy) */
/* SUBMISSION: 09291233 */
/* SUBMISSION TIME: 2011-09-23 02:20:13 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa12218_AnIndustrialSpy {
	
	static boolean nextPermutation(char[] a) {
		int n = a.length;
		
		int k = -1;
		for (int i = 0; i < n - 1; ++i)
			if (a[i] < a[i + 1]) {
				k = i;
			}
		if (k == -1)
			return false;
		int l = 0;
		for (int i = k + 1; i < n; ++i)
			if (a[i] > a[k])
				l = i;
		char t = a[k];
		a[k] = a[l];
		a[l] = t;
		
		for (int i = k + 1; i < (n + k + 1) / 2; ++i) {
			t = a[i];
			a[i] = a[n + k - i];
			a[n + k - i] = t;
		}
		
		return true;
	}
	
	static boolean isPrime(int n) {
		if (n == 2)
			return true;
		if (n % 2 == 0 || n == 1)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
			
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = Integer.parseInt(in.next());
		for (int t = 1; t <= T; ++t) {
			String N = in.next();
			
			Set<Integer> set = new HashSet<Integer>();
			char[] a = N.toCharArray();
			Arrays.sort(a);
			
			while (true) {
				String Nc = String.valueOf(a);
				//System.out.println(Nc);
				for (int i = 0; i < Nc.length(); ++i)
					for (int j = i + 1; j <= Nc.length(); ++j) {
						String tmp = Nc.substring(i, j);
						//System.out.println(tmp);
						if (isPrime(Integer.parseInt(tmp)))
							set.add(Integer.parseInt(tmp));
					}
				
				if (!nextPermutation(a))
					break;
			}
			System.out.println(set.size());
		}
	}
}