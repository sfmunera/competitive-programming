package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class AmrAndMusic {
	
	static class Instrument implements Comparable<Instrument> {
		int id, days;
		public Instrument(int id, int days) {
			this.id = id;
			this.days = days;
		}
		@Override
		public int compareTo(Instrument o) {
			return this.days - o.days;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		Instrument[] inst = new Instrument[n];
		for (int i = 0; i < n; ++i)
			inst[i] = new Instrument(i + 1, in.nextInt());
		
		Arrays.sort(inst);
		
		List<Instrument> selected = new ArrayList<Instrument>();
		for (Instrument i : inst) {
			if (i.days <= k) {
				k -= i.days;
				selected.add(i);
			}
		}
		
		System.out.println(selected.size());
		boolean first = true;
		for (Instrument i : selected) {
			if (first) first = false; else System.out.print(" ");
			System.out.print(i.id);
		}
		System.out.println();
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
