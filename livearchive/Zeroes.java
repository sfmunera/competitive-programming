package livearchive;

import java.util.*;
import java.io.*;

public class Zeroes {
	
	static long solve(long x) {
		return x / 5;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			long low = Long.parseLong(stk.nextToken());
			long high = Long.parseLong(stk.nextToken());
			
			if (low == 0 && high == 0) break;
			
			long ans = solve(high) - solve(low) + 1;
			sb.append(ans + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
