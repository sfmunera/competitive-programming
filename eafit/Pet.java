package eafit;

import java.io.*;

public class Pet {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] score = new int[5];
		for (int i = 0; i < 5; ++i) {
			String[] parts = in.readLine().split("[ ]+");
			for (int j = 0; j < parts.length; ++j)
				score[i] += Integer.parseInt(parts[j]);
		}
		
		int maxAt = 0;
		for (int i = 0; i < 5; ++i)
			if (score[i] > score[maxAt])
				maxAt = i;
		
		System.out.println((maxAt + 1) + " " + score[maxAt]);
		
		in.close();
		System.exit(0);
	}
}
