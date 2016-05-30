package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.math.*;

public class SpecialTask {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String s = in.next();
		
		int numUnknowns = 0;
		Set<Character> letters = new HashSet<Character>();
		boolean firstUnknown = false;
		boolean firstLetter = false;
		
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '?') {
				++numUnknowns;
				if (i == 0)
					firstUnknown = true;
			}
			if (Character.isAlphabetic(s.charAt(i))) {
				letters.add(s.charAt(i));
				if (i == 0)
					firstLetter = true;
			}
		}

		StringBuilder ans = new StringBuilder();
		int val = 1;
		int numDiff = letters.size();
		for (int i = 0; i < numDiff ; ++i) {
			if (firstLetter) {
				val *= 9;
				firstLetter = false;
			} else {
				val *= (10 - i);
			}
		}
		if (firstUnknown) {
			val *= 9;
			--numUnknowns;
		}
		ans.append(String.valueOf(val));
		
		for (int i = 0; i < numUnknowns; ++i) {
			ans.append("0");
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
