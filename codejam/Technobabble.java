package codejam;

import java.util.*;
import java.io.*;

public class Technobabble {
	static final String FILENAME = "Cs";
	static Scanner in;
	static StringBuilder sb;
	
	static class Pair {
		String f, s;
		Pair(String f, String s) {
			this.f = f;
			this.s = s;
		}
	}

	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ": " + sb);
	}
	
	static void solve(int t) {
		int N = in.nextInt();
		Map<String, Integer> first = new HashMap<String, Integer>();
		Map<String, Integer> second = new HashMap<String, Integer>();
		Pair[] pairs = new Pair[N];

		for (int i = 0; i < N; ++i) {
			String f = in.next();
			String s = in.next();
			
			pairs[i] = new Pair(f, s);
			
			if (!first.containsKey(f)) {
				first.put(f, 0);
			}
			if (!second.containsKey(s)) {
				second.put(s, 0);
			}
			first.put(f, first.get(f) + 1);
			second.put(s, second.get(s) + 1);
		}
		
		int count = 0;
		for (int i = 0; i < N; ++i) {
			if (first.get(pairs[i].f) == 1 || second.get(pairs[i].s) == 1) {
				++count;
			}
		}
		int numFirst = first.keySet().size();
		int numSecond = second.keySet().size();
		
		sb.append(N - Math.max(Math.max(numFirst, numSecond), count));
		
		print(sb, t);
	}
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream(FILENAME + ".in"));
	    //System.setOut(new PrintStream(FILENAME + ".out"));
		in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			sb = new StringBuilder();
			solve(t);
		}
		
		in.close();
		System.exit(0);
	}
}