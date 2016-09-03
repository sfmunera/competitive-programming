package bapc;

import java.util.*;

public class EAPC15A_CheatingKnight {
	
	static final double EPS = 1e-9;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			long D = in.nextLong();
			long X = in.nextLong();
			long Y = in.nextLong();
			
			long dist2 = X * X + Y * Y;
			long ans = 0;
			
			if (dist2 == 0) {
				ans = 0;
			} else if (dist2 < D) {
				ans = 2;
			} else {
				ans = (long) Math.ceil(Math.sqrt(dist2) / Math.sqrt(D) - EPS);
			}
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
