package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2380 (11385 - Da Vinci Code) */
/* SUBMISSION: 08955262 */
/* SUBMISSION TIME: 2011-06-15 23:18:00 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa11385_DaVinciCode {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			long[] fibonacci = new long[50];
			fibonacci[0] = 1;
			fibonacci[1] = 2;
			
			for (int i = 2; i < fibonacci.length; ++i)
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			//System.out.println(Arrays.toString(fibonacci));
			int T = Integer.parseInt(in.nextLine());
			while (T-- > 0) {
				int N = Integer.parseInt(in.nextLine());
				String line = in.nextLine();
				String code = in.nextLine();
				
				StringTokenizer stk = new StringTokenizer(line);
				long[] fib = new long[N];
				long max = 0;
				for (int i = 0; i < N; ++i) {
					fib[i] = Long.parseLong(stk.nextToken());
					max = Math.max(max, fib[i]);
				}
				int n = Arrays.binarySearch(fibonacci, max);
				char[] res = new char[n + 1];
				Arrays.fill(res, ' ');
				
				int k = 0;
				for (int i = 0; i < N; ++i) {
					while (!Character.isUpperCase(code.charAt(k)))
						++k;
					int ind = Arrays.binarySearch(fibonacci, fib[i]);
					res[ind] = code.charAt(k);
					++k;
				}
				System.out.println(String.valueOf(res));
			}
		} catch (Exception e) {
			System.exit(0);
		}
	}
}
