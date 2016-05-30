package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 363 (422 - Word-Search Wonder) */
/* SUBMISSION: 11423235 */
/* SUBMISSION TIME: 2013-03-12 01:38:33 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00422_WordSearchWonder {
	
	static int[] di = {-1, -1, 0, 0, 1, 1, 1};
	static int[] dj = {-1, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		while (true) {
			int N = Integer.parseInt(line);
			if (N == 0) break;
			
			char[][] puzzle = new char[N][N];
			for (int i = 0; i < N; ++i)
				puzzle[i] = in.readLine().toCharArray();
			
			while (true) {
				String word = in.readLine();
				if (word.charAt(0) >= '0' && word.charAt(0) <= '9') {
					line = word;
					break;
				}
				boolean found = false;
				int rs = 0, cs = 0, rt = 0, ct = 0;
				for (int i = 0; i < N && !found; ++i)
					for (int j = 0; j < N && !found; ++j)
						for (int d = 0; d < 7; ++d) {
							found = true;
							int nk = 0;
							for (int k = 0; k < word.length(); ++k) {
								int ni = i + k * di[d];
								int nj = j + k * dj[d];
								if (ni < 0 || ni >= N || nj < 0 || nj >= N || word.charAt(k) != puzzle[ni][nj]) {
									found = false;
									break;
								}
								nk = k;
							}
							if (found) {
								rs = i + 1;
								cs = j + 1;
								rt = i + nk * di[d] + 1;
								ct = j + nk * dj[d] + 1;
								break;
							}
						}
				if (!found)
					System.out.println("Not found");
				else
					System.out.println(rs + "," + cs + " " + rt + "," + ct);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
