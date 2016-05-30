package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1193 (10252 - Common Permutation) */
/* SUBMISSION: 09001199 */
/* SUBMISSION TIME: 2011-06-30 02:49:34 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10252_CommonPermutation {
	public static void main(String[] args) {
		//try {
			Scanner in = new Scanner(System.in);
			
			while (in.hasNext()) {
				String str1 = in.nextLine().trim();
				String str2 = in.nextLine().trim();
				
				if (str1.isEmpty() || str2.isEmpty()) {
					System.out.println();
					continue;
				}
				char[] a = str1.toCharArray();
				char[] b = str2.toCharArray();
				
				Arrays.sort(a);
				Arrays.sort(b);
				int kb = 0;
				String res = "";
				
				for (int ka = 0; ka < a.length; ++ka) {
					while (kb < b.length && a[ka] > b[kb])
						++kb;
					if (kb < b.length && a[ka] == b[kb]) {
						res += a[ka];
						++kb;
					}
				}
				if (res.isEmpty())
					System.out.println();
				else {
					char[] tmp = res.toCharArray();
					Arrays.sort(tmp);
					res = String.valueOf(tmp);
					System.out.println(res);
				}
			}
		//} catch (Exception e) {
		//	System.exit(0);
		//}
	}
}