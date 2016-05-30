package codejam;

import java.util.*;
import java.io.*;

public class Osmos {
	
	static int N;
	static long A;
	static long[] motes;
	
	static long go(int i, long curA) {
		if (i == N) return 0;
		int cnt = 0;
		while (curA <= motes[i]) {
			if (curA == 1)
				return N - i;
			++cnt;
			curA += curA - 1;
		}
		int rem = Integer.MAX_VALUE;
		if (cnt > 0) rem = N - i;
		return Math.min(rem, cnt + go(i + 1, curA + motes[i]));
		
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("A-large.in"));
		System.setOut(new PrintStream("outA.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			long ans = 0;
			stk = new StringTokenizer(in.readLine());
			A = Long.parseLong(stk.nextToken());
			N = Integer.parseInt(stk.nextToken());
			
			motes = new long[N];
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; ++i)
				motes[i] = Long.parseLong(stk.nextToken());
			
			Arrays.sort(motes);
			
			ans = go(0, A);	
			
			System.out.println("Case #" + t + ": " + ans);
		}
		
		in.close();
		System.exit(0);
	}
}
