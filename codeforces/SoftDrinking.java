package codeforces;

import java.io.*;

public class SoftDrinking {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = in.readLine().split("[ ]");
		int n = Integer.parseInt(parts[0]);
		int k = Integer.parseInt(parts[1]);
		int l = Integer.parseInt(parts[2]);
		int c = Integer.parseInt(parts[3]);
		int d = Integer.parseInt(parts[4]);
		int p = Integer.parseInt(parts[5]);
		int nl = Integer.parseInt(parts[6]);
		int np = Integer.parseInt(parts[7]);
		
		int mili = k * l;
		int slices = c * d;
		
		System.out.println(Math.min(mili / nl, Math.min(slices, p / np)) / n);
		
		in.close();
		System.exit(0);
	}
}
