package codeforces;

import java.util.*;

public class VasyasCalendar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int d = in.nextInt();
		int n = in.nextInt();

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			int a = in.nextInt();
			if (i < n - 1)
				ans += d - a;
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
