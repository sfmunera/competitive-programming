package codeforces;

import java.io.*;
import java.util.*;

public class WinOrFreeze {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(in.readLine());
		ArrayList<Long> div = new ArrayList<Long>();
		for (long i = 2; i <= N / i; ++i) 
			while (N % i == 0) {
				div.add(i);
				N /= i;
			}
		if (N > 1) div.add(N);
		if (div.size() <= 1) {
			System.out.println(1);
			System.out.println(0);
		}
		else if (div.size() == 2)
			System.out.println(2);
		else {
			System.out.println(1);
			System.out.println(div.get(0) * div.get(1));
		}
		in.close();
		System.exit(0);
	}
}
