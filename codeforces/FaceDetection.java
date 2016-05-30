package codeforces;

import java.io.*;
import java.util.*;

public class FaceDetection {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		char[][] image = new char[n][m];
		for (int i = 0; i < n; ++i) {
			image[i] = in.next().toCharArray();
		}
		
		int ans = 0;
		for (int i = 0; i < n - 1; ++i) {
			for (int j = 0; j < m - 1; ++j) {
				char[] face = {image[i][j], image[i + 1][j], image[i][j + 1], image[i + 1][j + 1]};
				
				Arrays.sort(face);
				if (face[0] == 'a' && face[1] == 'c' && face[2] == 'e' && face[3] == 'f') {
					++ans;
				}
			}
		}
		System.out.println(ans);
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
