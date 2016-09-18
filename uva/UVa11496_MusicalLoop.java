package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2491 (11496 - Musical Loop) */
/* SUBMISSION: 09587433 */
/* SUBMISSION TIME: 2011-12-23 20:02:12 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11496_MusicalLoop {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			
			if (N == 0)
				break;
			
			int[] H = new int[N];
			
			String[] parts = in.readLine().split("[ ]+");
			for (int i = 0; i < N; ++i)
				H[i] = Integer.parseInt(parts[i]);
			
			int cnt = 0;
			if ((H[0] < H[N - 1] && H[0] < H[1]) ||
				(H[0] > H[N - 1] && H[0] > H[1]))
					++cnt;
			for (int i = 1; i < N; ++i)
				if ((H[i] < H[i - 1] && H[i] < H[(i + 1) % N]) ||
					(H[i] > H[i - 1] && H[i] > H[(i + 1) % N]))
					++cnt;
			System.out.println(cnt);
		}
		
		in.close();
		System.exit(0);
	}
}