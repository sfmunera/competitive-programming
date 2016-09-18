package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 670 (729 - The Hamming Distance Problem) */
/* SUBMISSION: 09033719 */
/* SUBMISSION TIME: 2011-07-09 19:17:43 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00729_TheHammingDistanceProblem {
	
	static void swap(char[] c, int i, int j) {
		char t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static boolean nextPermutation(char[] c) {
		int n = c.length;
        int k = -1;
        for (int i = n - 2; i >= 0; --i) {
            if (c[i] < c[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1)
            return false;
        int l = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (c[k] < c[i]) {
                l = i;
                break;
            }
        }
        swap(c, k, l);
        for (int i = k + 1; i < (n + k + 1) / 2; ++i)
        	swap(c, i, n + k - i);
        return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			int H = in.nextInt();
			
			char[] num = new char[N];
			Arrays.fill(num, '0');
			for (int i = 0; i < H; ++i)
				num[N - 1 - i] = '1';
			
			if (t > 1)
				System.out.println();
			StringBuilder sb = new StringBuilder();
			do {
				sb.append(String.valueOf(num) + "\n");
			} while (nextPermutation(num));
			System.out.print(sb);
		}
	}
}