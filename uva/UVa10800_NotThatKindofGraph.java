package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1741 (10800 - Not That Kind of Graph) */
/* SUBMISSION: 10183871 */
/* SUBMISSION TIME: 2012-06-02 18:57:36 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10800_NotThatKindofGraph {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String line = in.readLine();
			int N = line.length();
			int[] y = new int[N];
			
			y[0] = 0;
			int offset = 0;
			for (int i = 1; i < N; ++i) {
				y[i] = y[i - 1];
				if (line.charAt(i - 1) == 'R' && line.charAt(i) != 'F')
					++y[i];
				else if (line.charAt(i - 1) == 'F' && line.charAt(i) == 'F')
					--y[i];
				else if (line.charAt(i - 1) == 'C' && line.charAt(i) == 'F')
					--y[i];
				offset = Math.min(offset, y[i]);
			}
			
			offset *= -1;
			int H = 0;
			for (int i = 0; i < N; ++i) {
				y[i] += offset;
				H = Math.max(H, y[i] + 1);
			}
			
			char[][] graph = new char[H + 1][N + 3];
			for (int i = 0; i < H; ++i) {
				Arrays.fill(graph[i], ' ');
				graph[i][0] = '|';
			}
			
			graph[H][0] = '+';
			for (int i = 1; i < N + 3; ++i)
				graph[H][i] = '-';
			
			for (int i = 0; i < N; ++i)
				if (line.charAt(i) == 'R')
					graph[H - 1 - y[i]][i + 2] = '/';
				else if (line.charAt(i) == 'F')
					graph[H - 1 - y[i]][i + 2] = '\\';
				else
					graph[H - 1 - y[i]][i + 2] = '_';
			
			System.out.println("Case #" + t + ":");
			for (int i = 0; i <= H; ++i)
				System.out.println(String.valueOf(graph[i]).trim());
			
			
			
			System.out.println();
			
		}
		
		in.close();
		System.exit(0);
	}
}
