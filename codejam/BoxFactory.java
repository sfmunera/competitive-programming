package codejam;

import java.util.*;
import java.io.*;

public class BoxFactory {
	
	static int N;
	static int M;
	
	static long[] nBoxes;
	static int[] tBoxes;
	static long[] nToys;
	static int[] tToys;
	
	static long solve(int i, int j) {
		if (i >= N || j >= M)
			return 0;

		long diff = 0;
		if (tBoxes[i] == tToys[j])
			diff = Math.min(nBoxes[i], nToys[j]);
		nBoxes[i] -= diff;
		nToys[j] -= diff;
		
		long res1 = solve(i + 1, j);
		long res2 = solve(i, j + 1);
		long res3 = solve(i + 1, j + 1);
		
		nBoxes[i] += diff;
		nToys[j] += diff;
		
		return diff + Math.max(res1, Math.max(res2, res3));
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("C-small-attempt0.in"));
		System.setOut(new PrintStream("out.txt"));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			M = Integer.parseInt(parts[1]);
			
			nBoxes = new long[N];
			tBoxes = new int[N];
			nToys = new long[M];
			tToys = new int[M];
			
			parts = in.readLine().split("[ ]+");
			for (int i = 0; i < 2 * N; i += 2) {
				nBoxes[i / 2] = Long.parseLong(parts[i]);
				tBoxes[i / 2] = Integer.parseInt(parts[i + 1]);
			}
			
			parts = in.readLine().split("[ ]+");
			for (int i = 0; i < 2 * M; i += 2) {
				nToys[i / 2] = Long.parseLong(parts[i]);
				tToys[i / 2] = Integer.parseInt(parts[i + 1]);
			}
			
			long res = solve(0, 0);
			
			System.out.println("Case #" + t + ": " + res);
		}
		
		in.close();
		System.exit(0);
	}
}
