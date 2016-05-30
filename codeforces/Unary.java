package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Unary {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		String program = in.next();
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('>', "1000");
		map.put('<', "1001");
		map.put('+', "1010");
		map.put('-', "1011");
		map.put('.', "1100");
		map.put(',', "1101");
		map.put('[', "1110");
		map.put(']', "1111");
		
		String code = "";
		for (int i = 0; i < program.length(); ++i)
			code += map.get(program.charAt(i));
		
		int mod = 1000003;
		int pow = 1;
		int ans = 0;
		for (int i = code.length() - 1; i >= 0; --i) {
			ans += pow * (code.charAt(i) - '0');
			ans %= mod;
			pow <<= 1;
			pow %= mod;
		}
		System.out.println(ans);
		
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
