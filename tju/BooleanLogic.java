package tju;

import java.io.*;
import java.util.*;

public class BooleanLogic {
	
	static String[] go(String expression, String p, String values) {
		String[] ans = new String[2]; // ans[0]: string, ans[1]: value

		if (expression.length() == 1 && (expression.charAt(0) >= 'a' && expression.charAt(0) <= 'z')) {
			ans[0] = ans[1] = "" + values.charAt(p.indexOf(expression.charAt(0)));
			return ans;
		}
		
		expression = expression.substring(1, expression.length() - 1);
		
		if (expression.charAt(0) == '!') {
			String[] val = go(expression.substring(1), p, values);
			boolean c = val[1].charAt(0) == '0' ? false : true;
			ans[1] = "" + (c ? '0' : '1');
			ans[0] = ans[1] + val[0];
			return ans;
		}
		
		String left = "";
		String right = "";
		
		int cnt = 0;
		int k = 0;
		for (; k < expression.length(); ++k) {
			if (expression.charAt(k) == '(') ++cnt;
			else if (expression.charAt(k) == ')') --cnt;
			if (cnt == 0) {
				left = expression.substring(0, k + 1);
				break;
			}
		}
		
		++k;
		String op = "";
		for (; k < expression.length(); ++k) {
			if (expression.charAt(k) == '(' || (expression.charAt(k) >= 'a' && expression.charAt(k) <= 'z'))
				break;
			op += expression.charAt(k);
		}
		
		cnt = 0;
		int l = k;
		for (; k < expression.length(); ++k) {
			if (expression.charAt(k) == '(') ++cnt;
			else if (expression.charAt(k) == ')') --cnt;
			if (cnt == 0) {
				right = expression.substring(l, k + 1);
				break;
			}
		}
		
		String[] val1 = go(left, p, values);
		String[] val2 = go(right, p, values);
		
		boolean c1 = val1[1].charAt(0) == '0' ? false : true;
		boolean c2 = val2[1].charAt(0) == '0' ? false : true;
		
		boolean c = true;

		if (op.equals("&"))
			c = c1 && c2;
		else if (op.equals("|"))
			c = c1 || c2;
		else if (op.equals("-->"))
			c = !c1 || c2;
		else if (op.equals("<->"))
			c = c1 == c2;
		
		ans[1] = "" + (c ? '1' : '0');
		ans[0] = val1[0] + ans[1] + val2[0];
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String expression = "";
			String p = "";
			TreeSet<Character> set = new TreeSet<Character>();
			
			for (int i = 0; i < line.length(); ++i) {
				char c = line.charAt(i);
				if (c != ' ') expression += c;
				if (c >= 'a' && c <= 'z')
					set.add(c);
			}
			for (char c : set)
				p += c;
			p = new StringBuilder(p).reverse().toString();
			int N = p.length();
			
			System.out.println(line);
			for (int mask = 0; mask < (1 << N); ++mask) {
				String values = "";
				for (int i = 0; i < N; ++i)
					values += ((mask & (1 << i)) == 0 ? 0 : 1);

				String[] val = go(expression, p, values);
				
				boolean[] put = new boolean[expression.length()];
				for (int i = 0; i < expression.length(); ++i) {
					char c = expression.charAt(i);
					if ((c >= 'a' && c <= 'z') || c == '!' || c == '&' || c == '|' ||
						(i > 0 && i < expression.length() - 1 && 
								(expression.charAt(i - 1) == '-' || expression.charAt(i - 1) == '<') && 
								c == '-' && expression.charAt(i + 1) == '>'))
						put[i] = true;
				}
				
				String ans = "";
				int j = 0;
				int k = 0;
				for (int i = 0; i < line.length(); ++i) {
					if (line.charAt(i) == ' ') {
						ans += " ";
						continue;
					}
					if (put[j++]) ans += val[0].charAt(k++);
					else ans += " ";
				}
				System.out.println(ans);
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
