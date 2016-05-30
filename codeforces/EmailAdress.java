package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EmailAdress {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String line = in.nextLine();
		
		String first = "";
		String last = "";
		if (line.startsWith("dot")) {
			first = "dot";
			line = line.substring(3);
		} else if (line.startsWith("at")) {
			first = "at";
			line = line.substring(2);
		}
		
		if (line.endsWith("dot")) {
			last = "dot";
			line = line.substring(0, line.length() - 3);
		} else if (line.endsWith("at")) {
			last = "at";
			line = line.substring(0, line.length() - 2);
		}
		
		line = line.replaceAll("dot", ".");
		line = line.replaceFirst("at", "@");
		System.out.println(first + line + last);
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
