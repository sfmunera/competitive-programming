package livearchive;

import java.util.*;

public class ModularMultiplicationOfPolynomials {
	
	static List<Integer> times(List<Integer> f, List<Integer> g) {
		List<Integer> mult = times(g, f.get(0));
		
		for (int i = 1; i < f.size(); ++i)
			mult = plus(mult, times(g, f.get(i)));

		return mult;
	}
	
	static List<Integer> times(List<Integer> f, int d) {
		List<Integer> mult = new ArrayList<Integer>();
		for (int x : f) {
			mult.add(x + d);
		}
		
		return mult;
	}
	
	static List<Integer> plus(List<Integer> f, List<Integer> g) {
		List<Integer> sum = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		
		while (i < f.size() && j < g.size()) {
			if (f.get(i) > g.get(j)) {
				sum.add(f.get(i++));
			} else if (f.get(i) < g.get(j)) {
				sum.add(g.get(j++));
			} else {
				++i;
				++j;
			}
		}
		
		while (i < f.size()) {
			sum.add(f.get(i++));
		}
		while (j < g.size()) {
			sum.add(g.get(j++));
		}
		
		return sum;
	}
	
	static List<Integer> mod(List<Integer> f, List<Integer> g) {
		if (f.get(0) < g.get(0)) {
			return f;
		}
		
		int d = f.get(0) - g.get(0);
		List<Integer> tmp = times(g, d);
		
		return mod(plus(f, tmp), g);
	}
	
	static List<Integer> solve(List<Integer> f, List<Integer> g, List<Integer> h) {
		return mod(times(f, g), h);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			List<Integer> f = new ArrayList<Integer>();
			List<Integer> g = new ArrayList<Integer>();
			List<Integer> h = new ArrayList<Integer>();
			
			int df = in.nextInt();
			for (int i = 0; i < df; ++i) {
				int coeff = in.nextInt();
				if (coeff == 1) {
					f.add(df - i - 1);
				}
			}
			int dg = in.nextInt();
			for (int i = 0; i < dg; ++i) {
				int coeff = in.nextInt();
				if (coeff == 1) {
					g.add(dg - i - 1);
				}
			}
			int dh = in.nextInt();
			for (int i = 0; i < dh; ++i) {
				int coeff = in.nextInt();
				if (coeff == 1) {
					h.add(dh - i - 1);
				}
			}
			
			List<Integer> ans = solve(f, g, h);
			int idx = 0;
			int n = ans.get(0) + 1;
			
			System.out.print(n);
			for (int i = n - 1; i >= 0; --i) {
				if (idx < ans.size() && i == ans.get(idx)) {
					System.out.print(" 1");
					++idx;
				} else {
					System.out.print(" 0");
				}
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
