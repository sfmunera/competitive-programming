package uva;

import java.io.*;
import java.util.*;

public class UVa11535_SetOfMarbles {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int T = in.nextInt();
		
		while (T-- > 0) {
			int N = in.nextInt();
			int b1 = in.nextInt();
			
			int set = 0;
			for (int i = 0; i < b1; ++i) {
				int x = in.nextInt();
				set |= (1 << (x - 1));
			}
			
			boolean[] seen = new boolean[1 << N];
			for (int i = 0; i < (1 << N) - 1; ++i) {
				seen[set] = true;
				for (int j = 0; j < N; ++j) {
					if (!seen[set ^ (1 << j)]) {
						boolean toRight = (set & (1 << j)) > 0;
						System.out.println("Move " + (j + 1) + " from B" + (toRight ? "1" : "2") + " to B" + (toRight ? "2" : "1"));
						set ^= (1 << j);
						break;
					}
				}
			}
			System.out.println();
		}
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
