package facebook;

import java.util.*;
import java.io.*;

public class CorporateGifting {
	
	static final int MAX_PAY = 20;
	
	static class Node {
		int id;
		Node dad;
		List<Node> children;
		public Node(int id, Node dad) {
			this.id = id;
			this.dad = dad;
			this.children = new ArrayList<Node>();
		}
		@Override public String toString() {
			return "" + this.id;
		}
	}
	
	static long[][] dp;
	static Node[] tree;
	static int N;
	
	static Node[] topsort(Node[] tree) {
		// Do topological sort with BFS
		Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
		Node[] sorted = new Node[N + 1];
		Queue<Node> Q = new LinkedList<Node>();
		Q.offer(tree[1]);
		sorted[0] = tree[0];
		sorted[1] = tree[1];
		mapIndex.put(1, 1);
		
		int k = 2;
		while (!Q.isEmpty()) {
			Node node = Q.poll();
			for (Node c : node.children) {
				Q.offer(c);
				mapIndex.put(c.id, k);
				sorted[k++] = c;
			}
		}
		tree = null;
		
		Q.offer(sorted[1]);		
		while (!Q.isEmpty()) {
			Node node = Q.poll();
			node.id = mapIndex.get(node.id);
			for (Node c : node.children) {
				Q.offer(c);
			}
		}
		
		return sorted;
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(new File("D.in")));
		System.setOut(new PrintStream(new File("D.out")));
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(in.readLine());
			String line = in.readLine();
			StringTokenizer stk = new StringTokenizer(line);
			
			tree = new Node[N + 1];
			for (int i = 0; i <= N; ++i)
				tree[i] = new Node(i, null);
			
			for (int k = 1; k <= N; ++k) {
				int dad = Integer.parseInt(stk.nextToken());
				tree[k].dad = tree[dad];
				tree[dad].children.add(tree[k]);
			}
			tree = topsort(tree);
			
			dp = new long[N + 1][MAX_PAY + 1];
			for (int i = 0; i <= N; ++i)
				for (int j = 0; j <= MAX_PAY; ++j)
					dp[i][j] = (long)N * N;
			
			for (int i = N; i >= 1; --i) {
				for (int j = 1; j <= MAX_PAY; ++j) {
					for (int m = 1; m <= MAX_PAY; ++m) {
						if (j != m) {
							long sum = 0;
							for (Node child : tree[i].children) {
								sum += dp[child.id][m];
							}
							dp[i][j] = Math.min(dp[i][j], m + sum);
						}
					}
				}
			}
			
			long ans = (long)N * N;
			for (int j = 0; j <= MAX_PAY; ++j)
				ans = Math.min(ans, dp[1][j]);
			System.out.println("Case #" + t + ": " + ans);
		}
		
		in.close();
	}
}
