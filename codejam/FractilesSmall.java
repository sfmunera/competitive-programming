package codejam;

import java.util.*;
import java.io.*;

public class FractilesSmall {
	
	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ":" + sb);
	}

	static void solve(int K, int C, int S, int t) {
		StringBuilder sb = new StringBuilder();
		
		long KpowCminus1 = 1;
		for (int i = 0; i < C - 1; ++i) {
			KpowCminus1 *= (long) K;
		}
		
		for (int i = 0; i < K; ++i) {
			long pos = (long) i * KpowCminus1 + 1;
			sb.append(" ");
			sb.append(pos);
		}
		
		print(sb, t);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D-small-attempt0.in"));
	    System.setOut(new PrintStream("D-small-attempt0.out"));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int K = in.nextInt();
			int C = in.nextInt();
			int S = in.nextInt();
			
			assert S == K;
			
			solve(K, C, S, t);
		}
		
		in.close();
		System.exit(0);
	}
}
