package codeforces;

import java.util.*;

public class TwoTables {
	
	static int shift(char[][] tableA, char[][] tableB, int x, int y) {
		int nA = tableA.length;
		int mA = tableA[0].length;
		int nB = tableB.length;
		int mB = tableB[0].length;
		
		int sum = 0;
		for (int i = 0; i < nA; ++i) {
			for (int j = 0; j < mA; ++j) {
				if (i + x >= 0 && i + x < nB && j + y >= 0 && j + y < mB) {
					sum += (tableA[i][j] - '0') * (tableB[i + x][j + y] - '0');
				}
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int nA = in.nextInt();
		int mA = in.nextInt();
		char[][] tableA = new char[nA][mA];
		
		for (int i = 0; i < nA; ++i) {
			tableA[i] = in.next().toCharArray();
		}
		
		int nB = in.nextInt();
		int mB = in.nextInt();
		char[][] tableB = new char[nB][mB];
		
		for (int i = 0; i < nB; ++i) {
			tableB[i] = in.next().toCharArray();
		}
		
		int maxShift = 0;
		int bestX = 0;
		int bestY = 0;
		for (int x = -Math.max(nA, nB); x <= Math.max(nA, nB); ++x) {
			for (int y = -Math.max(mA, mB); y <= Math.max(mA, mB); ++y) {
				int shift = shift(tableA, tableB, x, y);
				if (shift > maxShift) {
					maxShift = shift;
					bestX = x;
					bestY = y;
				}
			}
		}
		
		System.out.println(bestX + " " + bestY);
		
		in.close();
		System.exit(0);
	}
}
