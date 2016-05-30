package codeforces;

import java.io.*;
import java.util.*;

public class StringTask {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String str = in.next();
		String vowels = "AOYEUIaoyeui";
		
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			if (vowels.contains("" + str.charAt(i)))
				continue;
			output.append(".");
			output.append(Character.toLowerCase(str.charAt(i)));
		}
		
		System.out.println(output);
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
