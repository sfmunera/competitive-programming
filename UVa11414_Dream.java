package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2409 (11414 - Dream) */
/* SUBMISSION: 10246636 */
/* SUBMISSION TIME: 2012-06-21 22:04:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11414_Dream {
	
	static boolean isGraph(int[] degree) {
		int N = degree.length;
		
		int nodds = 0;
		for (int i = 0; i < N; ++i) {
			if (degree[i] > N - 1)
				return false;
			if (degree[i] % 2 == 1)
				++nodds;
		}
		if (nodds % 2 == 1)
			return false;
		
		for (int j = 0; j < N; ++j) {
			boolean allzeros = true;
			for (int i = 0; i < N; ++i) {
				if (degree[i] < 0)
					return false;
				if (degree[i] != 0)
					allzeros = false;
			}
			if (allzeros)
				return true;

			Arrays.sort(degree);
			int d = degree[N - 1];
			degree[N - 1] = 0;
			for (int k = N - 2; k >= 0 && d > 0; --k) {
				--d;
				--degree[k];
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int[] degree = new int[N];
			
			for (int i = 0; i < N; ++i)
				degree[i] = Integer.parseInt(parts[i + 1]);
			
			System.out.println(isGraph(degree) ? "Yes" : "No");
		}
		
		in.close();
		System.exit(0);
	}
}