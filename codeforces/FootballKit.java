package codeforces;

import java.util.*;

public class FootballKit {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		Map<Integer, Integer> countHome = new HashMap<Integer, Integer>();
		int[] away = new int[n];
		for (int i = 0; i < n; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			away[i] = y;
			
			if (!countHome.containsKey(x))
				countHome.put(x, 0);
			countHome.put(x, countHome.get(x) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			int sameAway = countHome.containsKey(away[i]) ? countHome.get(away[i]) : 0;
			int cntHome = n - 1 + sameAway;
			int cntAway = n - 1 - sameAway;

			sb.append(cntHome + " " + cntAway + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
