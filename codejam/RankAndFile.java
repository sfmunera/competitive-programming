package codejam;

import java.util.*;
import java.io.*;

public class RankAndFile {
	
	static Scanner in;
	
	static final int MAX = 2501;
	
	static void print(StringBuilder sb, int t) {
		System.out.println("Case #" + t + ":" + sb);
	}
	
	static void solve(int t) {
		StringBuilder sb = new StringBuilder();
		
		int N = in.nextInt();
		int[] count = new int[MAX];
		for (int i = 0; i < 2 * N - 1; ++i) {
			for (int j = 0; j < N; ++j) {
				int height = in.nextInt();
				assert height >= 1 && height < MAX;
				++count[height];
			}
		}
		
		List<Integer> missing = new ArrayList<Integer>();
		for (int i = 0; i < MAX; ++i) {
			if (count[i] % 2 == 1) {
				missing.add(i);
			}
		}
		assert missing.size() == N;
		
		Collections.sort(missing);
		
		for (int height : missing) {
			sb.append(" ");
			sb.append(height);
		}
		
		print(sb, t);
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("B-large-practice.in"));
	    System.setOut(new PrintStream("B-large-practice.out"));
		in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			solve(t);
		}
		
		in.close();
		System.exit(0);
	}
}