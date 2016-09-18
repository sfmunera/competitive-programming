package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3644 (1203 - Argus) */
/* SUBMISSION: 10059835 */
/* SUBMISSION TIME: 2012-05-01 04:31:15 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa01203_Argus {
	
	static class Item implements Comparable<Item> {

		int id, value, cnt;
		
		public Item(int id, int value, int cnt) {
			this.id = id;
			this.value = value;
			this.cnt = cnt;
		}
		
		public int compareTo(Item o) {
			if (this.value * this.cnt != o.value * o.cnt)
				return this.value * this.cnt - o.value * o.cnt;
			return this.id - o.id;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Item> Q = new PriorityQueue<Item>();
		while (true) {
			String line = in.readLine();
			if (line.equals("#"))
				break;
			String[] parts = line.split("[ ]+");
			int id = Integer.parseInt(parts[1]);
			int value = Integer.parseInt(parts[2]);
			Q.add(new Item(id, value, 1));
		}
		
		int K = Integer.parseInt(in.readLine());

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < K; ++i) {
			Item it = Q.poll();
			sb.append(it.id + "\n");
			Q.offer(new Item(it.id, it.value, it.cnt + 1));
		}
		System.out.print(sb);
		
		in.close();
		System.exit(0);
	}
}