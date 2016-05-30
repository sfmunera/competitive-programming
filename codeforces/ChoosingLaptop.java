package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChoosingLaptop {
	
	static class Laptop {
		int speed, ram, hdd, cost;
		public Laptop(int speed, int ram, int hdd, int cost) {
			this.speed = speed;
			this.ram = ram;
			this.hdd = hdd;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int N = in.nextInt();
		Laptop[] laptops = new Laptop[N];
		boolean[] suitable = new boolean[N];
		
		Arrays.fill(suitable, true);
		
		for (int i = 0; i < N; ++i) {
			int speed = in.nextInt();
			int ram = in.nextInt();
			int hdd = in.nextInt();
			int cost = in.nextInt();
			
			laptops[i] = new Laptop(speed, ram, hdd, cost);
		}
		
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (laptops[i].speed < laptops[j].speed &&
						laptops[i].ram < laptops[j].ram &&
						laptops[i].hdd < laptops[j].hdd)
					suitable[i] = false;
		
		int minAt = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; ++i) {
			if (!suitable[i])
				continue;
			if (laptops[i].cost < min) {
				min = laptops[i].cost;
				minAt = i;
			}
		}
		
		System.out.println(minAt + 1);
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
