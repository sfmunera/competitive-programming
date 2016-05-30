package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 796 (855 - Lunch in Grid City) */
/* SUBMISSION: 10045370 */
/* SUBMISSION TIME: 2012-04-27 18:25:12 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00855_LunchinGridCity {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		while (T-- > 0) {
			String line = "";
			while (line.isEmpty()) {
				line = in.readLine();
			}
			String[] parts = line.split("[ ]+");
			int F = Integer.parseInt(parts[2]);
			
			int[] streets = new int[F];
			int[] avenues = new int[F];
			for (int i = 0; i < F; ++i) {
				line = "";
				while (line.isEmpty()) {
					line = in.readLine();
				}
				parts = line.split("[ ]+");
				streets[i] = Integer.parseInt(parts[0]);
				avenues[i] = Integer.parseInt(parts[1]);
			}
			
			Arrays.sort(streets);
			Arrays.sort(avenues);
			
			if (F % 2 == 0)
				System.out.println("(Street: " + streets[(F - 1) / 2] + ", Avenue: " + avenues[(F - 1) / 2] + ")");
			else
				System.out.println("(Street: " + streets[F / 2] + ", Avenue: " + avenues[F / 2] + ")");			
		}
		
		in.close();
		System.exit(0);
	}
}
