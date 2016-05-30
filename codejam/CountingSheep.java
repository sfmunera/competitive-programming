package codejam;

import java.util.*;
import java.io.*;

public class CountingSheep {
	
	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ": " + sb);
	}
	
	static void solve(int N, int t) {
		if (N == 0) {
			print(new StringBuilder().append("INSOMNIA"), t);
			return;
		}
		boolean[] seen = new boolean[10];
		int yetToSee = 10;
		
		long cur = (long) N;
		while (yetToSee > 0) {
			long x = cur;
			while (x > 0) {
				int digit = (int) (x % 10);
				x /= 10;
				
				if (!seen[digit]) {
					seen[digit] = true;
					--yetToSee;
				}
			}
			
			cur += N;
		}
		
		print(new StringBuilder().append(cur - N), t);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("A-large.in"));
	    System.setOut(new PrintStream("A-large.out"));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			solve(N, t);
		}
		
		in.close();
		System.exit(0);
	}
}
