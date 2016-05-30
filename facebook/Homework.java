package facebook;

import java.io.*;
import java.util.*;

public class Homework {
	
	static final int MAX_NUM = (int) 1e7 + 1;
	
	static int numDifferentPrimeFactors(int x) {
		int cnt = 0;
		for (int p = 2; p <= x / p; ++p) {
			if (x % p == 0) {
				++cnt;
				while (x % p == 0)
					x /= p;
			}
		}
		if (x > 1)
			++cnt;
		
		return cnt;
	}
	
	static long[] fillPrimacity() {
		long[] primacity = new long[MAX_NUM];
		for (int i = 2; i < MAX_NUM; ++i) {
			primacity[i] = numDifferentPrimeFactors(i);
		}
		return primacity;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("A.in")));
		System.setOut(new PrintStream(new File("A.out")));
		
		long[] primacity = fillPrimacity();
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int A = in.nextInt();
			int B = in.nextInt();
			int K = in.nextInt();
			
			int ans = 0;
			for (int i = A; i <= B; ++i) {
				if (primacity[i] == K)
					++ans;
			}
			
			System.out.println("Case #" + t + ": " + ans);
		}
		
		in.close();
	}
}
