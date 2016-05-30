package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1208 (10267 - Graphical Editor) */
/* SUBMISSION: 09153972 */
/* SUBMISSION TIME: 2011-08-15 18:35:47 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10267_GraphicalEditor {
	
	static char[][] image;
	static int M, N;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	static boolean inside(int X, int Y) {
		return X >= 0 && Y >= 0 && X < M && Y < N;
	}
	
	static void bfs(int X, int Y, char C0, char C) {

		boolean[][] visited = new boolean[N][M];
		Queue<Integer> Qx = new LinkedList<Integer>();
		Queue<Integer> Qy = new LinkedList<Integer>();
		
		Qx.offer(X);
		Qy.offer(Y);
		
		visited[Y][X] = true;
		
		while (!Qx.isEmpty()) {
			int x = Qx.poll();
			int y = Qy.poll();
			image[y][x] = C;
			
			for (int d = 0; d < 4; ++d) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (inside(nx, ny) && !visited[ny][nx] && image[ny][nx] == C0) {
					visited[ny][nx] = true;
					Qx.offer(nx);
					Qy.offer(ny);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
		image = new char[250][250];
		M = 0;
		N = 0;
		while (true) {
			String line = in.readLine();
			if (line.isEmpty())
				continue;
			if (line.equals("X"))
				break;
			StringTokenizer stk = new StringTokenizer(line);
			String command = stk.nextToken();
			if (command.equals("I")) {
				M = Integer.parseInt(stk.nextToken());
				N = Integer.parseInt(stk.nextToken());
				image = new char[N][M];
				for (int i = 0; i < N; ++i)
					Arrays.fill(image[i], 'O');
			}
			
			if (M == 0 || N == 0)
				continue;
			if (command.equals("C")) {
				for (int i = 0; i < N; ++i)
					Arrays.fill(image[i], 'O');
			}
			if (command.equals("L")) {
				int X = Integer.parseInt(stk.nextToken());
				int Y = Integer.parseInt(stk.nextToken());
				char C = stk.nextToken().charAt(0);
				
				if (inside(X - 1, Y - 1))
					image[Y - 1][X - 1] = C;
			}
			if (command.equals("V")) {
				int X = Integer.parseInt(stk.nextToken());
				int Y1 = Integer.parseInt(stk.nextToken());
				int Y2 = Integer.parseInt(stk.nextToken());
				char C = stk.nextToken().charAt(0);
					
				if (inside(X - 1, Y1 - 1) && inside(X - 1, Y2 - 1))
					for (int y = Math.min(Y1, Y2); y <= Math.max(Y1, Y2); ++y)
						image[y - 1][X - 1] = C;
			}
			if (command.equals("H")) {
				int X1 = Integer.parseInt(stk.nextToken());
				int X2 = Integer.parseInt(stk.nextToken());
				int Y = Integer.parseInt(stk.nextToken());
				char C = stk.nextToken().charAt(0);
				
				if (inside(X1 - 1, Y - 1) && inside(X2 - 1, Y - 1))
					for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); ++x)
						image[Y - 1][x - 1] = C;
			}
			if (command.equals("K")) {
				int X1 = Integer.parseInt(stk.nextToken());
				int Y1 = Integer.parseInt(stk.nextToken());
				int X2 = Integer.parseInt(stk.nextToken());
				int Y2 = Integer.parseInt(stk.nextToken());
				char C = stk.nextToken().charAt(0);
				
				if (inside(X1 - 1, Y1 - 1) && inside(X2 - 1, Y2 - 1))
					for (int y = Math.min(Y1, Y2); y <= Math.max(Y1, Y2); ++y)
						for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); ++x)
							image[y - 1][x - 1] = C;
			}
			if (command.equals("F")) {
				int X = Integer.parseInt(stk.nextToken());
				int Y = Integer.parseInt(stk.nextToken());
				char C = stk.nextToken().charAt(0);
				
				char C0 = image[Y - 1][X - 1];
				if (inside(X - 1, Y - 1))
					bfs(X - 1, Y - 1, C0, C);
			}
			if (command.equals("S")) {
				String name = stk.nextToken();
				System.out.println(name);
				for (int i = 0; i < N; ++i)
					System.out.println(String.valueOf(image[i]));
			}
		}
		in.close();
		System.exit(0);
	}
}