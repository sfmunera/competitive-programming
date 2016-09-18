package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 283 (347 - Run) */
/* SUBMISSION: 10218385 */
/* SUBMISSION TIME: 2012-06-13 03:47:56 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00347_Run {
	
	static boolean isRunAround(int N) {
		char[] num = String.valueOf(N).toCharArray();
		int n = num.length;
		
		for (int i = 0; i < n; ++i)
			if (num[i] < '1' || num[i] > '9')
				return false;
		
		int[] cnt = new int[10];
		for (int i = 0; i < n; ++i) {
			++cnt[num[i] - '0'];
			if (cnt[num[i] - '0'] > 1)
				return false;
		}
		
		boolean[] visited = new boolean[n];
		int cur = 0;
		
		for (int i = 0; i < n; ++i) {
			int len = num[cur] - '0';
			int next = (cur + len) % n;
			
			if (visited[next])
				break;
			visited[next] = true;
			
			cur = next;
			if (cur == 0)
				break;
		}
		
		boolean ok = true;
		for (int i = 0; i < n; ++i)
			ok &= visited[i];
		
		return ok && cur == 0;
	}
	
	static int binSearch(List<Integer> L, int x) {
		int lo = 0;
		int hi = L.size() - 1;
		
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (L.get(mid) <= x)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> runs = new ArrayList<Integer>();
		for (int i = 10; i < 10000000; ++i)
			if (isRunAround(i))
				runs.add(i);
		
		int t = 1;
		while (true) {
			String line = in.readLine();
			if (line.startsWith("0"))
				break;
			int R = Integer.parseInt(line);
			
			int ind = binSearch(runs, R);
			
			System.out.println("Case " + t + ": " + runs.get(ind));
			++t;
		}
		
		in.close();
		System.exit(0);
	}
}
