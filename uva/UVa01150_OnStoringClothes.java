package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3591 (1150 - On Storing Clothes) */
/* SUBMISSION: 09282788 */
/* SUBMISSION TIME: 2011-09-21 00:42:46 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01150_OnStoringClothes {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			int N = Integer.parseInt(in.readLine());
			
			if (N == 0)
				break;
			
			int[] laundry = new int[N];
			
			int M = Integer.parseInt(in.readLine());
			int cursor = 0;

			if (first)
				first = false;
			else
				System.out.println();
			for (int i = 0; i < M; ++i) {
				String line = in.readLine();
				String[] parts = line.split("[ ]+");
				
				char command = parts[0].charAt(0);
				int par = Integer.parseInt(parts[1]);				

				if (command == 'D') {
					
					int ind = -1;
					for (int k = 0; k < N - 1; ++k) {
						boolean ok = true;
						for (int j = 0; j <= par + 1 && ok; ++j)
							if (laundry[(cursor + k + j) % N] == -1)
								ok = false;
						if (ok) {
							ind = k;
							break;
						}
					}
					if (ind != -1) {
						int ini = (cursor + ind) % N;
						int end = (ini + par + 1) % N;
						laundry[ini] = laundry[end] = 1;
						for (int j = ini + 1; ; j = (j + 1) % N) {
							if (j == end)
								break;
							laundry[j] = -1;
						}
						cursor = end;
						System.out.println("The launderer gives ticket " + ini + ".");
					} else {
						System.out.println("No space left, please come back later.");
					}
				} else if (command == 'W') {
					System.out.println("The launderer gives back batch " + par + ".");
					int prev = par - 1;
					if (prev < 0)
						prev = N - 1;
					if (laundry[prev] == 0) {
						laundry[par] = 0;
						System.out.println(par + " is freed.");
					}
					int j;
					for (j = par + 1; ; j = (j + 1) % N) {
						if (laundry[j] == 1)
							break;
						laundry[j] = 0;
						System.out.println(j + " is freed.");
					}
					int next = (j + 1) % N;
					if (laundry[next] == 0) {
						laundry[j] = 0;
						System.out.println(j + " is freed.");
					}
					cursor = par;
				}
			}
		}
		
		in.close();
		System.exit(0);
	}
}