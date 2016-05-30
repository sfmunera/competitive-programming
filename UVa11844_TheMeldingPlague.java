package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 2944 (11844 - The Melding Plague) */
/* SUBMISSION: 11569123 */
/* SUBMISSION TIME: 2013-04-07 01:41:00 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa11844_TheMeldingPlague {
	
	static class Pair {
		String p;
		int c;
		public Pair(String p, int c) {
			this.p = p; this.c = c;
		}
	}
	
	static Map<String, String> g;
	static int n;
	
	static int bfs(String s, String t) {
		Queue<String> Q = new LinkedList<String>();
		Map<String, Integer> dist = new HashMap<String, Integer>();
		Set<String> seen = new HashSet<String>();
		
		Q.offer(s);
		seen.add(s);
		dist.put(s, 0);
		while (!Q.isEmpty()) {
			String x = Q.poll();
			int d = dist.get(x);
			if (d > n) return -1;
			if (x.equals(t)) return d;
			
			String[] parts = x.split("[ ]");
			int[] c = new int[parts.length];
			for (int i = 0; i < parts.length; ++i) {
				String[] parts2 = parts[i].split("\\$");
				parts[i] = parts2[0];
				c[i] = Integer.parseInt(parts2[1]);
			}
			
			for (int i = 0; i < parts.length; ++i)
				if (g.containsKey(parts[i])) parts[i] = g.get(parts[i]);
			
			TreeMap<String, Integer> cnt = new TreeMap<String, Integer>();
			
			for (int i = 0; i < parts.length; ++i) {
				int val = c[i];
				if (cnt.containsKey(parts[i])) val += cnt.get(parts[i]);
				cnt.put(parts[i], val);
			}
			String next = "";
			boolean first = true;
			for (String str : cnt.keySet()) {
				if (first) first = false; else next += " ";
				next += str + "$" + cnt.get(str);
			}
			
			if (!seen.contains(next)) {
				seen.add(next);
				Q.offer(next);
				dist.put(next, d + 1);
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		while (true) {
			stk = new StringTokenizer(in.readLine());
			int NM = Integer.parseInt(stk.nextToken());
			int NI = Integer.parseInt(stk.nextToken());
			int NC = Integer.parseInt(stk.nextToken());
			n = Integer.parseInt(stk.nextToken());
			
			if (NM == 0 && NI == 0 && NC == 0 && n == 0) break;
			
			g = new HashMap<String, String>();
			
			boolean deterministic = true;
			for (int i = 0; i < NM; ++i) {
				stk = new StringTokenizer(in.readLine());
				String p = stk.nextToken();
				String q = stk.nextToken();
				
				if (g.containsKey(p) && !q.equals(g.get(p)))
					deterministic = false;
				g.put(p, q);
			}
			
			String I = "";
			String C = "";
			ArrayList<String> temp = new ArrayList<String>();
			for (int i = 0; i < NI; ++i) {
				stk = new StringTokenizer(in.readLine());
				String p = stk.nextToken();
				int c = Integer.parseInt(stk.nextToken());
				
				temp.add(p + "$" + c);
			}
			Collections.sort(temp);
			for (int i = 0; i < temp.size(); ++i) {
				if (i > 0) I += " ";
				I += temp.get(i);
			}
			
			temp = new ArrayList<String>();
			for (int i = 0; i < NC; ++i) {
				stk = new StringTokenizer(in.readLine());
				String q = stk.nextToken();
				int c = Integer.parseInt(stk.nextToken());
				
				temp.add(q + "$" + c);
			}
			Collections.sort(temp);
			for (int i = 0; i < temp.size(); ++i) {
				if (i > 0) C += " ";
				C += temp.get(i);
			}
			if (!deterministic)
				System.out.println("Protein mutations are not deterministic");
			else {
				int dist = bfs(I, C);
				if (dist == -1)
					System.out.println("Nostalgia for Infinity is doomed");
				else 
					System.out.println("Cure found in " + dist + " mutation(s)");
			}
			
		}
		
		in.close();
		System.exit(0);
	}
}
