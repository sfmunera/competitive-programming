package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1869 (10928 - My Dear Neighbours) */
/* SUBMISSION: 10246482 */
/* SUBMISSION TIME: 2012-06-21 20:47:19 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10928_MyDearNeighbours {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			if (first)
				first = false;
			else
				in.readLine();
			
			int P = Integer.parseInt(in.readLine());
			int[] out = new int[P];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < P; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				out[i] = parts.length;
				min = Math.min(min, out[i]);
			}
			
			boolean firstVertex = true;
			for (int i = 0; i < P; ++i) {
				if (out[i] == min) {
					if (firstVertex)
						firstVertex = false;
					else
						System.out.print(" ");
					System.out.print(i + 1);
				}
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
