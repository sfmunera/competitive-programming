package uva;

import java.util.*;
import java.io.*;

public class UVa11198_DancingDigits {
	
	static Set<Integer> primes;
	
	static int bfs(String s, boolean[] female) {
		Queue<String> Q = new LinkedList<String>();
		Set<String> seen = new HashSet<String>();
		Map<String, Integer> dist = new HashMap<String, Integer>();
		
		Q.offer(s);
		seen.add(s);
		dist.put(s, 0);
		while (!Q.isEmpty()) {
			String x = Q.poll();
			if (x.equals("12345678"))
				return dist.get(x);
			for (int i = 0; i < 8; ++i)
				for (int j = i + 1; j < 8; ++j) {
					char ci = x.charAt(i);
					char cj = x.charAt(j);
					if (female[ci  -'0'] == female[cj - '0'])
						continue;
					if (!primes.contains((ci - '0') + (cj - '0')))
						continue;
					
					String lefti = x.substring(0, i);
					String righti = x.substring(i + 1, j);
					String rightj = x.substring(j + 1);
					
					String[] next = {lefti + ci + cj + righti + rightj,
									 lefti + cj + ci + righti + rightj,
									 lefti + righti + ci + cj + rightj,
									 lefti + righti + cj + ci + rightj};
					
					for (int k = 0; k < 4; ++k)
						if (!seen.contains(next[k])) {
							seen.add(next[k]);
							dist.put(next[k], dist.get(x) + 1);
							Q.offer(next[k]);
						}
				}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		primes = new HashSet<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		primes.add(11);
		primes.add(13);
		
		int t = 1;
		while (true) {
			int first = in.nextInt();
			if (first == 0)
				break;
			
			boolean[] female = new boolean[9];
			String permutation = "" + Math.abs(first);
			if (first < 0)
				female[-first] = true;
			
			for (int i = 1; i < 8; ++i) {
				int x = in.nextInt();
				permutation += Math.abs(x);
				if (x < 0)
					female[-x] = true;
			}
			
			int ans = bfs(permutation, female);
			System.out.println("Case " + t++ + ": " + ans);
		}
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
