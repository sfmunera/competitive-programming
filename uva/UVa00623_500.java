package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 564 (623 - 500!) */
/* SUBMISSION: 08892758 */
/* SUBMISSION TIME: 2011-05-27 13:22:26 */
/* LANGUAGE: 2 */

import java.util.*;
import java.math.*;

public class UVa00623_500 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int num = in.nextInt();
			BigInteger res = BigInteger.ONE;
			
			for (int i = 2; i <= num; ++i)
				res = res.multiply(BigInteger.valueOf(i));
			
			System.out.println(num + "!");
			System.out.println(res);
		}
	}
}
