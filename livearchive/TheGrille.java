package livearchive;

import java.util.*;

public class TheGrille {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int N = in.nextInt();
			if (N == 0) break;
			
			boolean[][][] isHole = new boolean[N][N][4];
			char[][] cipher = new char[N][N];
			for (int i = 0; i < N; ++i) {
				String row = in.next();
				for (int j = 0; j < N; ++j) {
					if (row.charAt(j) == 'O') {
						isHole[i][j][0] = true;
						isHole[j][N - i - 1][1] = true;
						isHole[N - i - 1][N - j - 1][2] = true;
						isHole[N - j - 1][i][3] = true;
					}
				}
			}
			
			for (int i = 0; i < N; ++i) {
				cipher[i] = in.next().toCharArray();
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 4; ++i)
				for (int r = 0; r < N; ++r)
					for (int c = 0; c < N; ++c)
						if (isHole[r][c][i])
							sb.append(cipher[r][c]);
			
			System.out.println(sb.toString());
		}
		
		in.close();
		System.exit(0);
	}
}
