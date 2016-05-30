package codeforces;

import java.io.*;

public class MartianClock {
	
	static String abc = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	static int toDec(String x, int b) {
		int n = 0;
		int pow = 1;
		
		for (int i = x.length() - 1; i >= 0; --i) {
			n += pow * (abc.indexOf(x.charAt(i)));
			pow *= b;
		}
		return n;
	}
	
	public static void main(String[] args) throws IOException {
		String abc = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = in.readLine().split("[:]");
		String a = parts[0];
		String b = parts[1];
		
		int max = 0;
		for (int i = 0; i < a.length(); ++i)
			max = Math.max(max, abc.indexOf(a.charAt(i)) + 1);
		for (int i = 0; i < b.length(); ++i)
			max = Math.max(max, abc.indexOf(b.charAt(i)) + 1);
		
		boolean first = true;
		boolean found = false;
		int a1 = toDec(a, max);
		int b1 = toDec(b, max);
		int a2 = toDec(a, max + 1);
		int b2 = toDec(b, max + 1);
		if (a1 < 24 && b1 < 60 && a1 == a2 && b1 == b2) System.out.println("-1");
		else {
			for (int base = max; ; ++base) {
				int na = toDec(a, base);
				int nb = toDec(b, base);
				if (na >= 24 || nb >= 60) break;
				if (first) first = false; else System.out.print(" ");
				found = true;
				System.out.print(base);
			}
			if (!found) System.out.println(0);
			else System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
