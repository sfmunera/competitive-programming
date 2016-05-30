package livearchive;

import java.util.*;

public class Pie {
	
	static boolean canShareAll(int[] r, int F, double V) {
		for (int i = 0; i < r.length; ++i) {
			int cnt = (int) Math.floor((double) r[i] * r[i] / V);
			F -= cnt;
		}
		
		return F <= 0;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int F = in.nextInt();
			++F;
			
			int[] r = new int[N];
			for (int i = 0; i < N; ++i) {
				r[i] = in.nextInt();
			}
			
			double ans = 0.0;
			double lower = 0.0;
			double upper = 0.0;
			for (int i = 0; i < N; ++i) {
				upper += r[i] * r[i];
			}
			
			while (upper - lower > 1e-6) {
				double mid = (lower + upper) / 2.0;
				if (canShareAll(r, F, mid)) {
					ans = mid;
					lower = mid;
				} else {
					upper = mid;
				}
			}
			
			System.out.format("%.4f\n", Math.PI * ans);
		}
		
		in.close();
		System.exit(0);
	}
}

