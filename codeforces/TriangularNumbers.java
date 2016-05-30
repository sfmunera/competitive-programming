package codeforces;

import java.util.*;
import java.io.*;

public class TriangularNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<Integer> T = new HashSet<Integer>();
		int t;
		for (int i = 0; (t = i * (i + 1) / 2) <= 500; ++i)
			T.add(t);
		
		int N = Integer.parseInt(in.readLine());
		System.out.println(T.contains(N) ? "YES" : "NO");
		
		in.close();
		System.exit(0);
	}
}
