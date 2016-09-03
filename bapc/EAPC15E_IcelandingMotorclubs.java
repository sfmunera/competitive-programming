package bapc;

import java.util.*;

public class EAPC15E_IcelandingMotorclubs {
	
	static class Station {
		int G, D;
		Station(int G, int D) { this.G = G; this.D = D; }
		int diff() { return this.G - this.D; }
	}
	
	static void solve(Station[] stations) {
		int N = stations.length;
		int[] diffAccum = new int[N];
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			diffAccum[i] = (i == 0 ? 0 : diffAccum[i - 1]) + stations[i].diff();
			min = Math.min(min, diffAccum[i]);
		}
		
		int[] minBefore = new int[N]; // min [0, i)
		minBefore[0] = diffAccum[0];
		for (int i = 1; i < N; ++i) {
			minBefore[i] = Math.min(diffAccum[i - 1], minBefore[i - 1]);
		}
		
		int[] minAfter = new int[N]; // min [i, n)
		minAfter[N - 1] = diffAccum[N - 1];
		for (int i = N - 2; i >= 0; --i) {
			minAfter[i] = Math.min(diffAccum[i], minAfter[i + 1]);
		}
		
		int ans = -1;
		if (min >= 0) {
			ans = 1;
		} else {
			for (int i = 1; i < N; ++i) {
				int prev = diffAccum[i - 1];
				if (stations[i].diff() >= 0 && minBefore[i] >= prev - diffAccum[N - 1] && minAfter[i] >= prev) {
					ans = i + 1;
					break;
				}
	 		}
		}
		
		System.out.println(ans < 0 ? "IMPOSSIBLE" : ans);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			Station[] stations = new Station[N];
			
			for (int i = 0; i < N; ++i) {
				int G = in.nextInt();
				int D = in.nextInt();
				
				stations[i] = new Station(G, D);
			}
			solve(stations);
		}
		
		in.close();
		System.exit(0);
	}
}
