package uva;

import java.io.*;

public class UVa11150_Cola {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int n = Integer.parseInt(line);

			int ans = n;
			while (n >= 2) {
				int d = n / 3;
				int r = n % 3;
				ans += d;
				n = d + r;
				if (n == 2)
					++n;
			}
			System.out.println(ans);
		}

		in.close();
		System.exit(0);
	}
}
