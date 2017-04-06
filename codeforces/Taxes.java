package codeforces;

import java.util.*;

public class Taxes {
	
	static boolean isPrime(int n) {
		if (n < 2) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int ans = 0;
		if (isPrime(n)) {
			ans = 1;
		} else if (n % 2 == 0) {
			ans = 2;
		} else {
			if (isPrime(n - 2)) {
				ans = 2;
			} else {
				ans = 3;
			}
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
