package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 3788 (12366 - King's Poker) */
/* SUBMISSION: 11511654 */
/* SUBMISSION TIME: 2013-03-26 19:22:36 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa12366_KingsPoker {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			
			if (A == 0 && B == 0 && C == 0) break;
			
			int[] ans = new int[3];
			boolean found = true;;
			if (A == B && B == C) {
				if (A == 13)
					found = false;
				else
					ans = new int[]{A + 1, A + 1, A + 1};
			} else if (A != B && A != C && B != C) {
				ans = new int[]{1, 1, 2};
			} else {
				int[] hand = {A, B, C};
				Arrays.sort(hand);
				
				if (hand[1] == hand[2]) {
					int t = hand[0];
					hand[0] = hand[2];
					hand[2] = t;
				}
				assert hand[0] == hand[1] && hand[1] != hand[2];
				
				if (hand[0] == 13 && hand[2] == 12)
					ans = new int[]{1, 1, 1};
				else {
					if (hand[2] == 13)
						ans = new int[]{1, hand[0] + 1, hand[0] + 1};
					else if (hand[0] == hand[2] + 1)
						ans = new int[]{hand[0], hand[0], hand[0] + 1};
					else
						ans = new int[]{hand[0], hand[0], hand[2] + 1};
				}
			}
			if (!found)
				System.out.println("*");
			else {
				Arrays.sort(ans);
				System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
			}
		}
		
		in.close();
		System.exit(0);
	}
}
