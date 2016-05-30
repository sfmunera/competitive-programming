package livearchive;

import java.util.*;

public class Dice {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int P = in.nextInt();
			int S = in.nextInt();
			if (P == 0 && S == 0) {
				break;
			}
			
			int[] traps = new int[3];
			int[] pos = new int[P];
			boolean[] skip = new boolean[P];
			
			for (int i = 0; i < 3; ++i) {
				traps[i] = in.nextInt();
			}
			int N = in.nextInt();
			int turn = 0;
			
			int winner = -1;
			for (int i = 0; i < N; ++i) {
				int d1 = in.nextInt();
				int d2 = in.nextInt();
				
				while (skip[turn]) {
					skip[turn] = false;
					++turn;
					turn %= P;
				}
				pos[turn] += d1 + d2;
				for (int t = 0; t < 3; ++t) {
					if (pos[turn] == traps[t]) {
						skip[turn] = true;
						break;
					}
				}
				if (pos[turn] > S && winner < 0) {
					winner = turn;
				}
				++turn;
				turn %= P;
			}
			
			System.out.println(winner + 1);
		}
		
		in.close();
		System.exit(0);
	}
}
