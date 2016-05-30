package codeforces;

import java.io.*;
import java.util.*;

public class JeffAndPeriods {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		
		int n = in.nextInt();
		for (int i = 0; i < n; ++i) {
			int x = in.nextInt();
			if (!map.containsKey(x))
				map.put(x, new ArrayList<Integer>());
			map.get(x).add(i);
		}
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> diffs = new ArrayList<Integer>();
		for (int x : map.keySet()) {
			int d = 0;
			boolean ok = true;
			
			ArrayList<Integer> inds = map.get(x);
			if (inds.size() > 1) {
				d = inds.get(1) - inds.get(0);
				for (int i = 2; i < inds.size() && ok; ++i)
					if (inds.get(i) - inds.get(i - 1) != d)
						ok = false;
			}
			
			if (ok) {
				nums.add(x);
				diffs.add(d);
			}
		}
		
		System.out.println(nums.size());
		for (int i = 0; i < nums.size(); ++i)
			System.out.println(nums.get(i) + " " + diffs.get(i));
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
