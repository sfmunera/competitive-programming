package facebook;

import java.io.*;

public class Billboards {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("billboards.txt"));
		PrintWriter out = new PrintWriter("output.txt");
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] parts = in.readLine().split("[ ]+");
			int W = Integer.parseInt(parts[0]);
			int H = Integer.parseInt(parts[1]);
			
			int res = 0;
			for (int size = 1; size <= H; ++size) {
				int w = 0;
				int h = size;
				int cnt = 0;
				for (int j = 2; j < parts.length;) {
					if (parts[j].length() * size > W)
						break;
					int space = w > 0 ? 1 : 0;
					if (w + (parts[j].length() + space) * size <= W) {
						w += (parts[j].length() + space) * size;
						++cnt;
						++j;
					} else {
						w = 0;
						h += size;
					}
					
				}
				if (h <= H && cnt == parts.length - 2)
					res = size;
			}
			out.println("Case #" + t + ": " + res);
		}
		
		in.close();
		out.close();
		System.exit(0);
	}
}
