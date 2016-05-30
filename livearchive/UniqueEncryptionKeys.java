package livearchive;

import java.util.*;

public class UniqueEncryptionKeys {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int M = in.nextInt();
			int Q = in.nextInt();
			
			if (M == 0 && Q == 0) break;
			
			int[] keys = new int[M];
			int[] dp = new int[M];
			Map<Integer, Integer> currentPosition = new HashMap<Integer, Integer>();

			int last = -1;
			for (int i = 0; i < M; ++i) {
				keys[i] = in.nextInt();
				if (currentPosition.containsKey(keys[i])) {
					int prev = currentPosition.get(keys[i]);
					if (prev > last)
						last = prev;
				}
				dp[i] = last;
				currentPosition.put(keys[i], i);
			}
			
			//System.out.println(Arrays.toString(lastRepeatedSoFar));
			//System.out.println(currentPosition);
			
			for (int i = 0; i < Q; ++i) {
				int b = in.nextInt() - 1;
				int e = in.nextInt() - 1;
				
				System.out.println(dp[e] >= b ? keys[dp[e]] : "OK");
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
