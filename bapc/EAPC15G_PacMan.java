package bapc;

import java.util.*;

public class EAPC15G_PacMan {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int M = in.nextInt();
			int N = in.nextInt();
			
			char[][] maze = new char[M][N];
			
			for (int i = 0; i < M; ++i) {
				maze[i] = in.next().toCharArray();
			}
			
			
		}
		
		in.close();
		System.exit(0);
	}
}
