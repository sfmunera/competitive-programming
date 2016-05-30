package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2661 (11614 - Etruscan Warriors Never Play Chess) */
/* SUBMISSION: 09153856 */
/* SUBMISSION TIME: 2011-08-15 17:56:40 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11614_EtruscanWarriorsNeverPlayChess {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			long N = Long.parseLong(in.readLine());
			
			long lo = 1;
			long hi = (long)1e9;
			
			while (lo < hi) {
				long mid = lo + (hi - lo) / 2;
				//System.out.println(mid);
				if (mid * (mid + 1) > 2 * N)
					hi = mid;
				else
					lo = mid + 1;
			}
			System.out.println(lo - 1);
		}
		
		in.close();
		System.exit(0);
	}
}