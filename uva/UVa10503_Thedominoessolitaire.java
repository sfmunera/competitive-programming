package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 1444 (10503 - The dominoes solitaire) */
/* SUBMISSION: 11038779 */
/* SUBMISSION TIME: 2012-12-17 00:18:44 */
/* LANGUAGE: 2 */

import java.io.*;

public class UVa10503_Thedominoessolitaire {
	
	static int M;
	static Piece[] other;
	static Piece right;
	
	static class Piece {
		int left, right;
		public Piece(int l, int r) {
			this.left = l; this.right = r;
		}
		public Piece flip() {
			return new Piece(this.right, this.left);
		}
		public boolean match(Piece p) {
			return this.right == p.left;
		}
		public String toString() {
			return "(" + this.left + ", " + this.right + ")";
		}
	}
	
	static boolean can(Piece left, int N, int taken) {
		if (N == 0)
			if (left.match(right)) return true;
			else return false;
		
		for (int i = 0; i < M; ++i)
			if ((taken & (1 << i)) == 0) {
				if (left.match(other[i]) && can(other[i], N - 1, taken | (1 << i)))
					return true;
				if (left.match(other[i].flip()) && can(other[i].flip(), N - 1, taken | (1 << i)))
					return true;
			}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) break;
			M = Integer.parseInt(in.readLine());
			
			String[] parts = in.readLine().split("[ ]+");
			Piece left = new Piece(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			parts = in.readLine().split("[ ]+");
			right = new Piece(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			
			other = new Piece[M];
			
			for (int i = 0; i < M; ++i) {
				parts = in.readLine().split("[ ]+");
				other[i] = new Piece(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			}
			
			System.out.println(can(left, N, 0) ? "YES" : "NO");
		}
		
		in.close();
		System.exit(0);
	}
}
