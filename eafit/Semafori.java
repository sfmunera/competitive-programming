package eafit;
import java.util.*;
import java.io.*;

public class Semafori {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] parts = in.readLine().split("[ ]+");
		int N = Integer.parseInt(parts[0]);
		int L = Integer.parseInt(parts[1]);
		int[] D = new int[N];
		int[] R = new int[N];
		int[] G = new int[N];
		int[] timer = new int[N];
		int[] state = new int[N]; // Red: -1, Green: 1
		
		Arrays.fill(state, -1);
		
		for (int i = 0; i < N; ++i) {
			parts = in.readLine().split("[ ]+");
			D[i] = Integer.parseInt(parts[0]);
			R[i] = Integer.parseInt(parts[1]);
			G[i] = Integer.parseInt(parts[2]);
		}
		
		int t = 0;
		int pos = 0;
		while (true) {
			
			for (int i = 0; i < N; ++i) {
				if (state[i] == -1) {
					if (timer[i] == R[i]) {
						timer[i] = 0;
						state[i] = 1;
					}
				} else {
					if (timer[i] == G[i]) {
						timer[i] = 0;
						state[i] = -1;
					}
				}
				++timer[i];
			}
			
			boolean wait = false;
			for (int i = 0; i < N; ++i) {
				if (pos == D[i]) {
					if (state[i] == -1)
						wait = true;
				}
			}
			if (!wait)
				++pos;
			++t;
			if (pos == L)
				break;
		}
		System.out.println(t);
		
		in.close();
		System.exit(0);
	}
}
