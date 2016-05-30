package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 961 (10020 - Minimal coverage) */
/* SUBMISSION: 10155527 */
/* SUBMISSION TIME: 2012-05-25 16:21:24 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10020_Minimalcoverage {
	
	static class Segment implements Comparable<Segment> {
		int L, R;
		
		public Segment(int L, int R) {
			this.L = L;
			this.R = R;
		}

		public int compareTo(Segment s) {
			if (this.L != s.L)
				return this.L - s.L;
			return s.R - this.R;
		}
		
		public String toString() {
			return this.L + " " + this.R;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			
			int M = Integer.parseInt(in.readLine());
			PriorityQueue<Segment> Q = new PriorityQueue<Segment>();
			
			while (true) {
				String[] parts = in.readLine().split("[ ]+");
				int L = Integer.parseInt(parts[0]);
				int R = Integer.parseInt(parts[1]);
				
				if (L == 0 && R == 0)
					break;
				
				Q.offer(new Segment(Math.min(L, R), Math.max(L, R)));
			}
			
			if (first)
				first = false;
			else
				System.out.println();
						
			int left = 0;
			
			List<Segment> res = new ArrayList<Segment>();
			
			while (left < M) {
				Segment sel = null;
				while (!Q.isEmpty() && Q.peek().L <= left) {
					Segment cur = Q.poll();
					if (sel == null || cur.R > sel.R)
						sel = cur;
				}
				if (sel == null)
					break;
				
				left = sel.R;
				res.add(sel);
			}
			
			if (left < M)
				res.clear();
			System.out.println(res.size());
			for (Segment s : res)
				System.out.println(s);
			
		}
		
		in.close();
		System.exit(0);
	}
}
