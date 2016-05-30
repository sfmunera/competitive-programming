package codeforces;

import java.util.*;
import java.io.*;

public class NewYearTransportation {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int t = Integer.parseInt(stk.nextToken());
		
		int[] a = new int[n - 1];
		
		stk = new StringTokenizer(in.readLine());
		for (int i = 0; i < n - 1; ++i) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		
		int cur = 1;
		boolean possible = false;
		while (true) {
			if (cur == t) {
				possible = true;
			}
			if (cur >= t) {
				break;
			}

			cur = cur + a[cur - 1];
		}
		
		System.out.println(possible ? "YES" : "NO");
		
		in.close();
		System.exit(0);
	}
}
