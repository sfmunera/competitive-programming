import java.util.*;

public class KthDivisor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong();
		long k = in.nextLong();
		
		int countLess = 0;
		boolean isSqrt = false;
		
		for (long p = 1; p <= n / p; p++) {
			if (n % p == 0) countLess++;
			if (p * p == n) isSqrt = true;
		}
		
		long index = k;
		if (k > countLess) {
			index = 2 * countLess - k + (isSqrt ? 0 : 1);
		}
		long ans = -1;
		int cnt = 0;
		for (long p = 1; p <= n / p; p++) {
			if (n % p == 0) {
				cnt++;
				if (cnt == index) {
					ans = p;
					break;
				}
			}
		}
		if (ans > 0 && k > countLess) {
			ans = n / ans;
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
