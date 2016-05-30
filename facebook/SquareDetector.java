package facebook;

import java.io.*;
import java.util.*;

public class SquareDetector {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("square_detector.txt"));
		PrintWriter out = new PrintWriter(new File("outputFH1.txt"));
		
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			char[][] mat = new char[N][N];
			for (int i = 0; i < N; ++i)
				mat[i] = in.next().toCharArray();
			
			int r1 = N;
			int c1 = N;
			int r2 = -1;
			int c2 = -1;
			
			int cnt = 0;
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (mat[i][j] == '#') {
						r1 = Math.min(r1, i);
						r2 = Math.max(r2, i);
						c1 = Math.min(c1, j);
						c2 = Math.max(c2, j);
						++cnt;
					}
			
			boolean ok = ((r2 - r1 + 1) == (c2 - c1 + 1)) && (cnt == (r2 - r1 + 1) * (c2 - c1 + 1));
			
			out.println("Case #" + t + ": " + (ok ? "YES" : "NO"));
		}
		in.close();
		out.close();
		
	}
}
