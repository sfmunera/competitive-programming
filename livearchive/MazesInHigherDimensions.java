package livearchive;

import java.util.*;
import java.io.*;

public class MazesInHigherDimensions {
	
	static int ORIGIN_HASHCODE;
		
	static class HyperBlock {
		int[] coords;
		HyperBlock(int[] c) {
			this.coords = c.clone();
		}
		
		double distanceToOrigin() {
			long dist2 = 0;
			for (int i = 0; i < coords.length; ++i) {
				dist2 += (long) coords[i] * coords[i];
			}
			return Math.sqrt(dist2);
		}
		
		@Override public int hashCode() {
			int hash = 0;
			int pow = 1;
			for (int x : coords) {
				hash += pow * x;
				pow *= 53;
			}
			return hash;
		}
		@Override public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof HyperBlock)) return false;
			
			HyperBlock other = (HyperBlock) o;
			return this.coords.length == other.coords.length && this.hashCode() == other.hashCode();
		}
	}

	static Map<Integer, Long> dp;
	
	static long doDp(HyperBlock cur, Set<Integer> opaques) {
		int hashCur = cur.hashCode();
		if (hashCur == ORIGIN_HASHCODE) {
			return opaques.contains(ORIGIN_HASHCODE) ? 0 : 1;
		}
		
		if (dp.containsKey(hashCur)) {
			return dp.get(hashCur);
		}
		int D = cur.coords.length;
		int[] coords = new int[D];
		for (int i = 0; i < D; ++i) {
			coords[i] = cur.coords[i];
		}
		long ans = 0;
		for (int i = 0; i < D; ++i) {
			if (coords[i] <= 0) continue;
			--coords[i];
			HyperBlock next = new HyperBlock(coords);
			if (!opaques.contains(next.hashCode()) && Double.compare(cur.distanceToOrigin(), next.distanceToOrigin()) > 0) {
				ans += doDp(next, opaques);
			}
			++coords[i];
		}
		
		dp.put(hashCur, ans);
		return ans;
	}
	
	static long solve(HyperBlock destination, Set<Integer> opaques) {
		if (opaques.contains(destination.hashCode())) {
			return 0;
		}
		
		dp = new HashMap<Integer, Long>();
		return doDp(destination, opaques);
	}
	
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		
		int test = 1;
		StringBuilder sb = new StringBuilder();
		while (true) {
			int D = in.nextInt();
			int R = in.nextInt();
			
			if (D == 0 && R == 0) {
				break;
			}
			
			int[] destinationCoords = new int[D];
			for (int i = 0; i < D; ++i) {
				destinationCoords[i] = in.nextInt();
			}
			
			ORIGIN_HASHCODE = new HyperBlock(new int[D]).hashCode();
			HyperBlock destination = new HyperBlock(destinationCoords);
			Set<Integer> opaques = new HashSet<Integer>();
			for (int i = 0; i < R; ++i) {
				int[] opaque = new int[D];
				for (int j = 0; j < D; ++j) {
					opaque[j] = in.nextInt();
				}
				
				opaques.add(new HyperBlock(opaque).hashCode());
			}
			
			sb.append("Case " + test + ": " + solve(destination, opaques) + "\n");
			++test;
		}
		System.out.print(sb);
		
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
