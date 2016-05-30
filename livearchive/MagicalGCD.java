package livearchive;

import java.util.*;
import java.io.*;

public class MagicalGCD {
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static void solve(int n, long[] seq) {
		
		Map<Integer, Long> gcds = new TreeMap<Integer, Long>();
		long max = 0;
		
		for (int i = 0; i < n; ++i) {
			gcds.put(i, seq[i]);
			max = Math.max(max, seq[i]);
			
			Map<Integer, Long> tmp = new TreeMap<Integer, Long>();
			for (int pos : gcds.keySet()) {
				long newgcd = gcd(seq[i], gcds.get(pos));
				
				if (!tmp.values().contains(newgcd))
					tmp.put(pos, newgcd);
				max = Math.max(max, newgcd * (i - pos + 1));
			}
			gcds = new TreeMap<Integer, Long>(tmp);
		}
		
		System.out.println(max);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(in.readLine());
			long[] seq = new long[n];
			
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; ++i) {
				seq[i] = Long.parseLong(stk.nextToken());
			}
			solve(n, seq);
		}
		
		in.close();
		System.exit(0);
	}
}
