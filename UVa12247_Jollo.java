package uva;

import java.util.*;
import java.io.*;

public class UVa12247_Jollo {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		String line;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			int X = Integer.parseInt(stk.nextToken());
			int Y = Integer.parseInt(stk.nextToken());
			if (A == 0 && B == 0 && C == 0 && X == 0 && Y == 0) break;
			
			int ans = -1;
			for (int x = 1; x <= 52; ++x) {
				if (x == A || x == B || x == C || x == X || x == Y) continue;
				// 2 are greater than all 3
				int max = Math.max(A, Math.max(B, C));
				if ((X > max && Y > max) || (X > max && x > max) || (Y > max && x > max)) {
					ans = x;
					break;
				}
				// 3 are greater that 2
				int min = Math.min(x, Math.min(X, Y));
				if ((A < min && B < min) || (A < min && C < min) || (B < min && C < min)) {
					ans = x;
					break;
				}
			}
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
