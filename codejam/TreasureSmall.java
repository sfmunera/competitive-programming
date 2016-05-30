package codejam;

import java.util.*;
import java.io.*;

public class TreasureSmall {
	
	static int N;
	static int[] keys, types;
	static ArrayList<ArrayList<Integer>> g;
	static String ans;
	static boolean done;
	static boolean[] seen;
	
	static void go(int used, String path) {
		if (seen[used]) return;
		seen[used] = true;
		if (done) return;
		if (used == (1 << N) - 1) {
			ans = path;
			done = true;
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			if ((used & (1 << i)) == 0 && keys[types[i]] > 0) {
				--keys[types[i]];
				for (int k : g.get(i))
					++keys[k];
				
				go(used | (1 << i), path + " " + (i + 1));
				
				++keys[types[i]];
				for (int k : g.get(i))
					--keys[k];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D-small-practice.in"));
		System.setOut(new PrintStream("D_out.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			stk = new StringTokenizer(in.readLine());
			int K = Integer.parseInt(stk.nextToken());
			N = Integer.parseInt(stk.nextToken());
			
			keys = new int[205];
			
			stk = new StringTokenizer(in.readLine());
			for (int i = 0; i < K; ++i)
				++keys[Integer.parseInt(stk.nextToken())];
			
			types = new int[N];
			g = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < N; ++i) {
				g.add(new ArrayList<Integer>());
				stk = new StringTokenizer(in.readLine());
				int type = Integer.parseInt(stk.nextToken());
				types[i] = type;
				
				int k = Integer.parseInt(stk.nextToken());
				for (int j = 0; j < k; ++j) {
					int to = Integer.parseInt(stk.nextToken());
					g.get(i).add(to);
				}
			}
			
			done = false;
			ans = "";
			seen = new boolean[1 << N];
			go(0, "");
			
			if (!done) ans = " IMPOSSIBLE";
			System.out.println("Case #" + t + ":" + ans);
		}
		
		in.close();
		System.exit(0);
	}
}
