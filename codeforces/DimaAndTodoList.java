package codeforces;

import java.util.*;

public class DimaAndTodoList {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] sum = new int[k];
		for (int i = 0; i < n; ++i)
			sum[i % k] += in.nextInt();
		
		int minAt = 0;
		for (int i = 1; i < k; ++i)
			if (sum[i] < sum[minAt])
				minAt = i;
		System.out.println(minAt + 1);
		
		in.close();
		System.exit(0);
	}
}
