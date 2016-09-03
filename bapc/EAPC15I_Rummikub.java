package bapc;

import java.util.*;

public class EAPC15I_Rummikub {
	
	static final int MAX_VALUE = 100;
	
	static boolean thereIsGroup(Map<Character, int[]> hand) {
		for (int i = 1; i <= MAX_VALUE; ++i) {
			int cnt = 0;
			for (char c : "bgry".toCharArray())
				if (hand.get(c)[i] > 0)
					++cnt;
			if (cnt >= 3) return true;
		}
		return false;
	}
	
	static int maxRun(int[] a) {
		int max = 0;
		int run = 0;
		for (int i = 0; i < a.length; ++i) {
			if (a[i] == 0) {
				max = Math.max(max, run);
				run = 0;
			} else {
				++run;
			}
		}
		max = Math.max(max, run);
		
		return max;
	}
	
	static boolean thereIsRun(Map<Character, int[]> hand) {
		for (char c : "bgry".toCharArray())
			if (maxRun(hand.get(c)) >= 3)
				return true;
		return false;
	}
	
	static void solve(Map<Character, int[]> hand) {
		System.out.println(thereIsGroup(hand) || thereIsRun(hand) ? "YES" : "NO");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int M = in.nextInt();
			
			Map<Character, int[]> hand = new HashMap<Character, int[]>();
			for (char c : "bgry".toCharArray()) {
				hand.put(c, new int[MAX_VALUE + 1]);
			}
			
			for (int i = 0; i < M; ++i) {
				String tile = in.next();
				char suit = tile.charAt(tile.length() - 1);
				int value = Integer.parseInt(tile.substring(0, tile.length() - 1));
				
				++hand.get(suit)[value];
			}
			
			solve(hand);
		}
		
		in.close();
		System.exit(0);
	}
}
