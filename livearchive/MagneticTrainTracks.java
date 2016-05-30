package livearchive;

import java.util.*;
import java.io.*;

public class MagneticTrainTracks {
	
	static int dist2(int[] x, int[] y, int i, int j) {
		int dx = x[i] - x[j];
		int dy = y[i] - y[j];
		return dx * dx + dy * dy;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0) break;
			
			int[] x = new int[n];
			int[] y = new int[n];
			int[][] dist2 = new int[n][n];
			
			for (int i = 0; i < n; ++i) {
				StringTokenizer stk = new StringTokenizer(in.readLine());
				x[i] = Integer.parseInt(stk.nextToken());
				y[i] = Integer.parseInt(stk.nextToken());
			}
			
			for (int i = 0; i < n; ++i)
				for (int j = i; j < n; ++j)
					dist2[i][j] = dist2[j][i] = dist2(x, y, i, j);
			
			long ans = 0;
			for (int i = 0; i < n; ++i)
				for (int j = i + 1; j < n; ++j) {
					int a = dist2[i][j];
					for (int k = j + 1; k < n; ++k) {
						int b = dist2[i][k];
						int c = dist2[j][k];
						if (a <= b + c && b <= a + c && c <= a + b)
							++ans;
					}
				}
			sb.append("Scenario " + t + ":\n");
			sb.append("There are " + ans + " sites for making valid tracks\n");
			++t;
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
