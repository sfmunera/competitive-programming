package uva;

import java.util.*;
import java.io.*;

public class UVa00551_NestingABunchOfBrackets {
	static boolean isOpening(char c) {
		return c == '(' || c == '[' || c == '{' || c == '<';
	}

	static boolean match(String op, String cl) {
		return (op.equals("(*") && cl.equals("*)")) ||
		       (op.equals("(") && cl.equals(")")) ||
                       (op.equals("[") && cl.equals("]")) ||
                       (op.equals("{") && cl.equals("}")) ||
                       (op.equals("<") && cl.equals(">"));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = in.readLine()) != null) {
			Stack<String> stack = new Stack<String>();
			int posError = -1;
			int pos = 0;
			for (int i = 0; i < line.length() && posError == -1; ++i) {
				if (i < line.length() - 1 && line.charAt(i) == '(' && line.charAt(i + 1) == '*') {
					stack.push("" + line.charAt(i) + line.charAt(i + 1));
					++i;
				} else if (isOpening(line.charAt(i)))
                                        stack.push("" + line.charAt(i));
				else if (i < line.length() - 1 && line.charAt(i) == '*' && line.charAt(i + 1) == ')') {
					if (stack.isEmpty()) {
						posError = pos + 1;
						break;
					}
					String top = stack.pop();
                                        if (!top.equals("(*"))
						posError = pos + 1;
                                        ++i;
                                } else if (line.charAt(i) == ')' || line.charAt(i) == ']' || line.charAt(i) == '}' || 
						line.charAt(i) == '>') {
                                        if (stack.isEmpty()) {
                                                posError = pos + 1;
                                                break;
                                        }
                                        String top = stack.pop();
					if (!match(top, "" + line.charAt(i)))
						posError = pos + 1;
				}
				++pos;
			}
			if (posError == -1 && !stack.isEmpty())
				posError = pos + 1;
			System.out.println(posError == -1 ? "YES" : ("NO " + posError));
		}
		
		in.close();
		System.exit(0);
	}
}
