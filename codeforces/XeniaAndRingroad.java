package codeforces;

import java.util.*;

public class XeniaAndRingroad {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		long time = 0;
		int cur = 1;
		for (int i = 0; i < m; ++i) {
			int next = in.nextInt();
			time += (long)next >= cur ? next - cur : n - cur + next;
			cur = next;
		}
		
		System.out.println(time);
		
		in.close();
		System.exit(0);
	}
}
