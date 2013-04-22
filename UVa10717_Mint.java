package uva;

import java.util.*;
import java.io.*;

public class UVa10717_Mint {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int T = Integer.parseInt(stk.nextToken());
			
			if (N == 0 && T == 0) break;
			
			int[] thickness = new int[N];
			for (int i = 0; i < N; ++i)
				thickness[i] = Integer.parseInt(in.readLine());
			for (int i = 0; i < T; ++i) {
				int t = Integer.parseInt(in.readLine());
				
				int ansless = Integer.MIN_VALUE;
				int ansmore = Integer.MAX_VALUE;
				for (int w = 0; w < N; ++w)
					for (int x = w + 1; x < N; ++x)
						for (int y = x + 1; y < N; ++y)
							for (int z = y + 1; z < N; ++z) {
								int lcm = lcm(thickness[w], lcm(thickness[x], 
										      lcm(thickness[y], thickness[z])));
								int less = (t / lcm) * lcm;
								int more = less == t ? t : less + lcm;
								ansless = Math.max(ansless, less);
								ansmore = Math.min(ansmore, more);
							}
				System.out.println(ansless + " " + ansmore);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
