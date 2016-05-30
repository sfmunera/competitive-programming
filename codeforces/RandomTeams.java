package codeforces;

import java.util.*;

public class RandomTeams {
	
	static long numPairs(long n) {
		return n * (n - 1) / 2;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		// Divide evenly among buckets
		int perBucket = n / m;
		long numPairs1 = m * numPairs(perBucket) + perBucket * (n % m);
		
		// Put as many as possible in one bucket
		long numPairs2 = numPairs(n - m + 1);
		
		System.out.println(Math.min(numPairs1, numPairs2) + " " + Math.max(numPairs1, numPairs2));
		
		in.close();
		System.exit(0);
	}
}
