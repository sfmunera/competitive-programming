package codeforces;

import java.util.*;
import java.io.*;

public class Report {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			a.add(in.nextInt());
		}
		
		int[] t = new int[m];
		int[] r = new int[m];
		for (int i = 0; i < m; ++i) {
			t[i] = in.nextInt();
			r[i] = in.nextInt();
		}
		
		// locate increasing maximums from the last position in r
		List<Integer> sortingPoints = new ArrayList<Integer>();
		int max = 0;
		for (int i = m - 1; i >= 0; --i) {
			if (r[i] > max) {
				max = r[i];
				sortingPoints.add(i);
			}
		}
		Collections.reverse(sortingPoints);
		int numSortingPoints = sortingPoints.size();
		
		int[] ans = new int[n];
		int low = 0;
		int high = r[sortingPoints.get(0)] - 1;
		// put elements beyond high in the right order
		for (int i = high + 1; i < n; ++i)
			ans[i] = a.get(i);
		
		Collections.sort(a.subList(0, high + 1));
		// put the top r[cur] - r[next] elements in the order specified by t[cur]
		int ind = high;
		for (int i = 0; i < numSortingPoints; ++i) {
			int cur = sortingPoints.get(i);
			int nextPos = i == numSortingPoints - 1 ? 0 : r[sortingPoints.get(i + 1)];
			
			for (int j = 0; j < r[cur] - nextPos; ++j) {
				ans[ind--] = t[cur] == 1 ? a.get(high--) : a.get(low++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			if (i > 0) sb.append(" ");
			sb.append(ans[i]);
		}
		
		System.out.println(sb);
		
		System.exit(0);
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
