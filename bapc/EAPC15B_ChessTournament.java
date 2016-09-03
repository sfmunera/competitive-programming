package bapc;

import java.util.*;

public class EAPC15B_ChessTournament {

	final static int MODULO = (int) 1e8;

	static Integer[] calculateGroups(int N, boolean[][] adj) {
		List<Integer> groupList = new ArrayList<Integer>();
	
		boolean[] seen = new boolean[2*N + 1];
		for (int i = 1; i <= 2 * N; ++i) {
			if (seen[i]) continue;
	
			int cnt = 0;
			Queue<Integer> Q = new LinkedList<Integer>();
			Q.offer(i);
			seen[i] = true;
	
			while (!Q.isEmpty()) {
				int cur = Q.poll();
				++cnt;
				for (int next = 1; next <= 2 * N; ++next) {
					if (!adj[cur][next] && !seen[next]) {
						seen[next] = true;
						Q.offer(next);
					}
				}
			}
	
			groupList.add(cnt);
		}
	
		return groupList.toArray(new Integer[0]);
	}

	static Integer[][] dp;

	static int dp(int spotsLeft, int groupId, Integer[] groups) {
		if (spotsLeft == 0) return 1;
		if (groupId == groups.length) return 0;
	
		if (dp[spotsLeft][groupId] != null) {
			return dp[spotsLeft][groupId];
		}
		
		int ans = 0;
		if (spotsLeft - groups[groupId] >= 0) {
			ans = dp(spotsLeft - groups[groupId], groupId + 1, groups);
			ans %= MODULO;
		}
	
		if (groupId > 0) {
			ans += dp(spotsLeft, groupId + 1, groups);
			ans %= MODULO;
		}
	
		return dp[spotsLeft][groupId] = ans;
	}
	
	static void solve(int N, boolean[][] adj) {
		Integer[] groups = calculateGroups(N, adj);
	
		dp = new Integer[2*N + 2][2*N + 2];
		int ans = dp(N, 0, groups);
		System.out.println(ans);
	}
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int M = in.nextInt();
	
			boolean[][] adj = new boolean[2*N + 1][2*N + 1];
			for (int i = 0; i < M; ++i) {
				int a = in.nextInt();
				int b = in.nextInt();
		
				adj[a][b] = adj[b][a] = true;
			}
			solve(N, adj);
		}
	
		in.close();
	}
}
