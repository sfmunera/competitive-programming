package uva;

import java.io.*;
import java.util.*;


public class UVa12085_MobileCasanova {
	
	static boolean isConsecutive(String n1, String n2) {
		int l1 = n1.length();
		int l2 = n2.length();
		
		int i = 0;
		for (; i < Math.min(l1, l2); ++i)
			if (n1.charAt(i) != n2.charAt(i))
				break;
		
		String suf1 = n1.substring(i, l1);
		String suf2 = n2.substring(i, l2);
		
		if (suf1.isEmpty() || suf2.isEmpty())
			return false;
		
		return Integer.parseInt(suf1) + 1 == Integer.parseInt(suf2);
	}
	
	static String format(String[] numbers, int i, int j) {
		if (i == j)
			return numbers[i];
		
		int l1 = numbers[i].length();
		int l2 = numbers[j].length();
		
		int k = 0;
		for (; k < Math.min(l1, l2); ++k)
			if (numbers[i].charAt(k) != numbers[j].charAt(k))
				break;
		
		String suf1 = numbers[i].substring(k, l1);
		String suf2 = numbers[j].substring(k, l2);
		
		return numbers[i].substring(0, k) + suf1 + "-" + suf2;
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int t = 1;
		while (true) {
			int N = in.nextInt();
			if (N == 0) break;
			
			String[] numbers = new String[N];
			
			for (int i = 0; i < N; ++i)
				numbers[i] = in.next();
			
			System.out.println("Case " + t + ":");
			int prev = -1;
			for (int i = 0; i < N; ++i) {
				if (i == 0 || (i > 0 && !isConsecutive(numbers[i - 1], numbers[i]))) {
					if (i > 0)
						System.out.println(format(numbers, prev, i - 1));
					prev = i;
				}
			}
			System.out.println(format(numbers, prev, N - 1));
			System.out.println();
			++t;
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
