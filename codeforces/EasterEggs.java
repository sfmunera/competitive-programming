package codeforces;

import java.util.*;

public class EasterEggs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String colors = "ROYGBIV";
		int n = in.nextInt();
		int tail = n % 7;
		
		String ans = "";
		for (int i = 0; i < n - tail; ++i) {
			ans += colors.charAt(i % 7);
		}
		
		for (int i = 0; i < tail; ++i) {
			boolean[] seen = new boolean[7];
			int pos = ans.length() - 1;
			for (int j = 0; j < 3; ++j) {
				seen[colors.indexOf(ans.charAt(pos - j))] = true;
				seen[colors.indexOf(ans.charAt((pos + j + 1) % ans.length()))] = true;
			}
			
			for (int j = 0; j < 7; ++j) {
				if (!seen[j]) {
					ans += colors.charAt(j);
					break;
				}
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
