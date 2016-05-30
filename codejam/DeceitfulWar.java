package codejam;

import java.io.*;
import java.util.*;

public class DeceitfulWar {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("C-small.in"));
		//System.setOut(new PrintStream("C-small.out"));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			double[] naomi = new double[N];
			double[] ken = new double[N];
			
			for (int i = 0; i < N; ++i)
				naomi[i] = in.nextDouble();
			for (int i = 0; i < N; ++i)
				ken[i] = in.nextDouble();
			
			Arrays.sort(naomi);
			Arrays.sort(ken);
			
			int ansWar = 0;
			int ansDeceit = 0;
			for (int i = 0; i < N; ++i)
				if (ken[N - 1] > naomi[N - i - 1]) {
					ansWar = i;
					break;
				}
			
			for (int i = 0; i < N; ++i)
				if (naomi[N - 1] > ken[N - i - 1]) {
					ansDeceit = i;
					break;
				}
			
			System.out.println("Case #" + t + ": " + ansDeceit + " " + ansWar);
			
			
		}
		
		in.close();
		System.exit(0);
	}
}
