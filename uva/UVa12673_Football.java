package uva;

import java.util.*;
import java.io.*;

public class UVa12673_Football {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		String line;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			int N = Integer.parseInt(stk.nextToken());
			int G = Integer.parseInt(stk.nextToken());
			
			int[] diffs = new int[N];
			
			int ans = 0;
			for (int i = 0; i < N; ++i) {
				stk = new StringTokenizer(in.readLine());
				int S = Integer.parseInt(stk.nextToken());
				int R = Integer.parseInt(stk.nextToken());
				
				diffs[i] = S - R;
			}
			
			Arrays.sort(diffs);
			for (int i = N - 1; i >= 0; --i) {
				if (diffs[i] > 0)
					ans += 3;
				else if (diffs[i] == 0) {
					if (G > 0) {
						--G;
						ans += 3;
					} else 
						++ans;
				} else {
					if (G > -diffs[i]) {
						G += diffs[i];
						--G;
						ans += 3;
					} else if (G == -diffs[i]) {
						G = 0;
						++ans;
					}
				}
			}
			System.out.println(ans);
		}
		in.close();
	}
}
