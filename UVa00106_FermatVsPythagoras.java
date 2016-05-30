package uva;

import java.io.*;

public class UVa00106_FermatVsPythagoras {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			boolean[] seen = new boolean[N + 1];
			
			// a = m^2-n^2; b = 2mn; c = m^2+n^2 (Euclid's formula)
			int ans1 = 0;
			int ans2 = 0;
			for (int m = 2; m * m <= N; ++m)
				for (int n = 1; m * m + n * n <= N; ++n)
					if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
						++ans1;
						for (int k = 1; k * (m * m + n * n) <= N; ++k) {
							seen[k * (m * m - n * n)] = true;
							seen[k * (2 * m * n)] = true;
							seen[k * (m * m + n * n)] = true;
						}
						
					}
			for (int i = 1; i <= N; ++i)
				if (!seen[i])
					++ans2;
			
			System.out.println(ans1 + " " + ans2);
		}
		
		in.close();
		System.exit(0);
	}
}
