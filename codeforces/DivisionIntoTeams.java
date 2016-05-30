package codeforces;

import java.io.*;
import java.util.*;

public class DivisionIntoTeams {
	
	static class Player implements Comparable<Player> {
		int skill, number;
		public Player(int skill, int number) {
			this.skill = skill;
			this.number = number;
		}
		@Override
		public int compareTo(Player p) {
			return this.skill - p.skill;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		Player[] a = new Player[n];
		
		for (int i = 0; i < n; ++i)
			a[i] = new Player(in.nextInt(), i + 1);
		
		Arrays.sort(a);
		
		ArrayList<Integer> p = new ArrayList<Integer>();
		ArrayList<Integer> q = new ArrayList<Integer>();
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 0; i < n / 2 * 2; ++i)
			if (i % 2 == 0) {
				p.add(a[i].number);
				sum1 += a[i].skill;
			} else {
				q.add(a[i].number);
				sum2 += a[i].skill;
			}
		
		if (n % 2 == 1) {
			if (sum1 < sum2)
				p.add(a[n - 1].number);
			else
				q.add(a[n - 1].number);
		}
		
		System.out.println(p.size());
		System.out.print(p.get(0));
		for (int i = 1; i < p.size(); ++i)
			System.out.print(" " + p.get(i));
		System.out.println();
		
		System.out.println(q.size());
		System.out.print(q.get(0));
		for (int i = 1; i < q.size(); ++i)
			System.out.print(" " + q.get(i));
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
