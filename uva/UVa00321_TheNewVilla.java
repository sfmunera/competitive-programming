package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 257 (321 - The New Villa) */
/* SUBMISSION: 10905767 */
/* SUBMISSION TIME: 2012-11-19 01:01:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00321_TheNewVilla {
	
	static int r;
	static boolean[][] adjRooms;
	static boolean[][] adjSwitch;
	
	static class QueueItem {
		int u, mask;
		public QueueItem(int u, int mask) {
			this.u = u; this.mask = mask;
		}
	}
	
	static void bfs() {
		Queue<QueueItem> Q = new LinkedList<QueueItem>();
		int[][] dist = new int[r][1050];
		boolean[][] visited = new boolean[r][1050];
		QueueItem[][] p = new QueueItem[r][1050];
		
		for (int i = 0; i < r; ++i) {
			Arrays.fill(dist[i], -1);
			Arrays.fill(p[i], null);
		}
		
		QueueItem s = new QueueItem(0, 1); // First node, only first light switched on
		
		Q.offer(s);
		dist[0][1] = 0;
		visited[0][1] = true;
		
		while (!Q.isEmpty()) {
			QueueItem x = Q.poll();
			int u = x.u;
			int mask = x.mask;
			
			// Move to another room with light on
			for (int v = 0; v < r; ++v) {
				if (adjRooms[u][v] && (mask & (1 << v)) != 0 &&
						!visited[v][mask]) {
					QueueItem next = new QueueItem(v, mask);
					Q.offer(next);
					dist[v][mask] = dist[u][mask] + 1;
					visited[v][mask] = true;
					p[v][mask] = x;
				}
			}
			// Switch on or off a light, being careful not to turn off current room's light
			for (int v = 0; v < r; ++v) {
				if (adjSwitch[u][v] && u != v && 
						!visited[u][mask ^ (1 << v)]) {
					QueueItem next = new QueueItem(u, mask ^ (1 << v));
					Q.offer(next);
					dist[u][mask ^ (1 << v)] = dist[u][mask] + 1;
					visited[u][mask ^ (1 << v)] = true;
					p[u][mask ^ (1 << v)] = x;
				}
			}
		}
		if (dist[r - 1][1 << (r - 1)] == -1)
			System.out.println("The problem cannot be solved.");
		else {
			System.out.println("The problem can be solved in " + dist[r - 1][1 << (r - 1)] + " steps:");

			int tnode = r - 1;
			int tmask = 1 << (r - 1);
			Stack<String> path = new Stack<String>();
			while (true) {
				QueueItem parent = p[tnode][tmask];
				if (parent == null)
					break;
				if (parent.u != tnode)
					path.push("- Move to room " + (tnode + 1) + ".");
				else {
					int sw = 0;
					for (int i = 0; i < r; ++i)
						if ((parent.mask & (1 << i)) != (tmask & (1 << i))) {
							sw = i;
							break;
						}
					if (tmask < parent.mask)
						path.push("- Switch off light in room " + (sw + 1) + ".");
					else
						path.push("- Switch on light in room " + (sw + 1) + ".");
				}
				tnode = parent.u;
				tmask = parent.mask;
			}
			
			while (!path.isEmpty())
				System.out.println(path.pop());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		int t = 1;
		while (true) {
			
			if (first)
				first = false;
			else
				in.readLine();
			
			String[] parts = in.readLine().split("[ ]+");
			r = Integer.parseInt(parts[0]);
			int d = Integer.parseInt(parts[1]);
			int s = Integer.parseInt(parts[2]);
			
			if (r == 0 && d == 0 && s == 0) break;
			System.out.println("Villa #" + t);
			
			adjRooms = new boolean[r][r];
			adjSwitch = new boolean[r][r];
			
			for (int i = 0; i < d; ++i) {
				parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]) - 1;
				int v = Integer.parseInt(parts[1]) - 1;
				
				adjRooms[u][v] = adjRooms[v][u] = true;
			}
			
			for (int i = 0; i < s; ++i) {
				parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]) - 1;
				int v = Integer.parseInt(parts[1]) - 1;
				
				adjSwitch[u][v] = true;
			}
			
			bfs();
			System.out.println();
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
