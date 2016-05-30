package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ProgrammingLanguage {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		Map<String, String> variableType = new HashMap<String, String>();
		ArrayList<String[]> functions = new ArrayList<String[]>();
		
		int N = in.nextInt();
		for (int i = 0; i < N; ++i) {
			char[] line = in.nextLine().toCharArray();
			String tmp = "";
			
			for (char c : line)
				if (c != ' ')
					tmp += c;
			tmp = tmp.substring(4, tmp.length() - 1);
			
			String[] parts = tmp.split("[\\(,]");

			functions.add(parts);
		}
		
		int M = in.nextInt();
		for (int i = 0; i < M; ++i) {
			String[] parts = in.nextLine().trim().split("[ ]+");
			String type = parts[0];
			String name = parts[1];
			
			variableType.put(name, type);
		}
		
		int K = in.nextInt();
		for (int i = 0; i < K; ++i) {
			char[] line = in.nextLine().toCharArray();
			String tmp = "";
			
			for (char c : line)
				if (c != ' ')
					tmp += c;

			tmp = tmp.substring(0, tmp.length() - 1);
			
			String[] parts = tmp.split("[\\(,]");
			
			int cnt = 0;
			for (String[] f : functions) {
				if (!parts[0].equals(f[0]))
					continue;
				if (parts.length != f.length)
					continue;
				boolean ok = true;
				for (int j = 1; j < parts.length && ok; ++j) {
					String type = variableType.get(parts[j]);
					if (f[j].equals("T") || f[j].equals(type))
						continue;
					ok = false;
				}
				if (ok)
					++cnt;
			}
			
			System.out.println(cnt);
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
