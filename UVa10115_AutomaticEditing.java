package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa10115_AutomaticEditing {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		while (true) {
			int R = in.nextInt();
			if (R == 0)
				break;
			
			String[] find = new String[R];
			String[] by = new String[R];
			
			for (int i = 0; i < R; ++i) {
				find[i] = in.nextLine();
				by[i] = in.nextLine();
			}
			String str = in.nextLine();
			
			for (int i = 0; i < R; ++i) {
				while (true) {
					String prev = str;
					str = str.replaceFirst(find[i], by[i]);
					if (prev.equals(str))
						break;
				}
			}
			
			System.out.println(str);
		}
		
		System.exit(0);
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
