package codejam;

import java.util.*;
import java.io.*;

public class DancingWithTheGooglers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("in.txt"));
		PrintWriter out = new PrintWriter(new File("out.txt"));
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[ ]+");
			int N = Integer.parseInt(parts[0]);
			int S = Integer.parseInt(parts[1]);
			int p = Integer.parseInt(parts[2]);
			int[] scores = new int[N];
			
			for (int i = 0; i < N; ++i)
				scores[i] = Integer.parseInt(parts[3 + i]);
			
			int max = 0;
			for (int i = 0; i < (1 << N); ++i) {
				if (Integer.bitCount(i) == S) {
					int cnt = 0;
					for (int j = 0; j < N; ++j) {
						int mod = scores[j] % 3;
						int score = scores[j] / 3;
						if (mod == 1 || mod == 2)
							++score;
						if ((i & (1 << j)) != 0) { // if surprising
							if (scores[j] > 1 && (mod == 0 || mod == 2))
								++score;
						}
						score = Math.min(score, 10);
						if (score >= p)
							++cnt;
						//System.out.println(score);
					}
					max = Math.max(max, cnt);
				}
			}
			
			System.out.println("Case #" + t + ": " + max);
		}
		
		in.close();
		out.close();
		System.exit(0);
	}
}
