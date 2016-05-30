package codeforces;

import java.util.*;

public class LittleElephantAndMagicSquare {
	
	static final int MAX = (int) 1e5;
	
	static boolean isMagic(int[][] square) {
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				if (square[i][j] < 1 || square[i][j] > MAX)
					return false;
		
		int sum = square[0][0] + square[1][1] + square[2][2];
		for (int i = 0; i < 3; ++i) {
			int sumHor = 0;
			int sumVer = 0;
			for (int j = 0; j < 3; ++j) {
				sumHor += square[i][j];
				sumVer += square[j][i];
			}
			if (sumHor != sum || sumVer != sum) return false;
		}
		
		return square[0][2] + square[1][1] + square[2][0] == sum;
	}
	
	static void print(int[][] square) {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (j > 0) System.out.print(" ");
				System.out.print(square[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[][] square = new int[3][3];
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				square[i][j] = in.nextInt();
			}
		}
		
		for (int center = 1; center <= MAX; ++center) {
			square[1][1] = center;
			int sum = square[1][0] + square[1][1] + square[1][2];
			square[0][0] = sum - square[1][0] - square[2][0];
			square[2][2] = sum - square[0][2] - square[1][2];
			
			if (isMagic(square)) {
				print(square);
				break;
			}
		}
		
		in.close();
		System.exit(0);
	}
}
