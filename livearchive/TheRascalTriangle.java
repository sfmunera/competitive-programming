package livearchive;

import java.io.*;

public class TheRascalTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(in.readLine());
		for (int p = 1; p <= P; ++p) {
			String[] parts = in.readLine().split("[ ]+");
			int n = Integer.parseInt(parts[1]);
			int m = Integer.parseInt(parts[2]);
			
			System.out.println(p + " " + ((n - m) * m + 1));
		}
		
		in.close();
		System.exit(0);
	}
}
