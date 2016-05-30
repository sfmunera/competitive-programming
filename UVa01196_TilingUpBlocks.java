package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3637 (1196 - Tiling Up Blocks) */
/* SUBMISSION: 11420681 */
/* SUBMISSION TIME: 2013-03-11 13:42:09 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa01196_TilingUpBlocks {
	
	static class Tile implements Comparable<Tile> {
		int l, m;
		public Tile(int l, int m) {
			this.l = l; this.m = m;
		}
		public int compareTo(Tile t) {
			if (this.l != t.l) return this.l - t.l;
			return this.m - t.m;
		}
		public String toString() {
			return this.l + " " + this.m;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int N = in.nextInt();
			if (N == 0) break;
			
			Tile[] tiles = new Tile[N];
			
			for (int i = 0; i < N; ++i) {
				int l = in.nextInt();
				int m = in.nextInt();
				tiles[i] = new Tile(l, m);
			}
			Arrays.sort(tiles);
			//for (Tile t : tiles)
			//	System.out.println(t);
			
			/*List<Integer> M = new ArrayList<Integer>();
			int[] p = new int[N];
			
			Arrays.fill(p, -1);
			M.add(0);
			for (int i = 1; i < N; ++i) {
				int last = M.size() - 1;
				if (tiles[i].l > tiles[M.get(last)].l && tiles[i].m > tiles[M.get(last)].m) {
					p[i] = M.get(last);
					M.add(i);
					continue;
				}
				int lo = 0;
				int hi = last;
				while (lo < hi) {
					int mid = (lo + hi) / 2;
					if (tiles[M.get(mid)].l <= tiles[i].l && tiles[M.get(mid)].m <= tiles[i].m)
						lo = mid + 1;
					else
						hi = mid;
				}
				int j = lo;
				if (tiles[i].l < tiles[M.get(j)].l && tiles[i].m < tiles[M.get(j)].m) {
					if (j > 0)
						p[i] = M.get(j - 1);
					M.set(j, i);
				}
			}
			int cur = M.get(M.size() - 1);
			int size = 0;
			while (cur != -1) {
				++size;
				cur = p[cur];
			}
			//for (int i = 0; i < lis.size(); ++i)
			//	System.out.println(lis.get(i));
			System.out.println(size);*/
			
			int[] q = new int[N];
			
			for (int i = 0; i < N; ++i) {
				int max = 0;
				for (int j = 0; j < i; ++j)
					if (tiles[i].l >= tiles[j].l && tiles[i].m >= tiles[j].m)
						max = Math.max(max, q[j]);
				q[i] = max + 1;
			}
			int max = 0;
			for (int i = 0; i < N; ++i)
				max = Math.max(max, q[i]);
			System.out.println(max);
		}
		System.out.println("*");
		
		in.close();
		System.exit(0);
	}
}
