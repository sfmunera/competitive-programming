package codeforces;

import java.util.*;

public class Hometask {
	
	static String getNumber(int[] count) {
		StringBuilder sb = new StringBuilder();
		boolean leadingZeroes = true;
		for (int d = 9; d >= 0; --d) {
			for (int i = 0; i < count[d]; ++i) {
				sb.append(d);
				if (d > 0) {
					leadingZeroes = false;
				}
			}
		}
		if (leadingZeroes) {
			return "0";
		} else {
			return sb.toString();
		}
	}
	
	static boolean decreaseMinMultiple(int[] count, int x) {
		for (int d = x; d < 10; d += 3) {
			if (count[d] > 0) {
				--count[d];
				return true;
			}
		}
		
		return false;
	}
	
	static void adjust(int[] count, int mod) {
		boolean found = decreaseMinMultiple(count, mod);
		if (!found) {
			for (int i = 0; i < 2; ++i) {
				decreaseMinMultiple(count, mod == 1 ? 2 : 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] count = new int[10];
		int sum = 0;
		for (int i = 0; i < n; ++i) {
			int digit = in.nextInt();
			assert digit >= 0 && digit <= 9;
			
			++count[digit];
			sum += digit;
		}
		
		// check divisibility by 2 and 5 -> 10
		if (count[0] == 0) {
			System.out.println(-1);
		} else {
			// check divisibility by 3
			if (sum % 3 != 0) {
				adjust(count, sum % 3);
			}
			
			String ans = getNumber(count);
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
