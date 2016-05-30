package codeforces;

import java.io.*;

public class Sleuth {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String vowels = "AEIOUY";
		
		String q = in.readLine();
		for (int i = q.length() - 1; i >= 0; --i)
			if (Character.isLetter(q.charAt(i))) {
				if (vowels.indexOf(Character.toUpperCase(q.charAt(i))) >= 0)
					System.out.println("YES");
				else
					System.out.println("NO");
				break;
			}
		
		
		in.close();
		System.exit(0);
	}
}
