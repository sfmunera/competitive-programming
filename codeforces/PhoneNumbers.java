package codeforces;

import java.io.*;
import java.util.*;

public class PhoneNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(in.readLine());
		String[] names = new String[N];
		int[] pizza = new int[N];
		int[] taxi = new int[N];
		int[] women = new int[N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer stk = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(stk.nextToken());
			String name = stk.nextToken();
			
			names[i] = name;
			for (int j = 0; j < s; ++j) {
				String[] parts = in.readLine().split("-");
				String phone = parts[0] + parts[1] + parts[2];
				boolean isTaxi = true;
				for (int k = 1; k < phone.length(); ++k)
					if (phone.charAt(k - 1) != phone.charAt(k)) {
						isTaxi = false;
						break;
					}
				if (isTaxi) {
					++taxi[i];
					continue;
				}
				boolean isPizza = true;
				int prev = 1000;
				for (int k = 0; k < phone.length(); ++k) {
					if ((phone.charAt(k) - '0') >= prev) {
						isPizza = false;
						break;
					}
					prev = phone.charAt(k) - '0';
				}
				if (isPizza) {
					++pizza[i];
					continue;
				}
				++women[i];
			}
		}
		
		int max = 0;
		boolean first = true;
		for (int i = 0; i < N; ++i)
			max = Math.max(max, taxi[i]);
		
		System.out.print("If you want to call a taxi, you should call:");
		for (int i = 0; i < N; ++i)
			if (taxi[i] == max) {
				if (first) first = false; else System.out.print(",");
				System.out.print(" " + names[i]);
			}
		System.out.println(".");
		
		max = 0;
		first = true;
		for (int i = 0; i < N; ++i)
			max = Math.max(max, pizza[i]);
		
		System.out.print("If you want to order a pizza, you should call:");
		for (int i = 0; i < N; ++i)
			if (pizza[i] == max) {
				if (first) first = false; else System.out.print(",");
				System.out.print(" " + names[i]);
			}
		System.out.println(".");
		
		max = 0;
		first = true;
		for (int i = 0; i < N; ++i)
			max = Math.max(max, women[i]);
		
		System.out.print("If you want to go to a cafe with a wonderful girl, you should call:");
		for (int i = 0; i < N; ++i)
			if (women[i] == max) {
				if (first) first = false; else System.out.print(",");
				System.out.print(" " + names[i]);
			}
		System.out.println(".");
		
		in.close();
		System.exit(0);
	}
}
