package codeforces;

import java.util.*;

public class CheapTravel {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		
		int ans1 = n * a;
		int ans2 = n / m * b + Math.min((n % m) * a, b);
		System.out.println(Math.min(ans1, ans2));
		
		in.close();
		System.exit(0);
	}
}
