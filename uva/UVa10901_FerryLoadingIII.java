package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1842 (10901 - Ferry Loading III) */
/* SUBMISSION: 11034970 */
/* SUBMISSION TIME: 2012-12-16 00:57:37 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10901_FerryLoadingIII {
	
	static class Item {
		int time, id;
		public Item(int time, int id) {
			this.time = time; this.id = id;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		int T = Integer.parseInt(in.readLine());
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			int n = Integer.parseInt(parts[0]);
			int t = Integer.parseInt(parts[1]);
			int m = Integer.parseInt(parts[2]);
			
			int[] arrival = new int[m];
			List<Queue<Item>> Q = new ArrayList<Queue<Item>>();
			for (int i = 0; i < 2; ++i)
				Q.add(new LinkedList<Item>());
			for (int i = 0; i < m; ++i) {
				parts = in.readLine().split("[ ]+");
				int x = Integer.parseInt(parts[0]);
				if (parts[1].equals("left"))
					Q.get(0).offer(new Item(x, i));
				else
					Q.get(1).offer(new Item(x, i));
			}
			
			int time = 0;
			for (int i = 0; !Q.get(0).isEmpty() || !Q.get(1).isEmpty(); ++i) {
				while (true) {
					int j = 0;
					boolean load = false;
					while (!Q.get(i % 2).isEmpty() && j < n && Q.get(i % 2).peek().time <= time) {
						Item q = Q.get(i % 2).poll();
						arrival[q.id] = time + t;
						++j;
						load = true;
					}
					if (!load) {
						int[] times = {Q.get(0).isEmpty() ? Integer.MAX_VALUE : Q.get(0).peek().time, 
								       Q.get(1).isEmpty() ? Integer.MAX_VALUE : Q.get(1).peek().time};
						int next = Math.min(times[0], times[1]);
						if (next > time) {
							time = next;
							if (times[i % 2] > times[1 - (i % 2)]) break;
						} else break;
					} else break;
				}
				time += t;
			}
			
			if (first) first = false;
			else System.out.println();
			for (int i = 0; i < m; ++i)
				System.out.println(arrival[i]);
		}
		
		in.close();
		System.exit(0);
	}
}
