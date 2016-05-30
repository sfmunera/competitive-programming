package facebook;


import java.util.*;
import java.io.*;

public class BeautifulStrings {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("in.txt"));
		System.setOut(new PrintStream(new FileOutputStream("out.txt")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			char[] line = in.readLine().toLowerCase().toCharArray();
			
			int[] freq = new int[26];
			for (char c : line)
				if (c >= 'a' && c <= 'z')
					++freq[c - 'a'];
			
			Arrays.sort(freq);
			int ans = 0;
			for (int i = 1; i <= 26; ++i)
				ans += i * freq[i - 1];
			
			System.out.println("Case #" + t + ": " + ans);
		}
		
		in.close();
		System.exit(0);
	}
}
