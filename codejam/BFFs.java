package codejam;

import java.util.*;
import java.io.*;

public class BFFs {
	static Scanner in;

	static int findCycle(int start, int[] friend) {
		Set<Integer> seen = new HashSet<Integer>();
		
		int cur = start;
		int count = 0;
		while (true) {
			if (seen.contains(cur)) break;
			seen.add(cur);
			cur = friend[cur];
			++count;
		}
		
		int ans = 0;
		if (cur == start) {
			ans = Math.max(ans, count);
		}
		return ans;
	}

	static int longestPathTo(int s, int[] friend) {
		int ans = 0;
		for (int i = 0; i < friend.length; ++i) {
			if (i == s || i == friend[s]) continue;
			Set<Integer> seen = new HashSet<Integer>();
			int cur = i;
			int count = 0;
			
			seen.add(s);
			seen.add(friend[s]);
			while (true) {
				if (seen.contains(cur)) break;
				seen.add(cur);
				cur = friend[cur];
				++count;
			}
			
			if (cur == s) {
				if (count > ans) {
					ans = count;
				}
			}
		}

		return 1 + ans;
	}
	
	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ": " + sb);
	}
	
	static void solve(int t) {
		StringBuilder sb = new StringBuilder();
		
		int N = in.nextInt();

		int[] friend = new int[N];
		for (int i = 0; i < N; ++i) {
			friend[i] = in.nextInt() - 1;
		}
		
		int ans = 0;
		// first check all cycles
		for (int i = 0; i < N; ++i) {
			ans = Math.max(ans, findCycle(i, friend));
		}
		// for every two-cycle (i, f[i]), find longestPath to i plus longestPath to f[i]
		int ans2 = 0;
		Set<Integer> seen = new HashSet<Integer>();
	    for (int i = 0; i < N; ++i) {
			if (friend[friend[i]] == i && !seen.contains(i) && !seen.contains(friend[i])) {
				seen.add(i);
				seen.add(friend[i]);
				ans2 += longestPathTo(i, friend) + longestPathTo(friend[i], friend);
			}
		}
		
		sb.append(Math.max(ans, ans2));
		print(sb, t);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("C-large-practice.in"));
	    System.setOut(new PrintStream("C-large-practice.out"));
		in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			solve(t);
		}
		
		in.close();
		System.exit(0);
	}
}