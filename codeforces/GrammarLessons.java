package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GrammarLessons {
	
	static class Word {
		int type; // 0: adjective, 1: noun, 2: verb
		boolean isMasculine;
		public Word(int type, boolean isMasculine) {
			this.type = type;
			this.isMasculine = isMasculine;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);

		String[] parts = in.nextLine().split("[ ]+");
		Word[] words = new Word[parts.length];
		
		boolean ok = true;
		for (int i = 0; i < parts.length; ++i)
			if (parts[i].endsWith("lios"))
				words[i] = new Word(0, true);
			else if (parts[i].endsWith("liala"))
				words[i] = new Word(0, false);
			else if (parts[i].endsWith("etr"))
				words[i] = new Word(1, true);
			else if (parts[i].endsWith("etra"))
				words[i] = new Word(1, false);
			else if (parts[i].endsWith("initis"))
				words[i] = new Word(2, true);
			else if (parts[i].endsWith("inites"))
				words[i] = new Word(2, false);
			else {
				ok = false;
				break;
			}
		if (ok && parts.length > 1) {
			int nouns = words[0].type == 1 ? 1 : 0;
			for (int i = 1; i < parts.length; ++i) {
				if (words[i].isMasculine != words[i - 1].isMasculine) {
					ok = false;
					break;
				}
				if (words[i].type - words[i - 1].type != 0 && words[i].type - words[i - 1].type != 1) {
					ok = false;
					break;
				}
				if (words[i].type == 1)
					++nouns;
			}
			if (nouns != 1)
				ok = false;
		}
		System.out.println(ok ? "YES" : "NO");
		
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
