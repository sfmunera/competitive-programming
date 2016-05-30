package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 455 (514 - Rails) */
/* SUBMISSION: 10082248 */
/* SUBMISSION TIME: 2012-05-06 16:58:35 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00514_Rails {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0)
				break;
			
			while (true) {
				String line = in.readLine();
				if (line.equals("0"))
					break;
				String[] parts = line.split("[ ]+");
				int[] perm = new int[N];
				
				for (int i = 0; i < N; ++i)
					perm[i] = Integer.parseInt(parts[i]);
				int j = 0;
				
				Stack<Integer> S = new Stack<Integer>();
				for (int x = 1; x <= N; ++x) {
					S.push(x);
					while (!S.isEmpty() && S.peek() == perm[j]) {
						S.pop();
						++j;
					}
				}
				
				if (S.isEmpty())
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
