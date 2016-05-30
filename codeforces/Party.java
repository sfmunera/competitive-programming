package codeforces;

import java.io.*;

public class Party {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[] parent = new int[n];
		for (int i = 0; i < n; ++i) {
			parent[i] = Integer.parseInt(in.readLine()) - 1;
		}
		
		int longest = 0;
		for (int i = 0; i < n; ++i) {
			int cnt = 0;
			int cur = i;
			while (true) {
				if (cur < 0) {
					break;
				}
				++cnt;
				cur = parent[cur];
			}
			
			longest = Math.max(longest, cnt);
		}
		
		System.out.println(longest);	
		
		in.close();
		System.exit(0);
	}
}
