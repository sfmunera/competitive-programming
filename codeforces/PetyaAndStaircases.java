package codeforces;

import java.util.*;

public class PetyaAndStaircases {
	
	static boolean can(int[] dirty, int n) {
		if (dirty.length == 0) return true;
		
		Arrays.sort(dirty);
		if (dirty[0] == 1 || dirty[dirty.length - 1] == n)
			return false;
		
		// look for three consecutive dirty stairs
		for (int i = 1; i < dirty.length - 1; ++i)
			if (dirty[i] - dirty[i - 1] == 1 && dirty[i + 1] - dirty[i] == 1)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] dirty = new int[m];
		
		for (int i = 0; i < m; ++i)
			dirty[i] = in.nextInt();
		
		System.out.println(can(dirty, n) ? "YES" : "NO");
		
		in.close();
		System.exit(0);
	}
}
