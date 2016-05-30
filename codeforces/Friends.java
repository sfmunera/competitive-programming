package codeforces;

import java.util.*;

public class Friends {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean[][] acq = new boolean[5][5];
		
		int m = in.nextInt();
		for (int i = 0; i < m; ++i) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			
			acq[a][b] = acq[b][a] = true;
		}
		
		boolean ok = false;
		for (int i = 0; i < 5; ++i) {
			for (int j = i + 1; j < 5; ++j) {
				for (int k = j + 1; k < 5; ++k) {
					if ((acq[i][j] && acq[i][k] && acq[k][j]) || 
					    (!acq[i][j] && !acq[i][k] && !acq[k][j])) {
						ok = true;
					}
				}
			}
		}
		
		System.out.println(ok ? "WIN" : "FAIL");
		
		in.close();
		System.exit(0);
	}
}
