import java.util.*;
import java.io.*;

public class MagicSquare {
	
	static int N, S;
	static int[][] square;
	static boolean[] used;
	static boolean solved;
	
	static boolean isSolved(int[][] square) {
		int sum = 0;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				if (square[i][j] <= 0)
					return false;
		
		for (int i = 0; i < N; ++i) {
			sum = 0;
			for (int j = 0; j < N; ++j)
				sum += square[i][j];
			if (sum != S)
				return false;
		}
		for (int j = 0; j < N; ++j) {
			sum = 0;
			for (int i = 0; i < N; ++i)
				sum += square[i][j];
			if (sum != S)
				return false;
		}
		sum = 0;
		for (int i = 0; i < N; ++i)
			sum += square[i][i];
		if (sum != S)
			return false;
		
		sum = 0;
		for (int i = 0; i < N; ++i)
			sum += square[i][N - 1 - i];
		if (sum != S)
			return false;
		
		return true;
	}
	
	static void solve() {
		if (isSolved(square)) {
			for (int j = 0; j < N; ++j)
				System.out.println(Arrays.toString(square[j]));
			solved = true;
		}
		if (solved)
			return;
		
		for (int k = 1; k <= N * N; ++k)
			if (!used[k]) {
				used[k] = true;
				for (int i = 0; i < N; ++i)
					for (int j = 0; j < N; ++j) {
						if (square[i][j] == -1) {
							square[i][j] = k;
							solve();
							square[i][j] = -1;
						}
					}
				used[k] = false;
			}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		S = 0;
		String line;
		N = -1;
		int i = 0;
		while ((line = in.readLine()) != null) {
			String[] parts = line.split("[ ]+");
			if (N == -1) {
				N = parts.length;
				S = N * (N * N + 1) / 2;
				square = new int[N][N];
				used = new boolean[N * N + 1];
				for (int j = 0; j < N; ++j)
					Arrays.fill(square[j], -1);
			}
			for (int j = 0; j < N; ++j)
				if (!parts[j].equals("X")) {
					square[i][j] = Integer.parseInt(parts[j]);
					used[square[i][j]] = true;
				}
			++i;
		}
		solved = false;
		solve();
		
		in.close();
		System.exit(0);
	}
}
