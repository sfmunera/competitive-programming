package codeforces;

import java.util.*;

public class LuckyString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		StringBuilder sb = new StringBuilder();
		// put the first four letters every four positions
		for (int i = 0; i < n; ++i)
			sb.append((char) ('a' + (i % 4)));
		System.out.println(sb);
		
		in.close();
		System.exit(0);
	}
}
