package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVa00340_MasterMindHints {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		int t = 1;
		while (true) {
			int N = in.nextInt();
			if (N == 0)
				break;
			
			int[] code = new int[N];
			for (int i = 0; i < N; ++i)
				code[i] = in.nextInt();
			System.out.println("Game " + t + ":");
			
			while (true) {
				int[] guess = new int[N];
				for (int i = 0; i < N; ++i)
					guess[i] = in.nextInt();
				
				if (guess[0] == 0)
					break;
				
				int strong = 0;
				int weak = 0;
				boolean[] seenCode = new boolean[N];
				boolean[] seenGuess = new boolean[N];
				for (int i = 0; i < N; ++i)
					if (code[i] == guess[i]) {
						++strong;
						seenCode[i] = true;
						seenGuess[i] = true;
					}
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j)
						if (i != j && !seenCode[i] && !seenGuess[j] && code[i] == guess[j]) {
							++weak;
							seenCode[i] = true;
							seenGuess[j] = true;
						}
				System.out.println("    (" + strong + "," + weak + ")");
			}
			++t;
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
