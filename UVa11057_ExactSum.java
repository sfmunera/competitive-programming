package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1998 (11057 - Exact Sum) */
/* SUBMISSION: 10243546 */
/* SUBMISSION TIME: 2012-06-20 22:10:53 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa11057_ExactSum {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			String[] parts = in.readLine().split("[ ]+");
			int[] numbers = new int[N];
			
			for (int i = 0; i < N; ++i)
				numbers[i] = Integer.parseInt(parts[i]);
			int M = Integer.parseInt(in.readLine());
			in.readLine();
			
			Arrays.sort(numbers);
			
			int mindiff = Integer.MAX_VALUE;
			int besti = -1;
			int bestj = -1;
			for (int i = 0; i < N; ++i) {
				int j = Arrays.binarySearch(numbers, M - numbers[i]);
				if (j < 0)
					continue;
				if (i != j) {
					int diff = Math.abs(numbers[i] - numbers[j]);
					if (diff < mindiff) {
						mindiff = diff;
						besti = numbers[i];
						bestj = numbers[j];
					}
				} else {
					if (i > 0 && numbers[i - 1] == numbers[i]) {
						mindiff = 0;
						besti = numbers[i - 1];
						bestj = numbers[i];
					}
					if (i < N && numbers[i] == numbers[i + 1]) {
						mindiff = 0;
						besti = numbers[i];
						bestj = numbers[i + 1];
					}
				}
			}
			
			System.out.printf("Peter should buy books whose prices are %d and %d.\n\n", Math.min(besti, bestj), Math.max(besti, bestj));
		}
		
		in.close();
		System.exit(0);
	}
}