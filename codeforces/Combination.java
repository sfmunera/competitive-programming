package codeforces;

import java.util.*;

public class Combination {
	
	static class Card implements Comparable<Card> {
		int a, b;
		Card(int a, int b) {this.a = a; this.b = b;}
		
		@Override
		public int compareTo(Card that) {
			if (this.b != that.b)
				return that.b - this.b;
			return that.a - this.a;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		Card[] cards = new Card[n];
		for (int i = 0; i < n; ++i) {
			int a = in.nextInt();
			int b = in.nextInt();
			cards[i] = new Card(a, b);
		}
		Arrays.sort(cards);
		int ans = 0;
		int cnt = 1;
		for (Card card : cards) {
			ans += card.a;
			--cnt;
			cnt += card.b;
			if (cnt <= 0) break;
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
