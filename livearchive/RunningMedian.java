package livearchive;

import java.io.*;
import java.util.*;

public class RunningMedian {
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int M = in.nextInt();
			
			PriorityQueue<Integer> most = new PriorityQueue<Integer>();
			PriorityQueue<Integer> least = new PriorityQueue<Integer>();
			
			ArrayList<Integer> medians = new ArrayList<Integer>();
			
			int first = in.nextInt();
			medians.add(first);
			for (int i = 1; i < M; ++i) {
				int x = in.nextInt();
				
				if (i == 1) {
					if (x < first) {
						least.add(-x);
						most.add(first);
					} else {
						least.add(-first);
						most.add(x);
					}
				} else if (most.isEmpty() && least.isEmpty())
					most.add(x);
				else if (least.isEmpty())
					least.add(-x);
				else if (x > most.peek())
					most.add(x);
				else
					least.add(-x);
				
				if (most.size() > least.size() + 1)
					least.add(-most.poll());
				else if (least.size() > most.size() + 1)
					most.add(-least.poll());
				
				if (i % 2 == 1) continue;
				if (least.size() > most.size())
					medians.add(-least.peek());
				else
					medians.add(most.peek());

			}
			
			System.out.println(n + " " + medians.size());
			for (int i = 1; i <= medians.size(); ++i) {
				System.out.print(medians.get(i - 1));
				if (i % 10 == 0 || i == medians.size())
					System.out.println();
				else
					System.out.print(" ");
			}
			
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
