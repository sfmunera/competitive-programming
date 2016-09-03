package bapc;

import java.util.*;

public class EAPC15F_ManhattanPowerFailure {

	static class Vertex {
		int id, group;
		Set<Integer> adj;
		Vertex(int id, int group) {
			this.id = id;
			this.group = group;
			this.adj = new HashSet<Integer>();
		}
	}
	
	static Vertex[] vertices;
	static int rows, cols;
	static boolean[] seen;

	static int getId(int r, int c) {
		return cols * r + c;
	}
	
	static void dfs(int s, int group) {
		seen[s] = true;
		vertices[s].group = group;
		
		for (int next : vertices[s].adj)
			if (!seen[next])
				dfs(next, group);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			rows = in.nextInt();
			cols = in.nextInt();
			int p = in.nextInt();
			int c = in.nextInt();
			
			vertices = new Vertex[rows * cols];
			for (int i = 0; i < rows * cols; ++i)
				vertices[i] = new Vertex(i, -1);
			
			List<Integer> starts = new ArrayList<Integer>();
			for (int i = 0; i < p; ++i) {
				int x = in.nextInt();
				int y = in.nextInt();
				starts.add(getId(x, y));
			}
			
			for (int i = 0; i < c; ++i) {
				int x = in.nextInt();
				int y = in.nextInt();
				char dir = in.next().charAt(0);
				
				int cur = getId(x, y);
				int next = 0;
				if (dir == 'R') {
					next = getId(x + 1, y);
				} else {
					next = getId(x, y + 1);
				}
				vertices[cur].adj.add(next);
				vertices[next].adj.add(cur);
			}
			
			seen = new boolean[rows * cols];
			int group = 0;
			for (int s = 0; s < rows * cols; ++s)
				if (!seen[s])
					dfs(s, group++);
			
			seen = new boolean[rows * cols];
			boolean[] seenGroup = new boolean[group];
			Queue<Integer> Q = new LinkedList<Integer>();
			
			for (int i = 0; i < rows * cols; ++i) {
				vertices[i].adj.clear();
			}
			
			for (int i = 0; i < rows; ++i)
				for (int j = 0; j < cols; ++j) {
					int cur = getId(i, j);
					if (i < rows - 1) {
						int next = getId(i + 1, j);
						vertices[cur].adj.add(next);
						vertices[next].adj.add(cur);
					}
					if (j < cols - 1) {
						int next = getId(i, j + 1);
						vertices[cur].adj.add(next);
						vertices[next].adj.add(cur);
					}
				}
			
			for (int s : starts) {
				seen[s] = true;
				Q.offer(s);
				seenGroup[vertices[s].group] = true;
			}
			
			int ans = 0;
			while (!Q.isEmpty()) {
				int cur = Q.poll();
				
				for (int next : vertices[cur].adj) {
					if (!seen[next]) {
						seen[next] = true;
						Q.offer(next);
						
						if (vertices[cur].group != vertices[next].group && !seenGroup[vertices[next].group]) {
							seenGroup[vertices[next].group] = true;
							++ans;
						}
					}
				}
			}

			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
