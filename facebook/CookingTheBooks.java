package facebook;

import java.util.*;
import java.io.*;

public class CookingTheBooks {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("A.in")));
		System.setOut(new PrintStream(new File("A.out")));
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			String number = in.next();
			char[] small = number.toCharArray();
			char[] big = number.toCharArray();
			
			boolean done = false;
			for (int i = 0; i < small.length && !done; ++i) {
				int minAt = i;
				for (int j = i + 1; j < small.length && !done; ++j) {
					if (small[j] != '0' && small[j] < small[minAt]) {
						minAt = j;
					}
				}
				if (small[minAt] < small[i]) {
					done = true;
					char tmp = small[i];
					small[i] = small[minAt];
					small[minAt] = tmp;
				}
			}
			
			done = false;
			for (int i = 0; i < big.length && !done; ++i) {
				int maxAt = i;
				for (int j = i + 1; j < big.length && !done; ++j) {
					if (big[j] > big[maxAt]) {
						maxAt = j;
					}
				}
				if (big[maxAt] > big[i]) {
					done = true;
					char tmp = big[i];
					big[i] = big[maxAt];
					big[maxAt] = tmp;
				}
			}
			
			System.out.println("Case #" + t + ": " + String.valueOf(small) + " " + String.valueOf(big));
		}
		
		in.close();
	}
}
