package uva;

import java.util.*;
import java.io.*;

public class UVa00264_CountOnCantor {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			int x = (int)Math.ceil((Math.sqrt(1.0 + 8.0 * N) - 1.0) / 2.0 - 1e-9);

			int n1 = x;
			int n2 = 1;
			for (int i = x * (x - 1) / 2 + 1; i < N; ++n2, --n1, ++i);
			System.out.println("TERM " + N + " IS " + (x % 2 == 1 ? n1 + "/" + n2 : n2 + "/" + n1));
		}
		
		in.close();
		System.exit(0);
	}
}
