package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3972 (12527 - Different Digits) */
/* SUBMISSION: 10873217 */
/* SUBMISSION TIME: 2012-11-11 23:52:19 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa12527_DifferentDigits {
	
	static boolean hasRepeated(int n) {
		boolean[] repeat = new boolean[10];
		while (n > 0) {
			int d = n % 10;
			if (repeat[d])
				return true;
			repeat[d] = true;
			n /= 10;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int M = Integer.parseInt(parts[1]);
			
			int ans = 0;
			for (int i = N; i <= M; ++i)
				if (!hasRepeated(i))
					++ans;
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}