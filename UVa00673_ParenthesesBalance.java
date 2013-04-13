package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 614 (673 - Parentheses Balance) */
/* SUBMISSION: 08790374 */
/* SUBMISSION TIME: 2011-04-28 21:14:08 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa00673_ParenthesesBalance {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            int n = Integer.parseInt(in.nextLine());
            while (n-- > 0) {
                String exp = in.nextLine();
                Stack<Character> stack = new Stack<Character>();

                for (int i = 0; i < exp.length(); ++i) {
                    char c = exp.charAt(i);
                    if (!stack.isEmpty() && stack.peek() == '(' && c == ')')
                        stack.pop();
                    else if (!stack.isEmpty() && stack.peek() == '[' && c == ']')
                        stack.pop();
                    else stack.push(c);
                }
                if (stack.isEmpty()) System.out.println("Yes");
                else System.out.println("No");
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
