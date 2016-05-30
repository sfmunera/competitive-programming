package livearchive;

import java.util.*;

public class Digraphs {
	
	static final int MAX_DEPTH = 2 * 20 - 1;
	
	static class QueueItem {
		String path;
		char letter;
		QueueItem(String path, char letter) {
			this.path = path;
			this.letter = letter;
		}
	}
	
	static void printSquare(String path) {
		int N = (path.length() + 1) / 2;
		
		for (int i = 0; i < N; ++i) {
			System.out.println(path.substring(i, i + N));
		}
	}
	
	static String findCycle(boolean[][] isDigraph) {
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			boolean[] seen = new boolean[26];
			Queue<QueueItem> Q = new LinkedList<QueueItem>();
			
			Q.offer(new QueueItem("" + ch, ch));
			seen[ch - 'a'] = true;
			while (!Q.isEmpty()) {
				QueueItem q = Q.poll();
				if (q.path.length() >= MAX_DEPTH) return q.path;
				for (char next = 'a'; next <= 'z'; ++next) {
					if (!isDigraph[q.letter - 'a'][next - 'a'])
						if (next == q.path.charAt(0)) {
							return q.path;
						}
						if (!seen[next - 'a']) {
							seen[next - 'a'] = true;
							Q.offer(new QueueItem(q.path + next, next));
						}
				}
			}
		}
		
		return "";
	}
	
	static Stack<Integer> sort;
	static void toposort(boolean[][] isDigraph) {
		sort = new Stack<Integer>();
		boolean[] seen = new boolean[26];
		
		for (int i = 0; i < 26; ++i)
			if (!seen[i])
				dfs(i, isDigraph, seen);		
	}
	
	static void dfs(int s, boolean[][] isDigraph, boolean[] seen) {
		seen[s] = true;
		
		for (int i = 0; i < 26; ++i) {
			if (!isDigraph[s][i] && !seen[i]) {
				dfs(i, isDigraph, seen);
			}
		}
		sort.push(s);		
	}
	
	static String findLongestPathDAG(boolean[][] isDigraph) {
		toposort(isDigraph);
		int[] dist = new int[26];
		int[] p = new int[26];
		
		Arrays.fill(p, -1);
		
		while (!sort.isEmpty()) {
			int cur = sort.pop();
			for (int next = 0; next < 26; ++next) {
				if (!isDigraph[cur][next] && dist[cur] + 1 > dist[next]) {
					dist[next] = dist[cur] + 1;
					p[next] = cur;
				}
			}
		}
		
		int maxAt = 0;
		for (int i = 0; i < 26; ++i) {
			if (dist[i] > dist[maxAt]) {
				maxAt = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int cur = maxAt;
		while (cur >= 0) {
			sb.insert(0, (char) (cur + 'a'));
			cur = p[cur];
		}
		
		return sb.toString();
	}
	
	static String findPath(boolean[][] isDigraph) {
		String cycle = findCycle(isDigraph);
		if (!cycle.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < MAX_DEPTH; ++i)
				sb.append(cycle.charAt(i % cycle.length()));
			return sb.toString();
		} else {
			return findLongestPathDAG(isDigraph);
		}
	}
	
	static void solve(boolean[][] isDigraph) {
		printSquare(findPath(isDigraph));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			
			boolean[][] isDigraph = new boolean[26][26];
			for (int i = 0; i < n; ++i) {
				String pair = in.next();
				isDigraph[pair.charAt(0) - 'a'][pair.charAt(1) - 'a'] = true;
			}
			
			solve(isDigraph);
		}
		
		in.close();
		System.exit(0);
	}
}
