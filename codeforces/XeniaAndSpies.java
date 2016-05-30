package codeforces;

import java.util.*;

public class XeniaAndSpies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int s = in.nextInt() - 1;
		int f = in.nextInt() - 1;
		
		int dir = s < f ? 1 : -1;
		
		StringBuilder sb = new StringBuilder();
		int prevT = 0;
		int remaining = Math.abs(s - f);
		for (int i = 0; i < m; ++i) {
			int t = in.nextInt();
			int l = in.nextInt() - 1;
			int r = in.nextInt() - 1;
			
			if (remaining > 0) {
				int timePassed = t - prevT - 1;
				
				if (timePassed > 0) {
					// check if time passed is not enough to reach destination
					int distWalked = Math.min(timePassed, Math.abs(s - f));
					sb.append(String.format(String.format("%%%ds", distWalked), " ").replace(" ", dir == 1 ? "R" : "L"));
					s += dir * distWalked;
					remaining -= distWalked;
					if (s == f) continue;
				}
				// now process current watch
				if ((s >= l && s <= r) || (s + dir >= l && s + dir <= r)) {
					sb.append("X");
				} else {
					sb.append(dir == 1 ? "R" : "L");
					s += dir;
					--remaining;
				}
			}
			prevT = t;
		}
		if (remaining > 0) {
			sb.append(String.format(String.format("%%%ds", remaining), " ").replace(" ", dir == 1 ? "R" : "L"));
		}
		
		System.out.println(sb);
		
		in.close();
		System.exit(0);
	}
}
