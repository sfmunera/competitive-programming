package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class SuggestedFriends {
	
	static class Edge {
		int u, v;
		public Edge(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int m = in.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> names = new ArrayList<String>();
		HashMap<Integer, HashSet<Integer>> G = new HashMap<Integer, HashSet<Integer>>();
		Edge[] edges = new Edge[m];

		int n = 0;
		for (int i = 0; i < m; ++i) {
			String s1 = in.next();
			String s2 = in.next();
			
			if (!map.containsKey(s1)) {
				map.put(s1, n);
				names.add(s1);
				G.put(n, new HashSet<Integer>());
				++n;
			}
			if (!map.containsKey(s2)) {
				map.put(s2, n);
				names.add(s2);
				G.put(n, new HashSet<Integer>());
				++n;
			}
			int u = map.get(s1);
			int v = map.get(s2);
			G.get(u).add(v);
			G.get(v).add(u);
			edges[i] = new Edge(u, v);
		}
		map.clear();

		System.out.println(n);
		for (int u = 0; u < n; ++u) {
			int[] cnt = new int[n];
			for (int i = 0; i < m; ++i) {
				if (edges[i].u == u || edges[i].v == u)
					continue;
				if (G.get(u).contains(edges[i].u) && !G.get(u).contains(edges[i].v))
					++cnt[edges[i].v];
				else if (!G.get(u).contains(edges[i].u) && G.get(u).contains(edges[i].v))
					++cnt[edges[i].u];
			}
			
			int max = 0;
			for (int i = 0; i < n; ++i)
				max = Math.max(max, cnt[i]);
			
			int ans = 0;
			if (max > 0)
				for (int i = 0; i < n; ++i)
					if (cnt[i] == max)
						++ans;
			System.out.println(names.get(u) + " " + ans);
		}
		
		System.exit(0);
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
				line =  reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
