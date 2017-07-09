import java.util.*;

public class DesignTutorialMakeItNondeterministic {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean can = true;
		int n = in.nextInt();
		String prev = "";
		String[] f = new String[n];
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			f[i] = in.next();
			s[i] = in.next();
		}
		
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = in.nextInt() - 1;
		}
		
		for (int i = 0; i < n; i++) {
			String first = f[p[i]];
			String second = s[p[i]];
			if (first.compareTo(second) > 0) {
				first = s[p[i]];
				second = f[p[i]];
			}
			if (prev.compareTo(first) < 0) {
				prev = first;
			} else {
				if (prev.compareTo(second) < 0) {
					prev = second;
				} else {
					can = false;
					break;
				}
			}
		}
		
		System.out.println(can ? "YES" : "NO");

		in.close();
		System.exit(0);
	}
}
