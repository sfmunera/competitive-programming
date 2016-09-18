package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1072 (10131 - Is Bigger Smarter?) */
/* SUBMISSION: 10166297 */
/* SUBMISSION TIME: 2012-05-29 03:08:02 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10131_IsBiggerSmarter {
	
	static class Pair implements Comparable<Pair> {
		int id, W, S;
		
		public Pair(int id, int W, int S) {
			this.id = id;
			this.W = W;
			this.S = S;
		}

		public int compareTo(Pair p) {
			if (this.S > p.S)
				return -1;
			return 1;
		}
	}
	
	static List<Pair> lis(List<Pair> list) {
		int N = list.size();
		List<Integer> M = new ArrayList<Integer>();
		int[] parent = new int[N];
		Arrays.fill(parent, -1);
		
		M.add(0);
		
		for (int i = 1; i < N; ++i) {
			Pair x = list.get(i);
			
			if (x.W > list.get(M.get(M.size() - 1)).W) {
				parent[i] = M.get(M.size() - 1);
				M.add(i);
				continue;
			}
			
			int lo = 0;
			int hi = M.size() - 1;
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (list.get(M.get(mid)).W < x.W)
					lo = mid + 1;
				else
					hi = mid;
			}
			
			int j = lo;
			if(x.W < list.get(M.get(j)).W) {
				if (j > 0)
					parent[i] = M.get(j - 1);
				M.set(j, i);
			}
		}
		
		List<Pair> lis = new ArrayList<Pair>();
		int cur = M.get(M.size() - 1);
		while (cur != -1) {
			lis.add(0, list.get(cur));
			cur = parent[cur];
		}
		
		return lis;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		List<Pair> pairs = new ArrayList<Pair>();
		int k = 1;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			int W = Integer.parseInt(parts[0]);
			int S = Integer.parseInt(parts[1]);
			
			pairs.add(new Pair(k++, W, S));
		}
		Collections.sort(pairs);
		
		List<Pair> lis = lis(pairs);
		
		System.out.println(lis.size());
		for (Pair p : lis)
			System.out.println(p.id);
		
		in.close();
		System.exit(0);
	}
}
