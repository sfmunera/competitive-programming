package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 80 (144 - Student Grants) */
/* SUBMISSION: 11336881 */
/* SUBMISSION TIME: 2013-02-24 16:28:50 */
/* LANGUAGE: 2 */

import java.io.*;
import java.util.*;

public class UVa00144_StudentGrants {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int k = Integer.parseInt(parts[1]);
			
			if (N == 0 && k == 0)
				break;
				
			int[] pay = new int[N];
			Queue<Integer> Q = new LinkedList<Integer>();
			for (int i = 0; i < N; ++i)
				Q.offer(i);
			
			int am = 1;
			int store = 0;
			while (!Q.isEmpty()) {
				//System.out.println("store: " + store + ", amount: " + am);
				int x = Q.poll();
				if (store == 0) {
					store = am;
					++am;
					if (am > k) am = 1;
				}
				
				if (pay[x] + store <= 40) {
					pay[x] += store;
					store = 0;
				} else {
					store -= 40 - pay[x];
					pay[x] = 40;
				}
				
				if (pay[x] < 40)
					Q.offer(x);
				else
					System.out.format("%3d", x + 1);
			}
			System.out.println();
		}
		
		in.close();
		System.exit(0);
	}
}
