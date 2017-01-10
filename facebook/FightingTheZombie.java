package facebook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class FightingTheZombie {
	
	static double[][] fillTable(int numRolls, int numSides) {
		double[][] frequencyTable = new double[numRolls + 1][numRolls * numSides + 1];
		for (int side = 1; side <= numSides; side++) {
			frequencyTable[1][side] = 1.0;
		}
		
		for (int roll = 2; roll <= numRolls; roll++) {
			for (int sum = roll - 1; sum <= (roll - 1) * numSides; sum++) {
				for (int side = 1; side <= numSides; side++) {
					frequencyTable[roll][sum + side] += frequencyTable[roll - 1][sum];
				}
			}
		}

		return frequencyTable;
	}
	
	static int[] parseSpell(String spell) {
		int[] parts = new int[3];
		String[] parts1 = spell.split("d");
		parts[0] = Integer.parseInt(parts1[0]);
		
		String[] parts2 = parts1[1].split("[\\+\\-]");
		parts[1] = Integer.parseInt(parts2[0]);
		if (parts2.length == 2) {
			parts[2] = Integer.parseInt(parts2[1]) * (parts1[1].contains("-") ? -1 : 1);
		}
		
		return parts;
	}
	
	public static void main(String[] args) throws IOException {		
		System.setIn(new FileInputStream(new File("fighting_the_zombie.txt")));
		System.setOut(new PrintStream(new File("fighting_the_zombie.out")));
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		for (int testNumber = 1; testNumber <= T; testNumber++) {
			int H = in.nextInt();
			int S = in.nextInt();
			double max = 0.0;
			for (int i = 0; i < S; i++) {
				String spell = in.next();
				int[] parts = parseSpell(spell);
				assert parts.length == 3;
				int numRolls = parts[0];
				int numSides = parts[1];
				int Z = parts[2];
				
				double[][] frequencyTable = fillTable(numRolls, numSides);
				double total = 0.0;
				double damage = 0.0;
				for (int sum = 0; sum <= numRolls * numSides; sum++) {
					total += frequencyTable[numRolls][sum];
					if (sum + Z >= H) {
						damage += frequencyTable[numRolls][sum];
					}
				}
				double prob = damage / total;
				max = Math.max(max, prob);
			}
					
			System.out.printf("Case #%d: %.6f\n", testNumber, max);
		}
		
		in.close();
		System.exit(0);
	}
}
