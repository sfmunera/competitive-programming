package codeforces;

import java.util.*;
import java.io.*;

public class Winner {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, int[]> rounds = new HashMap<String, int[]>();
		
		int N = Integer.parseInt(in.readLine());
		for (int i = 1; i <= N; ++i) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			String name = stk.nextToken();
			int points = Integer.parseInt(stk.nextToken());
			
			if (!rounds.containsKey(name))
				rounds.put(name, new int[N + 1]);
			
			rounds.get(name)[i] =  points + rounds.get(name)[i - 1];
			
			for (String s : rounds.keySet())
				if (!s.equals(name))
					rounds.get(s)[i] = rounds.get(s)[i - 1];
		}
		
		int max = 0;
		for (String s : rounds.keySet())
			max = Math.max(rounds.get(s)[N], max);
		
		int cnt = 0;
		String winner = "";
		for (String s : rounds.keySet())
			if (rounds.get(s)[N] == max) {
				++cnt;
				winner = s;
			}
		
		if (cnt > 1) {
			int earliest = Integer.MAX_VALUE;
			for (String s : rounds.keySet())
				if (rounds.get(s)[N] == max)
					for (int t = 1; t <= N; ++t)
						if (rounds.get(s)[t] >= max && t < earliest) {
							earliest = t;
							winner = s;
						}
		}
		System.out.println(winner);
		
		in.close();
		System.exit(0);
	}
}