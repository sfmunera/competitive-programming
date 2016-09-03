package bapc;

import java.util.*;

public class BAPC10D_Collatz {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();			
			int even = N - N / 2;
			int odd = (N + 1) / 2 - ((N - 1) / 3 + 1) / 2;
			
			System.out.println(odd + even);
		}
		
		in.close();
		System.exit(0);
	}
}
