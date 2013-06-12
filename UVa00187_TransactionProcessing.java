package uva;

import java.io.*;
import java.util.*;

public class UVa00187_TransactionProcessing {

	static class TransactionLine {
		String seq;
		String acc;
		double val;
		public TransactionLine(String seq, String acc, double val) {
			this.seq = seq;
			this.acc = acc;
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		HashMap<String, String> accounts = new HashMap<String, String>();
		
		while (true) {
			String acc = in.nextLine();
			if (acc.startsWith("000"))
				break;
			String number = acc.substring(0, 3);
			String name = acc.substring(3);
			accounts.put(number, name);
		}
		
		ArrayList<TransactionLine> lines = new ArrayList<TransactionLine>();
		String prev = "";
		while (true) {
			String line = in.nextLine();
			if (line.startsWith("000"))
				break;
			String seq = line.substring(0, 3);
			String acc = line.substring(3, 6);
			double val = Double.parseDouble(line.substring(6).trim()) / 100.0;
			
			if (!seq.equals(prev)) {
				double sum = 0.0;
				for (TransactionLine l : lines) {
					sum += l.val;
				}
				if (sum != 0.0) {
					System.out.println("*** Transaction " + lines.get(0).seq + " is out of balance ***");
					for (TransactionLine l : lines) {
						StringBuilder sb = new StringBuilder();
						sb.append(l.acc + " ");
						sb.append(accounts.get(l.acc));
						for (int i = 0; i < 30 - accounts.get(l.acc).length(); ++i)
							sb.append(" ");
						sb.append(" ");
						sb.append(String.format(Locale.ENGLISH, "%10.2f", l.val));
						System.out.println(sb);
					}
					System.out.println("999 Out of Balance                 " + String.format(Locale.ENGLISH, "%10.2f", Math.abs(sum)));
					System.out.println();
				}
				lines.clear();
				prev = seq;
			}
			lines.add(new TransactionLine(seq, acc, val));
		}
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
