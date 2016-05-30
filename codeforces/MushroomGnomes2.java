package codeforces;

import java.io.*;
import java.util.*;

public class MushroomGnomes2 {
	
	static class Tree implements Comparable<Tree> {
		int a, h, l, r;
		public Tree(int a, int h, int l, int r) {
			this.a = a;
			this.h = h;
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(Tree t) {
			return this.a - t.a;
		}
	}
	
	static class Mushroom implements Comparable<Mushroom> {
		int b, z;
		double prob;
		public Mushroom(int b, int z) {
			this.b = b;
			this.z = z;
			this.prob = 1.0;
		}
		@Override
		public int compareTo(Mushroom m) {
			return this.b - m.b;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		Tree[] trees = new Tree[n];
		Mushroom[] mushrooms = new Mushroom[m];
		
		for (int i = 0; i < n; ++i) {
			int a = in.nextInt();
			int h = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			
			trees[i] = new Tree(a, h, l, r);
		}
		Arrays.sort(trees);
		
		for (int i = 0; i < m; ++i) {
			int b = in.nextInt();
			int z = in.nextInt();
			
			mushrooms[i] = new Mushroom(b, z);
		}
		Arrays.sort(mushrooms);
		
		
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
