package codeforces;

import java.io.*;
import java.util.*;

public class HelpKingdomOfFarFarAway2 {
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String number = in.next();
		
		boolean negative = number.charAt(0) == '-';
		if (negative) number = number.substring(1);
		
		String[] parts = number.split("\\.");
		String decimal = parts[0];
		String fractional = parts.length == 1 ? "00" : parts[1].length() <= 2 ? parts[1] : parts[1].substring(0, 2);
		
		if (fractional.length() == 1)
			fractional += "0";
		
		if (decimal.length() > 3) {
			ArrayList<Integer> inds = new ArrayList<Integer>();
			for (int i = 3; decimal.length() - i > 0; i += 3)
				inds.add(decimal.length() - i);
			
			String tmp = decimal.substring(0, inds.get(inds.size() - 1));
			for (int i = inds.size() - 1; i >= 0; --i) {
				tmp += ",";
				tmp += decimal.substring(inds.get(i), i > 0 ? inds.get(i - 1) : decimal.length());
			}
			
			decimal = tmp;
		}
		
		System.out.println((negative ? "(" : "") + "$" + decimal + "." + fractional + (negative ? ")" : ""));
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
