package codeforces;

import java.util.*;
import java.io.*;

public class LittleElephantAndSorting {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		StringTokenizer stk = new StringTokenizer(in.readLine());
		
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		
		long ans = 0;
		// if a[i] < a[i-1], just increase all the elements from there on by a[i-1]-a[i]
		for (int i = 1; i < n; ++i) {
			if (a[i] < a[i - 1]) {
				ans += (long)a[i - 1] - a[i];
			}
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
