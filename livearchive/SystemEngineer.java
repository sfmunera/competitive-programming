package livearchive;

import java.util.*;

public class SystemEngineer {
	
	static boolean[] seen;
	static int[] match;
	static List<List<Integer>> graph;
	
	static boolean bpm(int u) {		
		for (int v : graph.get(u)) {
			if (seen[v]) continue;
			seen[v] = true;
			
			if (match[v] < 0 || bpm(match[v])) {
				match[u] = v;
				match[v] = u;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int n = in.nextInt();
			graph = new ArrayList<List<Integer>>();
			
			for (int i = 0; i < 2 * n; ++i) {
				graph.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < n; ++i) {
				in.next();
				String token = in.next();
				int m = Integer.parseInt(token.substring(1, token.length() - 1));
				
				for (int j = 0; j < m; ++j) {
					int s = in.nextInt();
					graph.get(i).add(s);
					graph.get(s).add(i);
				}
			}
			
			int ans = 0;
			match = new int[2 * n];
			Arrays.fill(match, -1);
			for (int i = 0; i < n; ++i) {
				seen = new boolean[2 * n];
				if (bpm(i)) {
					++ans;
				}
			}
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
