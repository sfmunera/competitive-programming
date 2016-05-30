package bapc;

import java.util.*;

public class CheatingKnight {
	
	static final double EPSILON = 1e-9;
	
	static void solve(int D, int X, int Y) {
		int ans = (int) Math.ceil(Math.sqrt(X * X + Y * Y) / Math.sqrt(D) - EPSILON);
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int D = in.nextInt();
			int X = in.nextInt();
			int Y = in.nextInt();
			
			solve(D, X, Y);
		}
		
		in.close();
		System.exit(0);
	}
}
