package uva;

import java.util.*;
import java.io.*;

public class UVa00131_ThePsychicPokerPlayer {

	static final String[] hands = {"highest-card", "one-pair", "two-pairs", "three-of-a-kind", 
					"straight", "flush", "full-house", "four-of-a-kind", "straight-flush"};

	static boolean isOnePair(String[] hand) {
		for (int i = 0; i < 5; ++i)
			for (int j = i + 1; j < 5; ++j)
				if (hand[i].charAt(0) == hand[j].charAt(0))
					return true;
		return false;
	}

	static boolean isTwoPairs(String[] hand) {
		boolean[] seen = new boolean[5];
		boolean ok = false;
		for (int i = 0; i < 5 && !ok; ++i)
                        for (int j = i + 1; j < 5 && !ok; ++j)
                                if (hand[i].charAt(0) == hand[j].charAt(0)) {
					seen[i] = true;
					seen[j] = true;
					ok = true;
				}
		if (!ok) return false;

		for (int i = 0; i < 5; ++i)
                        for (int j = i + 1; j < 5; ++j)
                                if (!seen[i] && !seen[j] && hand[i].charAt(0) == hand[j].charAt(0))
					return true;
		return false;
	}

	static boolean isThreeOfAKind(String[] hand) {
		for (int i = 0; i < 5; ++i)
                        for (int j = i + 1; j < 5; ++j)
				for (int k = j + 1; k < 5; ++k)
                                	if (hand[i].charAt(0) == hand[j].charAt(0) && 
						hand[j].charAt(0) == hand[k].charAt(0))
                                        	return true;
                return false;
	}

	static boolean isStraight(String[] hand) {
		int[] val = new int[5];
		for (int i = 0; i < 5; ++i)
			if (hand[i].charAt(0) >= '2' && hand[i].charAt(0) <= '9')
				val[i] = hand[i].charAt(0) - '0';
			else if (hand[i].charAt(0) == 'T')
				val[i] = 10;
			else if (hand[i].charAt(0) == 'J')
                                val[i] = 11;
			else if (hand[i].charAt(0) == 'Q')
                                val[i] = 12;
			else if (hand[i].charAt(0) == 'K')
                                val[i] = 13;
			else if (hand[i].charAt(0) == 'A')
                                val[i] = 14;

		Arrays.sort(val);
		boolean ok = true;
		for (int i = 1; i < 5; ++i)
			if (val[i] != val[i - 1] + 1)
				ok = false;
		if (ok)
			return true;

		for (int i = 0; i < 5; ++i)
                        if (hand[i].charAt(0) >= '2' && hand[i].charAt(0) <= '9')
                                val[i] = hand[i].charAt(0) - '0';
                        else if (hand[i].charAt(0) == 'T')
                                val[i] = 10;
                        else if (hand[i].charAt(0) == 'J')
                                val[i] = 11;
                        else if (hand[i].charAt(0) == 'Q')
                                val[i] = 12;
                        else if (hand[i].charAt(0) == 'K')
                                val[i] = 13;
                        else if (hand[i].charAt(0) == 'A')
                                val[i] = 1;

                Arrays.sort(val);
                for (int i = 1; i < 5; ++i)
                        if (val[i] != val[i - 1] + 1)
                                return false;

		return true;
	}

	static boolean isFlush(String[] hand) {
		for (int i = 1; i < 5; ++i)
			if (hand[i].charAt(1) != hand[i - 1].charAt(1))
				return false;
		return true;
	}

	static boolean isFullHouse(String[] hand) {
		boolean[] seen = new boolean[5];
                boolean ok = false;
                for (int i = 0; i < 5 && !ok; ++i)
                        for (int j = i + 1; j < 5 && !ok; ++j)
				for (int k = j + 1; k < 5 && !ok; ++k)
                                	if (hand[i].charAt(0) == hand[j].charAt(0) &&
                                                hand[j].charAt(0) == hand[k].charAt(0)) {
                                        	seen[i] = true;
                                        	seen[j] = true;
						seen[k] = true;
                                        	ok = true;
                                	}
                if (!ok) return false;

		for (int i = 0; i < 5; ++i)
                        for (int j = i + 1; j < 5; ++j)
                        	if (!seen[i] && !seen[j] && hand[i].charAt(0) == hand[j].charAt(0))
					return true;
                return false;
	}

	static boolean isFourOfAKind(String[] hand) {
		for (int i = 0; i < 5; ++i)
			for (int j = i + 1; j < 5; ++j)
				for (int k = j + 1; k < 5; ++k)
					for (int l = k + 1; l < 5; ++l)
						if (hand[i].charAt(0) == hand[j].charAt(0) &&
							hand[j].charAt(0) == hand[k].charAt(0) &&
							hand[k].charAt(0) == hand[l].charAt(0))
							return true;
		return false;
	}

	static boolean isStraightFlush(String[] hand) {
		return isStraight(hand) && isFlush(hand);
	}

	static int getHandValue(String[] hand) {
		if (isStraightFlush(hand)) return 8;
		if (isFourOfAKind(hand)) return 7;
		if (isFullHouse(hand)) return 6;
		if (isFlush(hand)) return 5;
		if (isStraight(hand)) return 4;
		if (isThreeOfAKind(hand)) return 3;
		if (isTwoPairs(hand)) return 2;
		if (isOnePair(hand)) return 1;

		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		String line;
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line);
			String[] hand = new String[5];
			String[] deck = new String[5];

			for (int i = 0; i < 5; ++i)
				hand[i] = stk.nextToken();
			for (int i = 0; i < 5; ++i)
				deck[i] = stk.nextToken();

			int max = 0;
			for (int mask = 0; mask < (1 << 5); ++mask) {
				String[] newHand = new String[5];
				int k = 0;
				for (int i = 0; i < 5; ++i)
					if ((mask & (1 << i)) > 0)
						newHand[k++] = hand[i];
				int rem = 5 - k;
				for (int i = 0; i < rem; ++i)
					newHand[k++] = deck[i];
				max = Math.max(max, getHandValue(newHand));
			}

			System.out.print("Hand:");
			for (int i = 0; i < 5; ++i)
				System.out.print(" " + hand[i]);
			System.out.print(" Deck:");
			for (int i = 0; i < 5; ++i)
                                System.out.print(" " + deck[i]);
			System.out.println(" Best hand: " + hands[max]);
		}
		
		in.close();
		System.exit(0);
	}
}
