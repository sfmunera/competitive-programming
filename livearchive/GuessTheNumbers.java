package livearchive;

import java.util.*;
import java.io.*;

public class GuessTheNumbers {
	
	static void swap(int[] c, int i, int j) {
		int t = c[i];
		c[i] = c[j];
		c[j] = t;
	}
	
	static boolean nextPermutation(int[] c) {
		int n = c.length;
		int k = -1;
		
		for (int i = n - 2; i >= 0; --i)
			if (c[i] < c[i + 1]) {
				k = i;
				break;
			}
		if (k == -1) return false;
		
		int l = 0;
		for (int i = n - 1; i >= 0; --i)
			if (c[k] < c[i]) {
				l = i;
				break;
			}
		swap(c, k, l);
		for (int i = k + 1; i < (n + k + 1) / 2; ++i)
			swap(c, i, n + k - i);
		return true;
	}
	
	static int eval(String exp) {
		if (exp.isEmpty())
			return 0;
		boolean isNumber = true;
		String tmp = "";
		for (int i = 0; i < exp.length(); ++i)
			if (Character.isDigit(exp.charAt(i))) {
				tmp += exp.charAt(i);
			} else {
				isNumber = false;
			}
		if (isNumber)
			return Integer.parseInt(tmp);
		
		int N = exp.length();
		if (N > 1 && exp.charAt(0) == '(' && exp.charAt(N - 1) == ')')
			exp = exp.substring(1, N - 1);
		System.out.println(exp);
		int i = 0;
		int ans1 = -1;
		int ans2 = -1;
		char op = ' ';
		while (i < exp.length()) {
			if (exp.charAt(i) == '(') {
				int cnt = 1;
				int j = i + 1;
				while (j < exp.length() && cnt != 0) {
					if (exp.charAt(j) == '(') ++cnt;
					if (exp.charAt(j) == ')') --cnt;
					++j;
				}
				//System.out.println(exp.substring(i, j));
		 		int ans = eval(exp.substring(i, j));
		 		
				if (ans1 == -1)
					ans1 = ans;
				else if (ans2 == -1)
					ans2 = ans;
				i = j;
			} else if (exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*') {
				op = exp.charAt(i);
				++i;
			} else {
				tmp = "";
				int j = i;
				while (j < exp.length() && Character.isDigit(exp.charAt(j))) {
					tmp += exp.charAt(j);
					++j;
				}
				int ans = Integer.parseInt(tmp);
				if (ans1 == -1)
					ans1 = ans;
				else if (ans2 == -1)
					ans2 = ans;
				i = j;
			}
		}
		
		if (op == '+')
			return ans1 + ans2;
		else if (op == '-')
			return ans1 - ans2;
		else
			return ans1 * ans2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int Z = Integer.parseInt(parts[1]);
			
			if (N == 0 && Z == 0) break;
			
			int[] unknowns = new int[N];
			
			for (int i = 0; i < N; ++i)
				unknowns[i] = Integer.parseInt(parts[i + 1]);
			int M = Integer.parseInt(parts[N + 1]);
			
			String exp = in.readLine();
			
			boolean ok = false;
			
			if (N == 1 && unknowns[0] == M)
				ok = true;
			else {
			
				Arrays.sort(unknowns);
				do {
					String[] parts2 = exp.split("[a-z]");
					String exp2 = parts2[0];
					
					int k = 0;
					for (int i = 1; i < parts2.length; ++i) {
						exp2 += unknowns[k];
						exp2 += parts2[i];
						++k;
					}
					
					if (eval(exp2) == M) {
						ok = true;
						break;
					}
				} while (nextPermutation(unknowns));
			}
			System.out.println(ok ? "YES" : "NO");
		}
		
		in.close();
		System.exit(0);
	}
}
