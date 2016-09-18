package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2454 (11459 - Snakes and Ladders) */
/* SUBMISSION: 09598806 */
/* SUBMISSION TIME: 2011-12-28 18:01:37 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa11459_SnakesandLadders {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			int c = Integer.parseInt(parts[2]);
			
			int[] players = new int[N];
			
			int[] goTo = new int[100];
			for (int i = 0; i < 100; ++i)
				goTo[i] = i;
			for (int i = 0; i < b; ++i) {
				parts = in.readLine().split("[ ]+");
				int from = Integer.parseInt(parts[0]);
				int to = Integer.parseInt(parts[1]);
				goTo[from - 1] = to - 1;
			}
			
			boolean over = false;
			for (int i = 0; i < c; ++i) {
				int num = Integer.parseInt(in.readLine());
				if (over)
					continue;
				
				players[i % N] = goTo[Math.min(99, players[i % N] + num)];
				if (players[i % N] == 99)
					over = true;
			}
			
			for (int i = 0; i < N; ++i)
				System.out.println("Position of player " + (i + 1) + " is " + (players[i] + 1) + ".");
		}
		
		in.close();
		System.exit(0);
	}
}