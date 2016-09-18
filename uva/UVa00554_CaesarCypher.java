package uva;

import java.util.*;
import java.io.*;

public class UVa00554_CaesarCypher {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		String abc = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		HashSet<String> dict = new HashSet<String>();
		while (true) {
			String word = in.next();
			if (word.equals("#"))
				break;
			dict.add(word);
		}
		
		String message = in.nextLine();
		int max = 0;
		String decoded = "";
		for (int k = 0; k < 27; ++k) {
			String tmp = "";
			for (int i = 0; i < message.length(); ++i) {
				int val = abc.indexOf(message.charAt(i));
				tmp += abc.charAt((val - k + 27) % 27);
			}
			String[] parts = tmp.split("[ ]+");
			int cnt = 0;
			for (String p : parts)
				if (dict.contains(p))
					++cnt;
			if (cnt > max) {
				max = cnt;
				decoded = tmp;
			}
		}
		HashMap<Integer, Integer> nextStart = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> nextEnd = new HashMap<Integer, Integer>();
		HashSet<Integer> ends = new HashSet<Integer>();
		int lastEnd = 0;
		for (int i = 0; i < decoded.length(); ++i) {
			if (i > 0 && decoded.charAt(i - 1) == ' ' && decoded.charAt(i) != ' ')
				nextStart.put(lastEnd, i);
			if (i < decoded.length() - 1 && decoded.charAt(i) != ' ' && decoded.charAt(i + 1) == ' ') {
				ends.add(i);
				nextEnd.put(lastEnd, i);
				lastEnd = i;
			}
		}
		decoded = decoded.trim();
		int cut = 0;
		for (int i = 0; i < decoded.length(); ++i) {
			System.out.print(decoded.charAt(i));
			if (ends.contains(i) && nextEnd.containsKey(i) && 
					(i - cut) / 60 != (nextEnd.get(i) - cut) / 60) {
				System.out.println();
				cut = nextStart.get(i);
				i = cut - 1;
			}
		}
		System.out.println();
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
