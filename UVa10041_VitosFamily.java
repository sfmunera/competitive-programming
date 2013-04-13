package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 982 (10041 - Vito's Family) */
/* SUBMISSION: 09001341 */
/* SUBMISSION TIME: 2011-06-30 03:44:19 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10041_VitosFamily {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int R = in.nextInt();
			int[] s = new int[R];
			
			for (int i = 0; i < R; ++i)
				s[i] = in.nextInt();
			Arrays.sort(s);
			int median = s[R / 2];
			int res = 0;
			
			for (int x : s)
				res += Math.abs(x - median);
			
			System.out.println(res);
		}
	}
}