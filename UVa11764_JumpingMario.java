package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2864 (11764 - Jumping Mario) */
/* SUBMISSION: 09933079 */
/* SUBMISSION TIME: 2012-03-30 15:01:56 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11764_JumpingMario {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(in.readLine());
			// Expresión regular para separar una línea por espacios
			String[] parts = in.readLine().split("[ ]+");
			int[] heights = new int[N];

			for (int i = 0; i < N; ++i)
				heights[i] = Integer.parseInt(parts[i]);

			int high = 0;
			int low = 0;
			for (int i = 1; i < N; ++i) {
				if (heights[i] > heights[i - 1])
					++high;
				if (heights[i] < heights[i - 1])
					++low;
			}
			System.out.printf("Case %d: %d %d\n", t, high, low);
		}

		in.close();
		System.exit(0);
	}
}