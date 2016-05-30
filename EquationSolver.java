import java.util.*;
import java.io.*;

public class EquationSolver {
	
	static class Pair {
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override public String toString() {
			return "[" + a + ", " + b + "]";
		}
	}
	
	static List<String> getVariables(String expression) {
		String[] parts = expression.split("[\\+\\*\\-\\(\\)=']+");
		List<String> vars = new ArrayList<String>();
		for (String x : parts) {
			if (x.isEmpty() || x.equals("0") || x.equals("1")) {
				continue;
			}
			vars.add(x);
		}
		
		return vars;
	}
	
	static boolean containsVariable(String expression, String variable) {
		if (expression == null || expression.isEmpty()) {
			return false;
		}

		for (String x : getVariables(expression)) {
			if (x.equals(variable)) {
				return true;
			}
		}
		
		return false;
	}
	
	static List<Pair> findParens(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		List<Pair> ans = new ArrayList<Pair>();
		
		for (int i = 0; i < expression.length(); ++i) {
			if (expression.charAt(i) == '(') {
				stack.push(i);
			} else if (expression.charAt(i) == ')') {
				int a = stack.pop();
				
				// only first-level parentheses
				if (stack.isEmpty()) {
					ans.add(new Pair(a, i));
				}
			}
		}
		
		return ans;
	}
	
	static int numberOfTerms(String expression) {
		List<String> terms = divideInTerms(expression);
		
		return terms.size();
	}
	
	static int numberOfFactors(String expression) {
		assert numberOfTerms(expression) == 1;
		
		List<String> factors = divideInFactors(expression);
		
		return factors.size();
	}
	
	static List<String> divideInTerms(String expression) {
		List<String> ans = new ArrayList<String>();

		List<Pair> parenPositions = findParens(expression);
		boolean[] forbidden = new boolean[expression.length()];
		for (Pair p : parenPositions) {
			for (int i = p.a; i <= p.b; ++i) {
				forbidden[i] = true;
			}
		}
		
		List<Integer> splitPoints = new ArrayList<Integer>();
		for (int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			if ((c == '+' || c == '-') && !forbidden[i]) {
				splitPoints.add(i);
			}
		}
		
		int prev = 0;
		for (int split : splitPoints) {
			String term = expression.substring(expression.charAt(prev) == '+' ? prev + 1 : prev, split);
			if (!term.isEmpty()) {
				ans.add(term);
			}
			prev = split;
		}
		String term = expression.substring(expression.charAt(prev) == '+' ? prev + 1 : prev, expression.length());
		if (!term.isEmpty()) {
			ans.add(term);
		}
		
		return ans;
	}
	
	static List<String> divideInFactors(String expression) {
		List<String> ans = new ArrayList<String>();

		List<Pair> parenPositions = findParens(expression);
		boolean[] forbidden = new boolean[expression.length()];
		for (Pair p : parenPositions) {
			for (int i = p.a; i <= p.b; ++i) {
				forbidden[i] = true;
			}
		}
		
		List<Integer> splitPoints = new ArrayList<Integer>();
		for (int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			if (c == '*' && !forbidden[i]) {
				splitPoints.add(i);
			}
		}
		
		int prev = -1;
		for (int split : splitPoints) {
			String factor = expression.substring(prev + 1, split);
			if (!factor.isEmpty()) {
				ans.add(factor);
			}
			prev = split;
		}
		String factor = expression.substring(prev + 1, expression.length());
		if (!factor.isEmpty()) {
			ans.add(factor);
		}
		
		return ans;
	}
	
	static List<String> divideInTwoFactors(String expression) {
		assert numberOfTerms(expression) == 1 && numberOfFactors(expression) > 1;

		List<String> ans = new ArrayList<String>();
		List<Pair> parenPositions = findParens(expression);
		boolean[] forbidden = new boolean[expression.length()];
		for (Pair p : parenPositions) {
			for (int i = p.a; i <= p.b; ++i) {
				forbidden[i] = true;
			}
		}
		
		int splitPoint = 0;
		for (int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			if (c == '*' && !forbidden[i]) {
				splitPoint = i;
				break;
			}
		}
		
		ans.add(expression.substring(0, splitPoint));
		ans.add(expression.substring(splitPoint + 1));
		
		return ans;
	}
	
	
	static String removeRedundantParentheses(String expression) {
		List<Pair> parenPositions = findParens(expression);
		Set<Integer> toDelete = new HashSet<Integer>();
		
		// Delete redundant parens
		for (Pair p : parenPositions) {
			int left = p.a + 1;
			int right = p.b - 1;
			while (left < right && expression.charAt(left) == '(' && expression.charAt(right) == ')') {
				toDelete.add(left);
				toDelete.add(right);
				++left;
				--right;
			}
		}
		
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < expression.length(); ++i) {
			if (toDelete.contains(i)) {
				continue;
			}
			ans.append(expression.charAt(i));
		}
		
		String ansstr = ans.toString();
		for (Pair p : parenPositions) {
			if (p.a == 0 && p.b == expression.length() - 1) {
				ansstr = ansstr.substring(1, ansstr.length() - 1);
				break;
			}
		}	
		return ansstr;
	}
	
	static String removeParenthesesAfterAddition(String expression) {	
		List<Pair> parenPositions = findParens(expression);
		List<Integer> toDelete = new ArrayList<Integer>();
		
		// Delete parens if there is a +/- in front (but not inverse symbol after)
		int offset = 0;
		for (Pair p : parenPositions) {
			int left = p.a + offset;
			int right = p.b + offset;
			if (right + 1 < expression.length() && (expression.charAt(right + 1) == '\'' || expression.charAt(right + 1) == '*')) {
				continue;
			}

			if (left > 0 && expression.charAt(left - 1) == '+') {
				toDelete.add(left);
				toDelete.add(right);
				if (expression.charAt(left + 1) == '-') {
					toDelete.add(left - 1);
				}
			} else if (left > 0 && expression.charAt(left - 1) == '-') {
				String subexpr = flipSignsOfTerms(expression.substring(left + 1, right));
				String subleft = expression.substring(0, left + 1);
				String subright = expression.substring(right);
				
				if (subexpr.length() - 1 == right - left - 1) { // first from + to -
					++offset;
					++right;
					toDelete.add(left - 1);
				} else if (subexpr.length() + 1 == right - left - 1) { // first from - to +
					--offset;
					toDelete.add(left - 1);
					subexpr = "+" + subexpr;
				}
				
				expression = subleft + subexpr + subright;
				
				toDelete.add(left);
				toDelete.add(right);
			}
		}
		
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < expression.length(); ++i) {
			if (toDelete.contains(i)) {
				continue;
			}
			ans.append(expression.charAt(i));
		}
		
		return ans.toString();
	}
	
	static String removeUnnecessaryParentheses(String expression) {
		String prev = expression;
		
		do {
			prev = expression;
			expression = removeRedundantParentheses(expression);
			expression = removeParenthesesAfterAddition(expression);
		} while (!prev.equals(expression));
		
		return expression;
	}
	
	static String flipSignsOfTerms(String expression) {
		List<String> terms = divideInTerms(expression);
		
		String ans = "";
		for (String term : terms) {
			ans = addTo(ans, negation(term));
		}
		
		return ans;
	}
	
	static String negation(String term) {
		if (term.startsWith("-")) {
			term = term.substring(1);
		} else {
			term = "-" + (term.startsWith("+") ? term.substring(1) : term);
		}
		
		return term;
	}
	
	static String addTo(String expression, String term) {
		if (term.isEmpty() || term.equals("0")) {
			return expression;
		}
		if (expression.isEmpty() || expression.equals("0")) {
			return term;
		}
		StringBuilder sb = new StringBuilder(expression);
		sb.append(term.startsWith("-") ? term : "+" + term);
		return sb.toString();
	}
	
	static String preMultiply(String expression, String term) {
		if (numberOfTerms(expression) > 1) {
			expression = "(" + expression + ")";
		}
		return term + "*" + expression;
	}
	
	static String postMultiply(String expression, String term) {
		if (numberOfTerms(expression) > 1) {
			expression = "(" + expression + ")";
		}
		return expression + "*" + term;
	}
	
	static boolean isInverse(String expression) {		
		if (numberOfTerms(expression) == 1 && numberOfFactors(expression) == 1 && expression.endsWith("'")) {
			return true;
		}

		return false;
	}
	
	static String inverse(String expression) {
		if (isInverse(expression)) {
			expression = expression.substring(0, expression.length() - 1);
			expression = removeUnnecessaryParentheses(expression);
		} else {
			if (numberOfTerms(expression) > 1 || numberOfFactors(expression) > 1) {
				expression = "(" + expression + ")";
			}
			expression += "'";
		}
		
		return expression;
	}
	
	
	static String simplifyTerm(String term) {
		assert numberOfTerms(term) == 1;
		
		boolean isNegative = false;
		if (term.startsWith("-")) {
			isNegative = true;
			term = term.substring(1);
		}
		
		StringBuilder ans = new StringBuilder();

		List<String> factors = divideInFactors(term);
		for (int i = 0; i < factors.size(); ++i) {
			String factor = factors.get(i);
			if (i < factors.size() - 1 && inverse(factor).equals(factors.get(i + 1))) {
				++i;
				continue;
			} else if (factor.equals("1")) {
				continue;
			} else if (factor.equals("0")) {
				return (isNegative ? "-" : "") + "0";
			}
			
			List<Pair> parens = findParens(factor);
			if (!parens.isEmpty()) {
				String left = factor.substring(0, parens.get(0).a + 1);
				String middle = factor.substring(parens.get(0).a + 1, parens.get(0).b);
				String right = factor.substring(parens.get(0).b);
				
				middle = simplifyExpression(middle);
				factor = left + middle + right;
			}
			
			if (ans.length() > 0) {
				ans.append("*");
			}
			ans.append(factor);
 		}
		
		if (ans.length() == 0) {
			return (isNegative ? "-" : "") + "1";
		}
		
		return (isNegative ? "-" : "") + ans.toString();
	}
	
	static String simplifyExpression(String expression) {
		expression = removeUnnecessaryParentheses(expression);
				
		String ans = "";		
		for (String term : divideInTerms(expression)) {
			ans = addTo(ans, simplifyTerm(term));
		}
		return ans;
	}
	
	static boolean validEquation(String expression) {
		return true;
	}
	
	static String solveEquationHelper(String expression, String result, String variable) {
		if (!containsVariable(expression, variable)) {
			throw new IllegalArgumentException("Variable is not in the equation!");
		}
		
		expression = simplifyExpression(expression);
		result = simplifyExpression(result);
		
		if (expression == null || expression.isEmpty()) {
			return result;
		}
		
		if (isInverse(expression)) {
			expression = inverse(expression);
			result = inverse(result);
		}
		if (expression.equals(variable)) {
			return result;
		}
		
		List<String> terms = divideInTerms(expression);
		
		String next = expression;
		if (terms.size() > 1) {
			for (String term : terms) {
				if (containsVariable(term, variable)) {
					next = term;
				} else {
					result = addTo(result, negation(term));
				}
			}
		}
		
		if (next.startsWith("-")) {
			next = flipSignsOfTerms(next);
			result = flipSignsOfTerms(result);
		}
		
		if (next.contains("*")) {
			List<String> factors = divideInTwoFactors(next);
			assert factors.size() == 2;
			
			if (containsVariable(factors.get(0), variable)) {
				next = factors.get(0);
				result = postMultiply(result, inverse(factors.get(1)));
			} else if (containsVariable(factors.get(1), variable)) {
				next = factors.get(1);
				result = preMultiply(result, inverse(factors.get(0)));
			} else {
				throw new IllegalArgumentException("Variable is not in the equation!");
			}
		}
		
		return solveEquationHelper(next, result, variable);
	}
	
	static String solveEquation(String equation, String variable) {
		String[] parts = equation.split("=");
		
		assert parts.length == 2;
		
		String lhs = parts[0];
		String rhs = parts[1];
		
		String sideToSolve = null;
		String otherSide = null;
		if (containsVariable(lhs, variable)) {
			sideToSolve = lhs;
			otherSide = rhs;
		} else if (containsVariable(rhs, variable)) {
			sideToSolve = rhs;
			otherSide = lhs;
		} else {
			throw new IllegalArgumentException("Variable is not in the equation!");
		}

		String result = solveEquationHelper(sideToSolve, otherSide, variable);
		
		return result;
	}
	
	/* Assumptions:
	 * - there is only one occurrence of all the variables in the equation
	 * - the only operators are +, -, *, '.
	 * - only parentheses are used to nest expressions
	 * - the equations are valid (e.g. well balanced and valid operations)
	 * - Not supported yet distributivity or factoring
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("equations_input.txt"));
		
		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			if (line.isEmpty()) {
				continue;
			}
			line = line.replace(" ", "");
			if (line.startsWith("#")) {
				continue;
			}
			
			String[] parts = line.split(",");
			
			assert parts.length == 2;
			
			String equation = parts[0];
			String variable = parts[1];
			
			if (!validEquation(equation)) {
				throw new IllegalArgumentException("The equation is not valid!");
			}
									
			String ans = solveEquation(equation, variable);
			
			if (ans != null) {
				System.out.print(variable + "=");
			}
			System.out.println(ans);
		}
		//System.out.println(getVariables("(Txxx+S*S'*S'*S)*(x-M*t+e+(0*L-1*P'*P*P'))"));

		in.close();
	}
}
