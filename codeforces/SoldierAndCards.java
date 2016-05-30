package codeforces;

import java.io.*;
import java.util.*;

public class SoldierAndCards {
	
	static class State {
		String stack1, stack2;
		State(String stack1, String stack2) {
			this.stack1 = stack1;
			this.stack2 = stack2;
		}
		
		@Override public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (!(o instanceof State)) {
				return false;
			}
			State that = (State) o;
			return this.stack1.equals(that.stack1) && this.stack2.equals(that.stack2);
		}
		@Override public int hashCode() {
			return 17 + stack1.hashCode() * 31 + stack2.hashCode();
		}

	}
	
	static String pushBottom(String stack, int d) {
		return d + stack;
	}
	
	static String pushTop(String stack, int d) {
		return stack + d;
	}
	
	static String pop(String stack) {
		return stack.substring(0, stack.length() - 1);
	}
	
	static int top(String stack) {
		return stack.charAt(stack.length() - 1) - '0';
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		
		int n = in.nextInt();
		int k1 = in.nextInt();
		String stack1 = "";
		for (int i = 0; i < k1; ++i) {
			int x = in.nextInt() - 1;
			stack1 = pushBottom(stack1, x);
		}
		
		int k2 = in.nextInt();
		String stack2 = "";
		for (int i = 0; i < k2; ++i) {
			int x = in.nextInt() - 1;
			stack2 = pushBottom(stack2, x);
		}
		
		Set<State> seen = new HashSet<State>();
		seen.add(new State(stack1, stack2));
		
		int fights = 0;
		int winner = 0;
		boolean infinite = false;
		while (true) {
			++fights;
			int x1 = top(stack1); stack1 = pop(stack1); 
			int x2 = top(stack2); stack2 = pop(stack2); 
			
			if (x1 > x2) {
				stack1 = pushBottom(stack1, x2);
				stack1 = pushBottom(stack1, x1);
			} else {
				stack2 = pushBottom(stack2, x1);
				stack2 = pushBottom(stack2, x2);
			}
			
			if (stack1.isEmpty()) {
				winner = 2;
				break;
			}
			if (stack2.isEmpty()) {
				winner = 1;
				break;
			}
			
			State s = new State(stack1, stack2);
			if (seen.contains(s)) {
				infinite = true;
				break;
			}
			seen.add(s);
		}
		
		if (infinite) {
			System.out.println(-1);
		} else {
			System.out.println(fights + " " + winner);
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
