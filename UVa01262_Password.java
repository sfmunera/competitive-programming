package uva;

import java.io.*;
import java.util.*;

public class UVa01262_Password {
	
	static final int ROWS = 6;
	static final int COLS = 5;
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int K = in.nextInt();
			char[][] letters = new char[COLS][ROWS];
			int[] len = new int[COLS];
			
			char[][] mat1 = new char[ROWS][COLS], mat2 = new char[ROWS][COLS];
			for (int i = 0; i < ROWS; ++i)
				mat1[i] = in.next().toCharArray();
			for (int i = 0; i < ROWS; ++i)
				mat2[i] = in.next().toCharArray();
			
			HashSet<Character> first, second;
			for (int j = 0; j < COLS; ++j) {
				Arrays.fill(letters[j], 'x');
				first = new HashSet<Character>();
				second = new HashSet<Character>();
				for (int i = 0; i < ROWS; i++) {
					first.add(mat1[i][j]);
					second.add(mat2[i][j]);
				}
				first.retainAll(second);
				for (Character x : first)
					letters[j][len[j]++] = x;
			}

			int numPossible = 1;		
			for (int j = 0; j < COLS; ++j) {
				numPossible *= len[j];
				Arrays.sort(letters[j]);
			}
			
			if (K > numPossible)
				System.out.println("NO");
			else {
				--K;
				int size = numPossible / len[0];
				String ans = "";
				for (int j = 0; j < COLS; ++j) {
					ans += letters[j][K / size];
					K %= size;
					if (j + 1 < COLS)
						size /= len[j + 1];
				}
				System.out.println(ans);
			}
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
