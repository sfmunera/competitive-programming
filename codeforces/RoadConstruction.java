package codeforces;

import java.util.*;

public class RoadConstruction {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		// make a star graph by connecting all nodes to one 
		// that does not appear in the forbidden edges
		boolean[] forbidden = new boolean[n];
		for (int i = 0; i < m; ++i) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			forbidden[a] = forbidden[b] = true;
		}
		
		int center = 0;
		for (int i = 0; i < n; ++i) {
			if (!forbidden[i]) {
				center = i;
				break;
			}
		}
		System.out.println(n - 1);
		for (int i = 0; i < n; ++i) {
			if (i == center) continue;
			System.out.println((center + 1) + " " + (i + 1));
		}
		
		in.close();
		System.exit(0);
	}
}
