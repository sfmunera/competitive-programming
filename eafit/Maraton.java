package eafit;
import java.util.*;
import java.io.*;

public class Maraton {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		char[][] board = new char[N][N];
		
		for (int i = 0; i < N; ++i)
			board[i] = in.readLine().toCharArray();
		
		char winner = '#';
		for (int i = 0; i < N && winner == '#'; ++i)
			for (int j = 0; j < N && winner == '#'; ++j) {
				if (!Character.isUpperCase(board[i][j]))
					continue;
				if (i + 2 < N && board[i + 1][j] == board[i][j] && board[i + 2][j] == board[i][j])
					winner = board[i][j];
				if (j + 2 < N && board[i][j + 1] == board[i][j] && board[i][j + 2] == board[i][j])
					winner = board[i][j];
				if (i + 2 < N && j + 2 < N && board[i + 1][j + 1] == board[i][j] && board[i + 2][j + 2] == board[i][j])
					winner = board[i][j];
				if (i + 2 < N && j - 2 >= 0 && board[i + 1][j - 1] == board[i][j] && board[i + 2][j - 2] == board[i][j])
					winner = board[i][j];
			}
		System.out.println(winner == '#' ? "ongoing" : winner);
		
		in.close();
		System.exit(0);
	}
}
