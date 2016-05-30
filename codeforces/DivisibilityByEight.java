package codeforces;

import java.io.*;
import java.util.*;

public class DivisibilityByEight {

	static int checkDiv1(String n) {
		for (int i = 0; i < n.length(); ++i) {
			if ((n.charAt(i) - '0') % 8 == 0) {
				return n.charAt(i) - '0';
			}
		}
		return -1;
	}
	
	static int checkDiv2(String n) {
		for (int i = 0; i < n.length(); ++i) {
			for (int j = i + 1; j < n.length(); ++j) {
				if (n.charAt(i) == '0') continue;
				int sub = Integer.parseInt("" + n.charAt(i) + n.charAt(j));
				if (sub % 8 == 0) {
					return sub;
				}
			}
			
		}
		return -1;
	}
	
	static int checkDiv3(String n) {
		for (int i = 0; i < n.length(); ++i) {
			for (int j = i + 1; j < n.length(); ++j) {
				for (int k = j + 1; k < n.length(); ++k) {
					if (n.charAt(i) == '0') continue;
					int sub = Integer.parseInt("" + n.charAt(i) + n.charAt(j) + n.charAt(k));
					if (sub % 8 == 0) {
						return sub;
					}
				}
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String number = in.next();
		
		boolean found = false;
		int ans = checkDiv1(number);
		if (ans >= 0) {
			found = true;
		} else {
			ans = checkDiv2(number);
			if (ans >= 0) {
				found = true;
			} else {
				ans = checkDiv3(number);
				if (ans >= 0) {
					found = true;
				}
			}
		}
		
		if (found) {
			System.out.println("YES");
			System.out.println(ans);
		} else {
			System.out.println("NO");
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
