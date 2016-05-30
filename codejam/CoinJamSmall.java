package codejam;

import java.util.*;
import java.io.*;

public class CoinJamSmall {
	
	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ":");
		System.out.print(sb);
	}
	
	static long convert(String number, long base) {
		long pow = 1;
		long converted = 0;
		for (int i = number.length() - 1; i >= 0; --i) {
			converted += pow * (number.charAt(i) - '0');
			pow *= base;
		}
		
		return converted;
	}
	
	static long findDivisor(long x) {
		for (long p = 2; p <= x / p; ++p) {
			if (x % p == 0) return p;
		}
		
		return -1;
	}
	
	static boolean solveNumber(String number, StringBuilder sb) {
		List<Long> divisors = new ArrayList<Long>();
		for (long base = 2; base <= 10; ++base) {
			long converted = convert(number, base);
			long div = findDivisor(converted);
			
			if (div < 0) return false;
			divisors.add(div);
		}
		sb.append(number);
		for (long d : divisors) {
			sb.append(" ");
			sb.append(d);
		}
		sb.append("\n");
		
		return true;
	}

	static void solve(int N, int J, int t) {
		StringBuilder sb = new StringBuilder();
		
		for (long mask = 0; mask < (1 << (N - 2)) && J > 0; ++mask) {
			long number = (mask << 1) + 1 + (1 << (N - 1));
			if (solveNumber(Long.toString(number, 2), sb))
				--J;
		}
		
		print(sb, t);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("C-small-attempt0.in"));
	    System.setOut(new PrintStream("C-small-attempt0.out"));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			int J = in.nextInt();

			solve(N, J, t);
		}
		
		in.close();
		System.exit(0);
	}
}
