package uva;

import java.util.*;
import java.io.*;

public class UVa10520_DetermineIt {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		String line;
		
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			int n = Integer.parseInt(stk.nextToken());
			long[][] a = new long[n + 1][n + 1];
			
			a[n][1] = Integer.parseInt(stk.nextToken());
			for (int i = n; i > 0; --i)
				for (int j = 1; j <= n; ++j)
					if (i >= j) {
						for (int k = i + 1; k <= n; ++k)
							a[i][j] = Math.max(a[i][j], a[k][1] + a[k][j]);
						long s = 0;
						for (int k = 1; k < j; ++k)
							s = Math.max(s, a[i][k] + a[n][k]);
						a[i][j] += s;
					} else {
						for (int k = i; k < j; ++k)
							a[i][j] = Math.max(a[i][j], a[i][k] + a[k + 1][j]);
					}
			
			System.out.println(a[1][n]);
		}
		
		
		in.close();
		System.exit(0);
	}
}
