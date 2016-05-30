package livearchive;

import java.util.*;

public class Wheels {
	
	static class Wheel {
		int x, y, r;
		Wheel(int x, int y, int r) {
			this.x = x; this.y = y; this.r = r;
		}
	}
	
	static boolean touch(Wheel w1, Wheel w2) {
		int dx = w1.x - w2.x;
		int dy = w1.y - w2.y;
		int R = w1.r + w2.r;
		int dist = dx * dx + dy * dy;
		
		return dist == R * R;
	}
	
	static int[] calcDistances(Wheel[] wheels, int n){
		int[] dist = new int[n];
		boolean[] seen = new boolean[n];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Arrays.fill(dist, -1);
		seen[0] = true;
		dist[0] = 0;
		Q.offer(0);
		while (!Q.isEmpty()) {
			int x = Q.poll();
			for (int i = 0; i < n; ++i) {
				if (touch(wheels[x], wheels[i]) && !seen[i]) {
					seen[i] = true;
					dist[i] = dist[x] + 1;
					Q.offer(i);
				}
			}
		}
		
		return dist;
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static String outRatio(int p, int q) {
		int g = gcd(p, q);
		p /= g;
		q /= g;
		if (q == 1)
			return "" + p;
		else return p + "/" + q;
	}
	
	static void solve(Wheel[] wheels) {
		int n = wheels.length;
		int[] dist = calcDistances(wheels, n);
		
		for (int i = 0; i < n; ++i) {
			if (dist[i] < 0) {
				System.out.println("not moving");
			} else {
				System.out.println(outRatio(wheels[0].r, wheels[i].r) + " " + (dist[i] % 2 == 0 ? "" : "counter") + "clockwise");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			Wheel[] wheels = new Wheel[n];
			
			for (int i = 0; i < n; ++i)
				wheels[i] = new Wheel(in.nextInt(), in.nextInt(), in.nextInt());
			
			solve(wheels);
		}
		
		in.close();
		System.exit(0);
	}
}
