package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1217 (10276 - Hanoi Tower Troubles Again!) */
/* SUBMISSION: 09204467 */
/* SUBMISSION TIME: 2011-08-30 02:55:18 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa10276_HanoiTowerTroublesAgain {
	
	static Stack<Integer>[] pegs;
	static int N;
	static int res;
	
	static void solve(int K) {
		//System.out.println(Arrays.toString(pegs));
		
		for (int i = 0; i < N; ++i) {
			if (pegs[i].isEmpty()) {
				res = Math.max(res, K);
				pegs[i].push(K);
				solve(K + 1);
				pegs[i].pop();
				//System.out.println("Hello1");
			} else {
				int top = pegs[i].peek();
				int sqr = top + K;
				int sqrt = (int)Math.round(Math.sqrt(sqr));
				if (sqrt * sqrt == sqr) {
					res = Math.max(res, K);
					pegs[i].push(K);
					solve(K + 1);
					pegs[i].pop();
					//System.out.println("Hello2");
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		int[] hanoi = new int[51];
		
		hanoi[0] = -1;
		for (int i = 1; i <= 50; i += 2) {
			hanoi[i] = hanoi[i - 1] + i + 1;
			hanoi[i + 1] = hanoi[i] + i + 1;
		}
		//System.out.println(Arrays.toString(hanoi));
		
		while (T-- > 0) {
			N = Integer.parseInt(in.readLine());
			
			System.out.println(hanoi[N]);
		}
		
		in.close();
		System.exit(0);
	}
}
