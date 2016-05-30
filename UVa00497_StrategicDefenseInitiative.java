package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 438 (497 - Strategic Defense Initiative) */
/* SUBMISSION: 10165938 */
/* SUBMISSION TIME: 2012-05-28 23:20:54 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00497_StrategicDefenseInitiative {
	
	static List<Integer> lis(List<Integer> list) {
		int N = list.size();
		List<Integer> M = new ArrayList<Integer>();
		int[] parent = new int[N];
		Arrays.fill(parent, -1);
		
		M.add(0);
		
		for (int i = 1; i < N; ++i) {
			int x = list.get(i);
			
			if (x > list.get(M.get(M.size() - 1))) {
				parent[i] = M.get(M.size() - 1);
				M.add(i);
				continue;
			}
			
			int lo = 0;
			int hi = M.size() - 1;
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (list.get(M.get(mid)) <= x)
					lo = mid + 1;
				else
					hi = mid;
			}
			
			int j = lo;
			if(x < list.get(M.get(j))) {
				if (j > 0)
					parent[i] = M.get(j - 1);
				M.set(j, i);
			}
		}
		
		List<Integer> lis = new ArrayList<Integer>();
		int cur = M.get(M.size() - 1);
		while (cur != -1) {
			lis.add(0, list.get(cur));
			cur = parent[cur];
		}
		
		return lis;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		boolean first = true;
		while (T-- > 0) {
			String line;
			List<Integer> list = new ArrayList<Integer>();
			while ((line = in.readLine()) != null && !line.isEmpty()) {
				list.add(Integer.parseInt(line));
			}
			List<Integer> lis = lis(list);
			
			if (first)
				first = false;
			else
				System.out.println();
			
			System.out.println("Max hits: " + lis.size());
			for (int x : lis)
				System.out.println(x);
		}
		
		in.close();
		System.exit(0);
	}
}
