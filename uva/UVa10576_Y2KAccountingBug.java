package uva;

import java.util.*;
import java.io.*;

public class UVa10576_Y2KAccountingBug {
	
	static boolean valid(int mask, int s, int d) {
		for (int i = 0; i < 8; ++i) {
			int sum = 0;
			for (int j = 0; j < 5; ++j)
				sum += ((mask & (1 << (i + j))) == 0) ? -d : s;
			if (sum >= 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			int s = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			
			int ans = 0;
			for (int mask = 0; mask < (1 << 12); ++mask) {
				if (valid(mask, s, d)) {
					int sum = 0;
					for (int i = 0; i < 12; ++i)
						sum += ((mask & (1 << i)) == 0) ? -d : s;
					ans = Math.max(ans, sum);
				}
			}
			System.out.println(ans > 0 ? ans : "Deficit");
		}
		
		in.close();
		System.exit(0);
	}
}
