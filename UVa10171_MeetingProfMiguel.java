package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1112 (10171 - Meeting Prof. Miguel...) */
/* SUBMISSION: 10418974 */
/* SUBMISSION TIME: 2012-08-01 14:51:41 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10171_MeetingProfMiguel {
	
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int M = Integer.parseInt(in.readLine());
			if (M == 0) break;
			
			Set<Integer> vertices = new HashSet<Integer>();
			int N = 26;
			int[][] adjY = new int[N][N];
			int[][] adjM = new int[N][N];
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					if (i == j)
						adjM[i][j] = adjY[i][j] = 0;
					else
						adjM[i][j] = adjY[i][j] = INF;

			for (int i = 0; i < M; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				char type = parts[0].charAt(0);
				char dir = parts[1].charAt(0);
				int from = parts[2].charAt(0) - 'A';
				int to = parts[3].charAt(0) - 'A';
				int cost = Integer.parseInt(parts[4]);
				
				vertices.add(from);
				vertices.add(to);
				
				if (type == 'Y') {
					adjY[from][to] = Math.min(cost, adjY[from][to]);
					if (dir == 'B')
						adjY[to][from] = Math.min(cost, adjY[to][from]);
				} else {
					adjM[from][to] = Math.min(cost, adjM[from][to]);
					if (dir == 'B')
						adjM[to][from] = Math.min(cost, adjM[to][from]);
				}
			}
			
			for (int k = 0; k < N; ++k)
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j) {
						adjY[i][j] = Math.min(adjY[i][j], adjY[i][k] + adjY[k][j]);
						adjM[i][j] = Math.min(adjM[i][j], adjM[i][k] + adjM[k][j]);
					}
			
			String[] parts = in.readLine().split("[ ]+");
			int sY = parts[0].charAt(0) - 'A';
			int sM = parts[1].charAt(0) - 'A';
			
			vertices.add(sY);
			vertices.add(sM);
			
			int cost = INF;
			for (int k = 0; k < N; ++k)
				if (vertices.contains(k))
					cost = Math.min(cost, adjY[sY][k] + adjM[sM][k]);
			
			if (cost >= INF)
				System.out.println("You will never meet.");
			else {
				List<Character> dest = new ArrayList<Character>();
				for (int k = 0; k < N; ++k)
					if (cost == adjY[sY][k] + adjM[sM][k])
						dest.add((char)(k + 'A'));

				System.out.print(cost);
				Collections.sort(dest);
				for (char c : dest)
					System.out.print(" " + c);
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}
