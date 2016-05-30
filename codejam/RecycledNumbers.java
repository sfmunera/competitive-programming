package codejam;

import java.util.*;
import java.io.*;

public class RecycledNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("in.txt"));
		PrintWriter out = new PrintWriter(new File("out.txt"));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[ ]+");
			int A = Integer.parseInt(parts[0]);
			int B = Integer.parseInt(parts[1]);
			
			int cnt = 0;
			for (int i = A; i < B; ++i) {
				String str = String.valueOf(i);
				int n = str.length();
				String res = "";
				Set<Integer> seen = new HashSet<Integer>();
				for (int j = n - 1; j > 0; --j) {
					res = str.substring(j) + str.substring(0, j);
					int k = Integer.parseInt(res);
					if (k > i && k <= B) {
						//System.out.println("(" + i + ", " + k + ")");
						if (!seen.contains(k)) {
							++cnt;
							seen.add(k);
						}
					}
				}
			}

			out.println("Case #" + t + ": " + cnt);
		}
		
		in.close();
		out.close();
		System.exit(0);
	}
}
