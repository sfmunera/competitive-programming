package codeforces;

import java.util.*;

public class HanSoloAndLazerGun {

	static int hash(int x, int y) {
		return x + 100000 * y;
	}
	
	static int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x % y);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int x0 = in.nextInt();
		int y0 = in.nextInt();
		
		Map<Integer, Integer> lineMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			int num = y - y0;
			int den = x - x0;
			int g = gcd(num, den);
			num /= g;
			den /= g;
			int h = hash(num, den);
			if (!lineMap.containsKey(h))
				lineMap.put(h, 0);
			lineMap.put(h, lineMap.get(h) + 1);
		}
		
		System.out.println(lineMap.size());
		
		in.close();
		System.exit(0);
	}
}
