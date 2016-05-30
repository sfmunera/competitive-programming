package bapc;

import java.util.*;

public class IcelandicMotorclubs {
	
	static class Station {
		int G, D;
		Station(int G, int D) { this.G = G; this.D = D; }
		int diff() { return this.G - this.D; }
	}
	
	static void solve(Station[] stations) {
		int N = stations.length;
		int left = 0;
		int right = 0;
		
		int sum = 0;
		int cnt = N + 1;
		while (cnt > 0) {
			right = (right + 1) % N;
			sum += stations[(right - 1 + N) % N].diff();
			--cnt;
			while (sum < 0 && cnt > 0) {
				left = (left - 1 + N) % N;
				sum += stations[left % N].diff();
				--cnt;
			}			
		}
		
		System.out.println(sum >= 0 ? (left + 1) : "IMPOSSIBLE");
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
