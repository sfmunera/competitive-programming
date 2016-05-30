package codeforces;

import java.util.*;
import java.io.*;

public class SinkingShip {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		ArrayList<String> rats = new ArrayList<String>();
		ArrayList<String> womenOrChildren = new ArrayList<String>();
		ArrayList<String> men = new ArrayList<String>();
		ArrayList<String> captain = new ArrayList<String>();
		
		int N = in.nextInt();
		for (int i = 0; i < N; ++i) {
			String name = in.next();
			String type = in.next();
			
			if (type.equals("rat"))
				rats.add(name);
			else if (type.equals("woman") || type.equals("child"))
				womenOrChildren.add(name);
			else if (type.equals("captain"))
				captain.add(name);
			else
				men.add(name);
		}
		
		for (String r : rats)
			System.out.println(r);
		for (String r : womenOrChildren)
			System.out.println(r);
		for (String r : men)
			System.out.println(r);
		for (String r : captain)
			System.out.println(r);
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
