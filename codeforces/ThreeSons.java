package codeforces;

import java.io.*;
import java.util.*;

public class ThreeSons {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		int[][] field = new int[N][M];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < M; ++j)
				field[i][j] = in.nextInt();
		
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		
		int[] sum = {A, B, C};
		Arrays.sort(sum);
		
		int ans = 0;
		for (int i = 0; i < N - 1; ++i)
			for (int j = i + 1; j < N - 1; ++j) {
				int sA = 0;
				int sB = 0;
				int sC = 0;
				for (int k = 0; k < M; ++k)
					for (int l = 0; l <= i; ++l)
						sA += field[l][k];
				for (int k = 0; k < M; ++k)
					for (int l = i + 1; l <= j; ++l)
						sB += field[l][k];
				for (int k = 0; k < M; ++k)
					for (int l = j + 1; l < N; ++l)
						sC += field[l][k];
				
				int[] sum2 = {sA, sB, sC};
				Arrays.sort(sum2);
				if (sum[0] == sum2[0] && sum[1] == sum2[1] && sum[2] == sum2[2])
					++ans;
			}
		System.out.println(ans);
			
		for (int i = 0; i < M - 1; ++i)
			for (int j = i + 1; j < M - 1; ++j) {
				int sA = 0;
				int sB = 0;
				int sC = 0;
				for (int k = 0; k < N; ++k)
					for (int l = 0; l <= i; ++l)
						sA += field[k][l];
				for (int k = 0; k < N; ++k)
					for (int l = i + 1; l <= j; ++l)
						sB += field[k][l];
				for (int k = 0; k < N; ++k)
					for (int l = j + 1; l < M; ++l)
						sC += field[k][l];
				
				int[] sum2 = {sA, sB, sC};
				Arrays.sort(sum2);
				if (sum[0] == sum2[0] && sum[1] == sum2[1] && sum[2] == sum2[2])
					++ans;
			}
		System.out.println(ans);
		out.println(ans);
		out.close();
	}
}