package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1836 (10895 - Matrix Transpose) */
/* SUBMISSION: 10939369 */
/* SUBMISSION TIME: 2012-11-25 20:44:06 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10895_MatrixTranspose {
	
	static class Edge {
		int u, w;
		public Edge(int u, int w) {
			this.u = u; this.w = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int R = Integer.parseInt(parts[0]);
			int C = Integer.parseInt(parts[1]);
			
			ArrayList<ArrayList<Edge>> Gt = new ArrayList<ArrayList<Edge>>();
			for (int i = 0; i < C; ++i)
				Gt.add(new ArrayList<Edge>());
			
			for (int i = 0; i < R; ++i) {
				parts = in.readLine().split("[ ]+");
				int q = Integer.parseInt(parts[0]);
				int[] u = new int[q];
				for (int j = 0; j < q; ++j)
					u[j] = Integer.parseInt(parts[j + 1]);
				String line2 = in.readLine();
				if (q > 0) {
					parts = line2.split("[ ]+");
					for (int j = 0; j < q; ++j)
						Gt.get(u[j] - 1).add(new Edge(i, Integer.parseInt(parts[j])));
				}
			}
			
			System.out.println(C + " " + R);
			for (int i = 0; i < C; ++i) {
				System.out.print(Gt.get(i).size());
				for (Edge e : Gt.get(i))
					System.out.print(" " + (e.u  + 1));
				System.out.println();
				boolean first = true;
				for (Edge e : Gt.get(i)) {
					if (first)
						first = false;
					else
						System.out.print(" ");
					System.out.print(e.w);
				}
				System.out.println();
			}
		}
		
		in.close();
		System.exit(0);
	}
}
