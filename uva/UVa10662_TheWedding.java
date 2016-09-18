package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1603 (10662 - The Wedding) */
/* SUBMISSION: 09028010 */
/* SUBMISSION TIME: 2011-07-07 23:34:09 */
/* LANGUAGE: 2 */

import java.util.*;

public class UVa10662_TheWedding {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNextInt()) {
			int T = in.nextInt();
			int R = in.nextInt();
			int H = in.nextInt();
			int[] pricesT = new int[T];
			int[] pricesR = new int[R];
			int[] pricesH = new int[H];
			int[][] TR = new int[T][R];
			int[][] RH = new int[R][H];
			int[][] HT = new int[H][T];
			
			for (int i = 0; i < T; ++i) {
				pricesT[i] = in.nextInt();
				for (int j = 0; j < R; ++j)
					TR[i][j] = in.nextInt();
			}
			for (int i = 0; i < R; ++i) {
				pricesR[i] = in.nextInt();
				for (int j = 0; j < H; ++j)
					RH[i][j] = in.nextInt();
			}
			for (int i = 0; i < H; ++i) {
				pricesH[i] = in.nextInt();
				for (int j = 0; j < T; ++j)
					HT[i][j] = in.nextInt();
			}
			
			int min = Integer.MAX_VALUE;
			int Tmin = 0;
			int Rmin = 0;
			int Hmin = 0;
			
			for (int t = 0; t < T; ++t)
				for (int r = 0; r < R; ++r)
					for (int h = 0; h < H; ++h)
						if (TR[t][r] == 0 && RH[r][h] == 0 && HT[h][t] == 0) {
							int cost = pricesT[t] + pricesR[r] + pricesH[h];
							if (cost < min) {
								min = cost;
								Tmin = t;
								Rmin = r;
								Hmin = h;
							}
						}
			if (min == Integer.MAX_VALUE)
				System.out.println("Don't get married!");
			else
				System.out.println(Tmin + " " + Rmin + " " + Hmin + ":" + min);
		}
	}
}
