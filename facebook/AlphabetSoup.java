package facebook;

import java.io.*;

public class AlphabetSoup {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("alphabet_soup.txt"));
		PrintWriter out = new PrintWriter("output.txt");
		
		String word = "HACKERCUP";
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			int res = Integer.MAX_VALUE;
			char[] line = in.readLine().toCharArray();
			int[] freq = new int[26];
			
			for (char c : line)
				if (c != ' ')
					++freq[c - 'A'];
			
			for (int i = 0; i < word.length(); ++i)
				res = Math.min(res, freq[word.charAt(i) - 'A']);
			
			out.println("Case #" + t + ": " + res);
		}
		
		in.close();
		out.close();
		System.exit(0);
	}
}
