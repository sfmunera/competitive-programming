package facebook;

import java.io.*;
import java.util.*;

public class NewYearsResolution {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("B.in")));
		System.setOut(new PrintStream(new File("B.out")));
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int Gp = in.nextInt();
			int Gc = in.nextInt();
			int Gf = in.nextInt();
			
			int N = in.nextInt();
			int[] P = new int[N];
			int[] C = new int[N];
			int[] F = new int[N];
			for (int i = 0; i < N; ++i) {
				P[i] = in.nextInt();
				C[i] = in.nextInt();
				F[i] = in.nextInt();
			}
			
			boolean possible = false;
			for (int mask = 0; mask < (1 << N); ++mask) {
				int sumP = 0;
				int sumC = 0;
				int sumF = 0;
				
				for (int i = 0; i < N; ++i) {
					if ((mask & (1 << i)) > 0) {
						sumP += P[i];
						sumC += C[i];
						sumF += F[i];
					}
				}
				
				if (sumP == Gp && sumC == Gc && sumF == Gf) {
					possible = true;
					break;
				}
			}
			
			System.out.println("Case #" + t + ": " + (possible ? "yes" : "no"));
		}
		
		in.close();
	}
}
