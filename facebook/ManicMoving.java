package facebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ManicMoving {
	
	static final int INF = (int) 1e9;
	
	static int N, M, K;
	static int[][] distance;
	static FamilyMoving[] families;
	static Integer[][][] dp;
	
	static class FamilyMoving {
		int S, D;
		public FamilyMoving(int S, int D) {
			this.S = S;
			this.D = D;
		}
	}
	
	static int solve(int lastLoaded, int city, int inTruck) {
		if (lastLoaded == K && inTruck == 0) {
			return 0;
		}
		if (dp[lastLoaded][city][inTruck] != null) {
			return dp[lastLoaded][city][inTruck];
		}

		int ans = INF;
		if (inTruck == 0) {
			// load next family
			if (lastLoaded < K) {
				int nextCity = families[lastLoaded + 1].S;
				ans = Math.min(ans, distance[city][nextCity] + solve(lastLoaded + 1, nextCity, 1));
			}
		} else if (inTruck == 1) {
			// unload current family
			int nextCity = families[lastLoaded].D;
			ans = Math.min(ans, distance[city][nextCity] + solve(lastLoaded, nextCity, 0));
			// load next family
			if (lastLoaded < K) {
				nextCity = families[lastLoaded + 1].S;
				ans = Math.min(ans, distance[city][nextCity] + solve(lastLoaded + 1, nextCity, 2));
			}
		} else { // if (inTruck == 2)
			// unload previous family
			assert lastLoaded > 0;
			int nextCity = families[lastLoaded - 1].D;
			ans = Math.min(ans, distance[city][nextCity] + solve(lastLoaded, nextCity, 1));
		}
		if (ans > INF) ans = INF;
		return dp[lastLoaded][city][inTruck] = ans;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("manic_moving.txt")));
		System.setOut(new PrintStream(new File("manic_moving.out")));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int testNumber = 1; testNumber <= T; testNumber++) {
			N = in.nextInt();
			M = in.nextInt();
			K = in.nextInt();
			distance = new int[N + 1][N + 1];
			for (int i = 0; i <= N; i++) {
				Arrays.fill(distance[i], INF);
				distance[i][i] = 0;
			}
			
			for (int i = 0; i < M; i++) {
				int A = in.nextInt();
				int B = in.nextInt();
				int G = in.nextInt();
				if (G < distance[A][B]) {
					distance[A][B] = distance[B][A] = G;
				}
			}
			
			for (int k = 1; k <= N; k++) for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) {
				distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
			}
			
			families = new FamilyMoving[K + 1];
			for (int i = 1; i <= K; i++) {
				int S = in.nextInt();
				int D = in.nextInt();
				families[i] = new FamilyMoving(S, D);
			}
			
			dp = new Integer[K + 5][N + 5][3];
			int firstCity = families[1].S;
			long ans = distance[1][firstCity] + solve(1, firstCity, 1);
			System.out.println("Case #" + testNumber + ": " + (ans >= INF ? -1 : ans));
		}
		
		in.close();
		System.exit(0);
	}
}
