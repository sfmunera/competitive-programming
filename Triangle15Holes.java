import java.util.*;
import java.io.*;

public class Triangle15Holes {
	
	static int[] dx = {-1, -1, 0, 0, 1, 1};
	static int[] dy = {-1, 0, -1, 1, 0, 1};
	
	static int[] toCoords(int i) { // (y, x)
		int y = 0, x = 0;
		switch (i) {
		case 0: y = 0; x = 0; break;
		case 1: y = 1; x = 0; break;
		case 2: y = 1; x = 1; break;
		case 3: y = 2; x = 0; break;
		case 4: y = 2; x = 1; break;
		case 5: y = 2; x = 2; break;
		case 6: y = 3; x = 0; break;
		case 7: y = 3; x = 1; break;
		case 8: y = 3; x = 2; break;
		case 9: y = 3; x = 3; break;
		case 10: y = 4; x = 0; break;
		case 11: y = 4; x = 1; break;
		case 12: y = 4; x = 2; break;
		case 13: y = 4; x = 3; break;
		case 14: y = 4; x = 4; break;
		}
		return new int[]{y, x};
	}
	
	static int toNum(int y, int x) {
		if (y == 0 && x == 0) return 0;
		if (y == 1 && x == 0) return 1;
		if (y == 1 && x == 1) return 2;
		if (y == 2 && x == 0) return 3;
		if (y == 2 && x == 1) return 4;
		if (y == 2 && x == 2) return 5;
		if (y == 3 && x == 0) return 6;
		if (y == 3 && x == 1) return 7;
		if (y == 3 && x == 2) return 8;
		if (y == 3 && x == 3) return 9;
		if (y == 4 && x == 0) return 10;
		if (y == 4 && x == 1) return 11;
		if (y == 4 && x == 2) return 12;
		if (y == 4 && x == 3) return 13;
		if (y == 4 && x == 4) return 14;
		return -1;
	}
	
	static boolean inside(int y, int x) {
		return y < 5 && x <= y;
	}
	
	static void bfs(int s) {
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer, Integer> p = new HashMap<Integer, Integer>();
		Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
		Queue<Integer> Q = new LinkedList<Integer>();
		int t = s;
		
		visited.add(s);
		dist.put(s, 0);
		Q.offer(s);
		
		while (!Q.isEmpty()) {
			int mask = Q.poll();
			if (Integer.bitCount(mask) == 1) {
				t = mask;
				break;
			}
			for (int i = 0; i < 15; ++i) {
				if ((mask & (1 << i)) != 0) {
					int[] yx = toCoords(i);
					int y = yx[0]; int x = yx[1];
					for (int k = 0; k < dy.length; ++k) {
						int ny = y + dy[k]; // Intermediary
						int nx = x + dx[k];
						int ni = toNum(ny, nx);
						
						int my = y + 2 * dy[k]; // Neighbor
						int mx = x + 2 * dx[k];
						int mi = toNum(my, mx);
						
						if (inside(ny, nx) && inside(my, mx) && 
								(mask & (1 << mi)) == 0 && (mask & (1 << ni)) != 0) {
							int newmask = mask;
							newmask &= ~(1 << i); // Clear current
							newmask &= ~(1 << ni); // Clear intermediary
							newmask |= (1 << mi); // Set neighbor
							
							if (!visited.contains(newmask)) {
								visited.add(newmask);
								dist.put(newmask, dist.get(mask) + 1);
								p.put(newmask, mask);
								Q.offer(newmask);
							}
						}
					}
				}
			}
		}
		System.out.println(dist.get(t));
		int cur = t;
		Stack<Integer> path = new Stack<Integer>();
		path.push(cur);
		while (p.containsKey(cur)) {
			cur = p.get(cur);
			path.push(cur);
		}
		while (!path.isEmpty()) {
			int mask = path.pop();
			int i = 0;
			System.out.println();
			for (int y = 0; y < 5; ++y) {
				if (y < 4)
					System.out.printf("%" + (4 - y) + "s", " ");
				for (int x = 0; x <= y; ++x) {
					if (x > 0) System.out.print(" ");
					System.out.print((mask & (1 << i)) == 0 ? 'O' : 'X');
					++i;
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int s = 0;
		int i = 0;
		for (int y = 0; y < 5; ++y) {
			String line = in.readLine();
			for (int x = 0; x < line.length(); ++x) {
				char c = line.charAt(x);
				if (c == 'X')
					s |= (1 << i);
				++i;
			}
		}
		bfs(s);
		
		in.close();
		System.exit(0);
	}
}
