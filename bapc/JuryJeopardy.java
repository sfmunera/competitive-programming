import java.util.*;
import java.io.*;

public class JuryJeopardy {
	
	static final int MAX = 201;
	static int[] dr = {0, 1, 0, -1}; // ESWN
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		System.out.println(T);
		for (int t = 1; t <= T; ++t) {
			String path = in.next();
			
			char[][] maze = new char[MAX][MAX];
			for (int i = 0; i < MAX; ++i) {
				for (int j = 0; j < MAX; ++j) {
					maze[i][j] = '#';
				}
			}
			
			int r = MAX / 2;
			int c = 0;
			int d = 0;
			maze[r][c] = '.';
			
			for (int i = 0; i < path.length(); ++i) {
				switch (path.charAt(i)) {
				case 'F': break;
				case 'R': d = (d + 1) % 4; break;
				case 'L': d = (d - 1 + 4) % 4; break;
				case 'B': d = (d + 2) % 4; break;
				}
				r = r + dr[d];
				c = c + dc[d];
				maze[r][c] = '.';
			}
			
			int minRow = MAX;
			int maxRow = 0;
			int maxCol = 0;
			
			for (int i = 0; i < MAX; ++i) {
				for (int j = 0; j < MAX; ++j) {
					if (maze[i][j] == '.') {
						minRow = Math.min(minRow, i);
						maxRow = Math.max(maxRow, i);
						maxCol = Math.max(maxCol, j);
					}
				}
			}
			
			int w = maxCol + 2;
			int h = maxRow - minRow + 3;
			
			char[][] ans = new char[h][w];
			for (int i = minRow - 1; i <= maxRow + 1; ++i) {
				for (int j = 0; j <= maxCol + 1; ++j) {
					ans[i - minRow + 1][j] = maze[i][j];
				}
			}
			
			System.out.println(h + " " + w);
			for (int i = 0; i < h; ++i) 
				System.out.println(ans[i]);
		}
		
		in.close();
	}
}
