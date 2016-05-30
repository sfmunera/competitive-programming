package eafit;

import java.io.*;

public class Nop {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] code = in.readLine().toCharArray();
		
		int k = 0;
		int ans = 0;
		for (char c : code) {
			if (Character.isUpperCase(c)) {
				if (k % 4 != 0) {
					int i = k;
					for (; i % 4 != 0; ++i);
					ans += i - k;
					k += i - k;
				}
			}
			++k;
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
