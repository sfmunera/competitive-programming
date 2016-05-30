package livearchive;

import java.util.*;
import java.io.*;

public class Crane {
	
	static int findPosition(int[] crates, int l, int r, int k) {
		for (int j = l; j <= r; ++j) {
			if (k == crates[j]) {
				return j;
			}
		}
		return l;
	}
	
	static String move(int[] crates, int l, int r) {
		assert (r - l + 1) % 2 == 0;
		int mid = (l + r) / 2 + 1;
		
		int len = mid - l;
		int[] tmp = new int[len];
		for (int i = 0; i < len; ++i) {
			tmp[i] = crates[l + i];
		}
		for (int i = 0; i < len; ++i) {
			crates[l + i] = crates[mid + i];
		}
		for (int i = 0; i < len; ++i) {
			crates[mid + i] = tmp[i];
		}
		
		return "" + l + " " + r;
	}
	
	static void solve(int[] crates, int n) {
		List<String> moves = new ArrayList<String>();
		
		// Assume c[j] == j, for j in [1, i)
		for (int i = 1; i <= n; ++i) {
			if (i == crates[i]) continue;
			int j = findPosition(crates, i + 1, n, i);
			if (n - j + 1 < j - i) {
				if ((n - i + 1) % 2 == 0) {
					moves.add(move(crates, i, n));
				} else {
					moves.add(move(crates, i + 1, n));
				}
				j = findPosition(crates, i + 1, n, i);
			}
			assert n - j + 1 >= j - i;
			moves.add(move(crates, i, i + 2 * (j - i) - 1));
		}
		
		System.out.println(moves.size());
		for (String m : moves) {
			System.out.println(m);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int[] crates = new int[n + 1];
			
			for (int i = 1; i <= n; ++i) {
				crates[i] = in.nextInt();
			}
			solve(crates, n);
		}
		
		in.close();
	}
}
