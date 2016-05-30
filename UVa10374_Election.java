package uva;

import java.util.*;
import java.io.*;

public class UVa10374_Election {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		boolean first = true;
		while (T-- > 0) {
			in.readLine();
			int N = Integer.parseInt(in.readLine().trim());
			HashMap<String, Integer> votes = new HashMap<String, Integer>();
			HashMap<String, String> parties = new HashMap<String, String>();
			
			for (int i = 0; i < N; ++i) {
				String name = in.readLine().trim();
				String party = in.readLine().trim();
				parties.put(name, party);
				votes.put(name, 0);
			}
			
			int M = Integer.parseInt(in.readLine().trim());
			for (int i = 0; i < M; ++i) {
				String name = in.readLine();
				if (!votes.containsKey(name)) continue;
				int v = votes.get(name);
				votes.put(name, v + 1);
			}
			
			int max = 0;
			for (int v : votes.values())
				max = Math.max(max, v);
			int cnt = 0;
			String party = "";
			for (String n : votes.keySet()) {
				int v = votes.get(n);
				if (v == max) {
					++cnt;
					party = parties.get(n);
				}
			}
			
			if (first) first = false; else System.out.println();
			if (cnt > 1)
				System.out.println("tie");
			else
				System.out.println(party);
		}
		
		in.close();
		System.exit(0);
	}
}
