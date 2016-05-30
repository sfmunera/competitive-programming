package codeforces;

import java.util.*;
import java.io.*;

public class PaintingEggs {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int n = Integer.parseInt(in.readLine());
		StringBuilder ans = new StringBuilder();
		
		int Sa = 0;
		int Sg = 0;
		for (int i = 0; i < n; ++i) {
			stk = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int g = Integer.parseInt(stk.nextToken());
			
			// try to add a. If it breaks the property, add g. Proof by induction
			if (Math.abs(Sa + a - Sg) <= 500) {
				ans.append("A");
				Sa += a;
			} else {
				ans.append("G");
				Sg += g;
			}
		}
		
		if (Math.abs(Sa - Sg) <= 500) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
		
		in.close();
		System.exit(0);
	}
}
