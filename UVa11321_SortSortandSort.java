package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2296 (11321 - Sort! Sort!! and Sort!!!) */
/* SUBMISSION: 10149819 */
/* SUBMISSION TIME: 2012-05-24 13:42:46 */
/* LANGUAGE: 2 */


import java.util.*;
import java.io.*;

public class UVa11321_SortSortandSort {
	
	static int M;
	
	static class Item implements Comparable<Item> {
		int num;
		
		public Item(int num) {
			this.num = num;
		}

		public int compareTo(Item i) {
			int mod1 = (Math.abs(this.num) % M) * (this.num < 0 ? -1 : 1);
			int mod2 = (Math.abs(i.num) % M) * (i.num < 0 ? -1 : 1);

			if (mod1 != mod2)
				return mod1 - mod2;
			
			int mod21 = Math.abs(this.num) % 2;
			int mod22 = Math.abs(i.num) % 2;
			if (mod21 == 0 && mod22 == 1)
				return 1;
			if (mod21 == 1 && mod22 == 0)
				return -1;
			if (mod21 == 1 && mod22 == 1 && i.num <= this.num)
				return -1;
			if (mod21 == 1 && mod22 == 1 && i.num > this.num)
				return 1;
			if (mod21 == 0 && mod22 == 0 && i.num <= this.num)
				return 1;
			if (mod21 == 0 && mod22 == 0 && i.num > this.num)
				return -1;
			return 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			M = Integer.parseInt(parts[1]);
			
			sb.append(N + " " + M + "\n");
			if (N == 0 && M == 0)
				break;
			
			Item[] items = new Item[N];
			for (int i = 0; i < N; ++i) {
				int x = Integer.parseInt(in.readLine());
				items[i] = new Item(x);
			}
			Arrays.sort(items);
			
			for (int i = 0; i < N; ++i)
				sb.append(items[i].num + "\n");
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}
