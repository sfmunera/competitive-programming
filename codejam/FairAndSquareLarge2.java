package codejam;

import java.io.*;
import java.util.*;
import java.math.*;

public class FairAndSquareLarge2 {
	
	static boolean isPalindrome(String str) {
		int n = str.length();
		for (int i = 0; i < n / 2; ++i)
			if (str.charAt(i) != str.charAt(n - 1 - i))
				return false;
		return true;
	}
	
	static String square(String x) {
		BigInteger b = new BigInteger(x);
		BigInteger sqr = b.multiply(b);
		
		return sqr.toString();
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("C-large-2.in"));
		System.setOut(new PrintStream("C_out_large2.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", "0");
		map.put("1", "1");
		map.put("2", "4");
		map.put("11", "121");
		map.put("22", "484");
		for (int len = 3; len < 55; ++len) {
			for (int i = 1; i <= 2; ++i) {
				Map<String, String> toAdd = new HashMap<String, String>();
				for (String x : map.keySet()) {
					if (x.length() <= len - 2 && (len - x.length()) % 2 == 0) {
						int zeros = (len - x.length() - 2) / 2;
						String y = "" + i;
						for (int k = 0; k < zeros; ++k)
							y += "0";
						y += x;
						for (int k = 0; k < zeros; ++k)
							y += "0";
						y += "" + i;
						String sqr = square(y);
						if (isPalindrome(sqr) && sqr.length() <= 100)
							toAdd.put(y, sqr);
					}
				}
				String y = "" + i;
				for (int k = 0; k < len - 2; ++k)
					y += "0";
				y += "" + i;
				String sqr = square(y);
				if (isPalindrome(sqr) && sqr.length() <= 100)
					toAdd.put(y, sqr);
				
				for (String x : toAdd.keySet())
					map.put(x, toAdd.get(x));
			}
		}
		map.put("3", "9");

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			stk = new StringTokenizer(in.readLine());
			String A = stk.nextToken();
			String B = stk.nextToken();
			BigInteger bA = new BigInteger(A);
			BigInteger bB = new BigInteger(B);
			
			int cnt = 0;
			for (String x : map.keySet()) {
				String sqr = map.get(x);
				BigInteger bs = new BigInteger(sqr);
				
				if (sqr.length() >= A.length() && sqr.length() <= B.length())
					if (bs.compareTo(bA) >= 0 && bs.compareTo(bB) <= 0)
						++cnt;
			}
			
			System.out.println("Case #" + t + ": " + cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
