import java.util.*;
import java.io.*;

public class UnicycleCounting {
	
	static int M, N;
	static int[] marks;
	static int[] pos;
	static Integer[] dp;
	
	static final int INF = (int) 1e9;
	
	static int go(int mask) {
		if (mask == (1 << N) - 1)
			return 0;
		
		if (dp[mask] != null)
			return dp[mask];
		
		int ans = N;
		for (int i = 0; i < N; ++i) {
			int[] dist = new int[N + 1];
			for (int j = 0; j < N; ++j)
				dist[j] = Math.abs(marks[i] - marks[j]);
			dist[N] = M;
			for (int d = 0; d <= N; ++d) {
				if (dist[d] <= marks[i])
					continue;
				boolean ok = true;
				for (int j = marks[i]; j < M; j += dist[d])
					if (pos[j] == -1) {
						ok = false;
						break;
					}
				if (ok) {
					int newmask = mask;
					for (int j = marks[i]; j < M; j += dist[d])
						newmask |= (1 << pos[j]);
					if (mask != newmask)
						ans = Math.min(ans, 1 + go(newmask));
				}
			}
		}
		return dp[mask] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			M = in.nextInt();
			N = in.nextInt();
			
			marks = new int[N];
			pos = new int[M + 1];
			Arrays.fill(pos, -1);
			for (int i = 0; i < N; ++i) {
				marks[i] = in.nextInt();
			}
			
			dp = new Integer[(1 << N) + 1];
			
			Arrays.sort(marks);
			for (int i = 0; i < N; ++i) {
				pos[marks[i]] = i;
			}
			
			int ans = go(0);
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
