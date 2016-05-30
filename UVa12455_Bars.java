package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3886 (12455 - Bars) */
/* SUBMISSION: 10124443 */
/* SUBMISSION TIME: 2012-05-17 15:15:16 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12455_Bars {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int p = Integer.parseInt(in.readLine());
			int[] bars = new int[p];
			
			String[] parts = in.readLine().split("[ ]+");
			for (int i = 0; i < p; ++i)
				bars[i] = Integer.parseInt(parts[i]);
			
			boolean can = false;
			for (int mask = 0; mask < (1 << p); ++mask) {
				int sum = 0;
				for (int i = 0; i < p; ++i)
					if ((mask & (1 << i)) != 0)
						sum += bars[i];
				if (sum == n) {
					can = true;
					break;
				}
			}
			System.out.println(can ? "YES" : "NO");
		}
		
		in.close();
		System.exit(0);
	}
}
