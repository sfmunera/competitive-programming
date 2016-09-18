package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 983 (10042 - Smith Numbers) */
/* SUBMISSION: 08927081 */
/* SUBMISSION TIME: 2011-06-07 16:48:16 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10042_SmithNumbers {
	
	private static List<Integer> primeList;
	
	static void sieve(int n) {
	    int p = 2;
	    boolean[] isPrime = new boolean[n];
	    Arrays.fill(isPrime, true);
	    isPrime[0] = isPrime[1] = false;

	    while (p * p < n) {
	        for (int i = 2 * p; i < n; i += p)
	            isPrime[i] = false;
	        for (int i = p + 1; i < n; ++i)
	            if (isPrime[i]) {
	                p = i;
	                break;
	            }
	    }
	    primeList = new ArrayList<Integer>();
	    for (int i = 0; i < n; ++i)
	    	if (isPrime[i])
	    		primeList.add(i);
	}
	
	static int digitSum(long n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	
	static boolean isPrime(long n) {
		if (n == 2)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}
	
	static long nextSmith(int n) {
		long k = n + 1;
		while (true) {
			if (isPrime(k)) {
				++k;
				continue;
			}
			
			long tmp = k;
			int sum = digitSum(k);
			int sum2 = 0;

			for (int i = 0; i < primeList.size(); ++i) {
				int div = primeList.get(i);
				int sumd = digitSum(div);
				
				while (tmp % div == 0) {
					tmp /= div;
					sum2 += sumd;
				}
			}
			if (tmp > 1)
				sum2 += digitSum(tmp);
			
			if (sum == sum2)
				return k;
			++k;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		sieve(100000);
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			System.out.println(nextSmith(n));
		}
	}
}
