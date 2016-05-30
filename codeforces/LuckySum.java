package codeforces;

import java.io.*;
import java.util.*;

public class LuckySum {
	
	static long next(long x) {
		char[] s = String.valueOf(x).toCharArray();
		int len = s.length;

		boolean found = false;
		for (int i = len - 1; i >= 0; --i)
			if (s[i] == '7') s[i] = '4';
			else {
				s[i] = '7';
				found = true;
				break;
			}
		String ans = String.valueOf(s);
		if (!found)
			ans = '4' + ans;
		
		return Long.parseLong(ans);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		long l = Long.parseLong(stk.nextToken());
		long r = Long.parseLong(stk.nextToken());
		
		long x = 4;
		long prev = l - 1;
		long ans = 0;
		while (true) {
			if (x > r) {
				ans += x * (r - prev);
				break;
			}
			if (x >= prev) {
				ans += x * (x - prev);
				prev = x;
			}
			x = next(x);
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
