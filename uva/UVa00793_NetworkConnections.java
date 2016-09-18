package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 734 (793 - Network Connections) */
/* SUBMISSION: 09600870 */
/* SUBMISSION TIME: 2011-12-29 15:35:04 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa00793_NetworkConnections {
	
	static int[] pset; // pset[i] is the parent of node i
	static int[] rank; // rank[i] is the approximate height on node i in the tree
	
	static void initSet(int N) {
		pset = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; ++i) {
			pset[i] = i;
			rank[i] = 0;
		}
	}
	
	static int findSet(int i) {
		// Path compression heuristic
		return (pset[i] == i) ? i : (pset[i] = findSet(pset[i]));
	}
	
	static boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}
	
	static void unionSet(int i, int j) {
		int pi = findSet(i);
		int pj = findSet(j);
		
		// Union rank heuristic
		if (rank[pi] > rank[pj])
			pset[pj] = pi;
		else
			pset[pi] = pj;
		if (rank[pi] == rank[pj])
			++rank[pj];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		boolean first = true;
		while (T-- > 0) {
			int N = Integer.parseInt(in.readLine());
			int success = 0;
			int unsuccess = 0;
			
			initSet(N);
			while (true) {
				String line = in.readLine();
				if (line == null || line.isEmpty())
					break;
				
				String[] parts = line.split("[ ]+");
				char c = parts[0].charAt(0);
				
				int i = Integer.parseInt(parts[1]) - 1;
				int j = Integer.parseInt(parts[2]) - 1;
				
				if (c == 'c')
					unionSet(i, j);
				else {
					if (isSameSet(i, j))
						++success;
					else
						++unsuccess;
				}
			}
			
			if (first)
				first = false;
			else
				System.out.println();
			System.out.println(success + "," + unsuccess);
		}
		
		in.close();
		System.exit(0);
	}
}