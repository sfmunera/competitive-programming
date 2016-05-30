package codeforces;

import java.io.*;
import java.util.*;

public class Bets {
	
	static class Player implements Comparable<Player> {
		int index, t, c;
		Player(int index, int t, int c) {
			this.index = index;
			this.t = t;
			this.c = c;
		}
		@Override
		public int compareTo(Player that) {
			if (this.t != that.t)
				return this.t - that.t;
			return this.index - that.index;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		List<PriorityQueue<Player>> players = new ArrayList<PriorityQueue<Player>>();
		for (int i = 0; i < n; ++i) {
			players.add(new PriorityQueue<Player>());
		}
		
		for (int i = 0; i < m; ++i) {
			int l = in.nextInt() - 1;
			int r = in.nextInt() - 1;
			int t = in.nextInt();
			int c = in.nextInt();
			
			for (int j = l; j <= r; ++j) {
				players.get(j).add(new Player(i, t, c));
			}
		}
		
		int profit = 0;
		for (int i = 0; i < n; ++i) {
			if (!players.get(i).isEmpty()) {
				Player top = players.get(i).poll();
				profit += top.c;
			}
		}
		
		System.out.println(profit);
	}
	

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = new StringTokenizer("");
		}

		public String next() {
			try {
				while (!tokenizer.hasMoreTokens())
					tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			
			return tokenizer.nextToken();
		}
		
		public String nextLine() {
			String line = null;
			try {
				tokenizer = new StringTokenizer("");
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
		
		boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return false;
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }
	}
}
