package codeforces;

import java.io.*;
import java.util.*;

public class PairsOfNumbers {
	
	static class Pair {
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		
		Pair s = new Pair(1, 1);
		int ans = 0;
		
		Queue<Pair> Q = new LinkedList<Pair>();
		Set<Pair> seen = new HashSet<Pair>();
		Map<Pair, Integer> dist = new HashMap<Pair, Integer>();
		
		Q.offer(s);
		seen.add(s);
		dist.put(s, 0);
		while (!Q.isEmpty()) {
			Pair p = Q.poll();
			int d = dist.get(p);
			if (p.a == n || p.b == n) {
				ans = d;
				break;
			}
			
			Pair n1 = new Pair(p.a + p.b, p.b);
			Pair n2 = new Pair(p.a, p.a + p.b);
			
			if (!seen.contains(n1)) {
				seen.add(n1);
				dist.put(n1, d + 1);
				Q.offer(n1);
			}
			if (!seen.contains(n2)) {
				seen.add(n2);
				dist.put(n2, d + 1);
				Q.offer(n2);
			}
		}
		
		System.out.println(ans);
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
