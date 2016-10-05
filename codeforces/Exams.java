package codeforces;

import java.util.*;

public class Exams {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] grades = new int[n];
		Arrays.fill(grades, 2);
		int sum = 2 * n;
		
		int idx = 0;
		while (sum < k) {
			grades[idx]++;
			sum++;
			idx = (idx + 1) % n;
		}
		
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			if (grades[i] == 2) {
				ans++;
			}
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
