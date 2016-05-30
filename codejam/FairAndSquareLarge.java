package codejam;

import java.io.*;
import java.util.*;

public class FairAndSquareLarge {
	
	static boolean isPalindrome(long x) {
		String str = String.valueOf(x);
		int n = str.length();
		for (int i = 0; i < n / 2; ++i)
			if (str.charAt(i) != str.charAt(n - 1 - i))
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("C-large-1.in"));
		System.setOut(new PrintStream("C_out_large1.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		Set<Long> set = new HashSet<Long>();
		for (long x = 0; x * x <= 100000000000000L; ++x) {
			if (!isPalindrome(x)) continue;
			long sqr = x * x;
			if (!isPalindrome(sqr)) continue;
			set.add(sqr);
		}

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			stk = new StringTokenizer(in.readLine());
			long A = Long.parseLong(stk.nextToken());
			long B = Long.parseLong(stk.nextToken());
			
			int cnt = 0;
			for (long x : set) {
				if (x >= A && x <= B)
					++cnt;
			}
			
			System.out.println("Case #" + t + ": " + cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
