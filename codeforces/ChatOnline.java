package codeforces;

import java.util.*;

public class ChatOnline {
	
	static class Pair {
		int l, r;
		Pair(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}
	
	static boolean overlap(Pair p1, Pair p2) {
		return !(p1.r < p2.l || p2.r < p1.l);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int p = in.nextInt();
		int q = in.nextInt();
		int l = in.nextInt();
		int r = in.nextInt();
		
		Pair[] zPairs = new Pair[p];
		Pair[] xPairs = new Pair[q];
		
		for (int i = 0; i < p; ++i)
			zPairs[i] = new Pair(in.nextInt(), in.nextInt());
		for (int i = 0; i < q; ++i)
			xPairs[i] = new Pair(in.nextInt(), in.nextInt());
		
		int ans = 0;
		for (int t = l; t <= r; ++t) {
			boolean doOverlap = false;
			for (int i = 0; i < p && !doOverlap; ++i)
				for (int j = 0; j < q && !doOverlap; ++j)
					if (overlap(zPairs[i], new Pair(xPairs[j].l + t, xPairs[j].r + t)))
						doOverlap = true;
			if (doOverlap)
				++ans;
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
