package codeforces;

import java.util.*;

public class TheChildAndSet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int sum = in.nextInt();
		int limit = in.nextInt();
		
		List<Integer> set = new ArrayList<Integer>();
		for (int i = limit; i >= 0 && sum > 0; --i) {
			int lowbit = i & -i;
			if (sum - lowbit >= 0) {
				set.add(i);
				sum -= lowbit;
			}
		}
		
		if (sum > 0) {
			System.out.println(-1);
		} else {
			System.out.println(set.size());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < set.size(); ++i) {
				if (i > 0) sb.append(" ");
				sb.append(set.get(i));
			}
			System.out.println(sb);
		}
		
		in.close();
		System.exit(0);
	}
}
