package codeforces;

import java.util.*;
import java.io.*;

public class Reading {
	
	static class Pair implements Comparable<Pair> {
		int a, ind;
		Pair(int a, int ind) {
			this.a = a;
			this.ind = ind;
		}
		@Override
		public int compareTo(Pair that) {
			return that.a - this.a;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileInputStream(new File("input.txt")));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		Pair[] books = new Pair[n];
		for (int i = 1; i <= n; ++i) {
			int a = in.nextInt();
			books[i - 1] = new Pair(a, i);
		}
		
		Arrays.sort(books);
		
		StringBuilder sb = new StringBuilder();
		sb.append(books[k - 1].a + "\n");
		
		for (int i = 0; i < k; ++i) {
			if (i > 0) sb.append(" ");
			sb.append(books[i].ind);
		}
		out.println(sb);	
		
		in.close();
		out.close();
	}
}
