package livearchive;

import java.util.*;

public class Sums {
	
	static void solve(int N) {
		/*
		 * N = a + (a + 1) + ... + (a + m - 1)
		 * N = a * m + (m - 1) * m / 2
		 * N = m * (a + (m - 1) / 2)
		 * 2N = m * (2a + m - 1)
		 * 2N = m^2 + 2am - 1
		 * a = (2N/m - m + 1)/2
		 * 
		 * m: number of consec. numbers
		 * a: first number in sequence
		 */
		
		if (N > 1 && N % 2 == 1) {
			System.out.println(N + " = " + N/2 + " + " + (N/2+1));
		} else {
			boolean possible = false;
			for (int m = 3; m * m <= 2 * N; ++m) {
				if ((2 * N) % m == 0) {
					int a2 = 2 * N / m - m + 1;
					if (a2 > 0 && a2 % 2 == 0) {
						possible = true;
						System.out.print(N + " = ");
						for (int i = 0; i < m; ++i) {
							if (i > 0) System.out.print(" + ");
							System.out.print(a2 / 2 + i);
						}
						System.out.println();
						break;
					}
				}
			}
			if (!possible) {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			solve(N);
		}
		
		in.close();
		System.exit(0);
	}
}
