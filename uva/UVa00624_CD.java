package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 565 (624 - CD) */
/* SUBMISSION: 09033397 */
/* SUBMISSION TIME: 2011-07-09 18:08:43 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00624_CD {
	
	static int countBits(int n, int k) {
		int cnt = 0;
		for (int i = 0; i < k; ++i)
			if ((n & 1 << i) != 0)
				++cnt;
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextInt()) {
			int N = in.nextInt();
			int k = in.nextInt();
			int[] tracks = new int[k];
			for (int i = 0; i < k; ++i)
				tracks[i] = in.nextInt();
			
			int max = 0;
			int subset = 0;
			for (int i = 0; i < (1 << k); ++i) {
				int sum = 0;
				for (int j = 0; j < k; ++j)
					if ((i & 1 << j) != 0)
						sum += tracks[j];
				if (sum > N)
					continue;
				if (sum > max) {
					max = sum;
					subset = i;
				} else if (sum == max)
					if (countBits(i, k) > countBits(subset, k))
						subset = i;
			}
			String res = "";
			for (int j = 0; j < k; ++j)
				if ((subset & 1 << j) != 0)
					res += tracks[j] + " ";
				
			res += "sum:" + max;
			System.out.println(res);
		}
	}
}