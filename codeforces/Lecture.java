package codeforces;

import java.util.*;

public class Lecture {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		Map<String, String> dict = new HashMap<String, String>();
		
		for (int i = 0; i < m; ++i) {
			dict.put(in.next(), in.next());
		}

		for (int i = 0; i < n; ++i) {
			String word = in.next();
			
			if (i > 0) System.out.print(" ");
			System.out.print(word.length() <= dict.get(word).length() ? word : dict.get(word));
		}
		System.out.println();
		
		in.close();
		System.exit(0);
	}
}
