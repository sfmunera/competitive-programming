package codeforces;

import java.io.*;

public class Game {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String stripe = in.readLine();
		
		String pattern1 = "";
		String pattern2 = "";
		for (int i = 0; i < N; ++i) {
			pattern1 += i % 2 == 0 ? '1' : '0';
			pattern2 += i % 2 == 0 ? '0' : '1';
		}
		
		int ans = Integer.MAX_VALUE;
		int cnt = 0;
		for (int i = 0; i < N; ++i)
			if (pattern1.charAt(i) != stripe.charAt(i))
				++cnt;
		ans = Math.min(ans, cnt);
		
		cnt = 0;
		for (int i = 0; i < N; ++i)
			if (pattern2.charAt(i) != stripe.charAt(i))
				++cnt;
		ans = Math.min(ans, cnt);
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
