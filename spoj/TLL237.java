package spoj;

import java.util.*;
import java.io.*;

public class TLL237 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		String seq = in.next();
		
		PriorityQueue<Integer> Q = new PriorityQueue<Integer>();
		for (int i = 0; i < N; ++i)
			Q.offer(0);
		
		for (int i = 0; i < seq.length(); ++i) {
			if (seq.charAt(i) == '1') {
				int less = Q.poll();
				++less;
				Q.offer(less);
			} else {
				int less = Q.poll();
				int less2 = Q.poll();
				++less2;
				Q.offer(less);
				Q.offer(less2);
			}
		}
		
		int less = Q.poll();
		int less2 = Q.poll();
		System.out.println(less + " " + less2);
		
		in.close();
		System.exit(0);
	}
}
