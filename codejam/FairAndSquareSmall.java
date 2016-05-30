package codejam;

import java.io.*;
import java.util.*;

public class FairAndSquareSmall {
	
	static Map<Integer, Integer> sqr;
	
	static boolean isPalindrome(int x) {
		String str = String.valueOf(x);
		int n = str.length();
		for (int i = 0; i < n / 2; ++i)
			if (str.charAt(i) != str.charAt(n - 1 - i))
				return false;
		return true;
	}
	
	static boolean isFairAndSquare(int x) {
		if (!sqr.containsKey(x)) return false;
		if (!isPalindrome(x)) return false;
		if (!isPalindrome(sqr.get(x))) return false;
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("C-small-attempt0.in"));
		System.setOut(new PrintStream("C_out.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		sqr = new HashMap<Integer, Integer>();
		for (int i = 0; i < 101; ++i)
			sqr.put(i * i, i);
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			stk = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			
			int cnt = 0;
			for (int x = A; x <= B; ++x)
				if (isFairAndSquare(x))
					++cnt;
			
			System.out.println("Case #" + t + ": " + cnt);
		}
		
		in.close();
		System.exit(0);
	}
}
