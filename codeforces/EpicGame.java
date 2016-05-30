package codeforces;

import java.util.*;
import java.io.*;

public class EpicGame {
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		
		int[] players = {a, b};
		int n = Integer.parseInt(stk.nextToken());
		
		int turn = 0;
		while (true) {
			int g = gcd(players[turn], n);
			if (n < g) break;
			
			n -= g;
			turn = 1 - turn;
		}
		System.out.println(1 - turn);
		
		in.close();
		System.exit(0);
	}
}
