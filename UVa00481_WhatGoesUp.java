package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 422 (481 - What Goes Up) */
/* SUBMISSION: 10165902 */
/* SUBMISSION TIME: 2012-05-28 23:02:25 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00481_WhatGoesUp {
	
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
		
		List<Integer> list = new ArrayList<Integer>();
		String line;
		while ((line = in.readLine()) != null)
			list.add(Integer.parseInt(line));
		
		List<Integer> lis = lis(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(lis.size() + "\n");
		sb.append("-\n");
		for (int x : lis)
			sb.append(x + "\n");
		System.out.print(sb);
		in.close();
		System.exit(0);
	}
}
