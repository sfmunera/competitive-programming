package livearchive;

import java.util.*;

public class Frame {
	
	static boolean possible(int X, int Y, int A) {
		if (X % A == 0) {
			return (Y - 2) % A == 0;
		} else if (X % A == 1) {
			return (Y % A == 0 && (Y - 2) % A == 0) || 
				   ((Y - 1) % A == 0);
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int X = in.nextInt();
			int Y = in.nextInt();
			int N = in.nextInt();
			
			for (int i = 0; i < N; ++i) {
				int A = in.nextInt();
				System.out.println(possible(X, Y, A) || possible(Y, X, A) ? "YES" : "NO");
			}
		}
		
		in.close();
		System.exit(0);
	}
}
