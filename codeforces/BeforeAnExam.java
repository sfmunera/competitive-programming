package codeforces;

import java.util.*;

public class BeforeAnExam {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int d = in.nextInt();
		int sumTime = in.nextInt();
		
		int sumMin = 0;
		int sumMax = 0;
		int[] min = new int[d];
		int[] max = new int[d];
		for (int i = 0; i < d; ++i) {
			min[i] = in.nextInt();
			max[i] = in.nextInt();
			
			sumMin += min[i];
			sumMax += max[i];
		}
		
		if (sumTime < sumMin || sumTime > sumMax) {
			System.out.println("NO");
		} else {
			int j = 0;
			while (sumMin < sumTime) {
				if (min[j] < max[j]) {
					++min[j];
					++sumMin;
				}
				++j;
				j %= d;
			}
			
			System.out.println("YES");
			for (int i = 0; i < d; ++i) {
				if (i > 0) System.out.print(" ");
				System.out.print(min[i]);
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
