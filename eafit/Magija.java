package eafit;
import java.util.*;
import java.io.*;

public class Magija {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] parts = in.readLine().split("[ ]+");
		int R = Integer.parseInt(parts[0]);
		int C = Integer.parseInt(parts[1]);
		
		char[][] upperLeft = new char[R][C];
		char[][] complete = new char[2 * R][2 * C];
		for (int i = 0; i < R; ++i)
			upperLeft[i] = in.readLine().toCharArray();
		parts = in.readLine().split("[ ]+");
		int A = Integer.parseInt(parts[0]) - 1;
		int B = Integer.parseInt(parts[1]) - 1;
		
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				complete[i][j] = upperLeft[i][j];
		
		for (int i = 0; i < R; ++i)
			for (int j = C; j < 2 * C; ++j)
				complete[i][j] = complete[i][2 * C - j - 1];
			
		for (int i = R; i < 2 * R; ++i)
			for (int j = 0; j < 2 * C; ++j)
				complete[i][j] = complete[2 * R - i - 1][j];
		
		complete[A][B] = complete[A][B] == '#' ? '.' : '#';
		
		for (int i = 0; i < 2 * R; ++i)
			System.out.println(complete[i]);
		
		in.close();
		System.exit(0);
	}
}
