package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2267 (11292 - Dragon of Loowater) */
/* SUBMISSION: 08897509 */
/* SUBMISSION TIME: 2011-05-28 20:03:52 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11292_DragonofLoowater {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int n = in.nextInt();
			int m = in.nextInt();
			if (n == 0 && m == 0)
				break;
			
			int[] heads = new int[n];
			int[] knights = new int[m];
			for (int i = 0; i < n; ++i)
				heads[i] = in.nextInt();
			for (int i = 0; i < m; ++i)
				knights[i] = in.nextInt();
			
			Arrays.sort(knights);
			Arrays.sort(heads);
			
			int k = 0;
			int res = 0;
			
			for (int i = 0; i < n && res != -1; ++i) {
				while (k < m && knights[k] < heads[i])
					++k;
				if (k < m)
					res += knights[k];
				else
					res = -1;
				++k;
			}
			System.out.println(res == -1 ? "Loowater is doomed!" : res);
		}
	}
}
