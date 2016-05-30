package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2635 (11588 - Image Coding) */
/* SUBMISSION: 09593704 */
/* SUBMISSION TIME: 2011-12-26 19:57:27 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11588_ImageCoding {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int[] freq = new int[26];
			String[] parts = in.readLine().split("[ ]+");
			int R = Integer.parseInt(parts[0]);
			int C = Integer.parseInt(parts[1]);
			int M = Integer.parseInt(parts[2]);
			int N = Integer.parseInt(parts[3]);
			
			char[][] image = new char[R][C];
			for (int i = 0; i < R; ++i)
				image[i] = in.readLine().toCharArray();
			
			for (int i = 0; i < R; ++i)
				for (int j = 0; j < C; ++j)
					++freq[image[i][j] - 'A'];
			
			int max = 0;
			for (int i = 0; i < 26; ++i)
				max = Math.max(max, freq[i]);
			
			int ans = 0;
			for (int i = 0; i < 26; ++i)
				if (freq[i] == max)
					ans += M * freq[i];
				else
					ans += N * freq[i];
			System.out.println("Case " + t + ": " + ans);
		}
		
		in.close();
		System.exit(0);
	}
}