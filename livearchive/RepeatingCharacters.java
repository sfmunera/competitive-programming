import java.io.*;

public class RepeatingCharacters {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(in.readLine());
		for (int p = 1; p <= P; ++p) {
			String[] parts = in.readLine().split("[ ]+");
			int R = Integer.parseInt(parts[1]);
			String S = parts[2];
			
			String ans = "";
			for (int i = 0; i < S.length(); ++i)
				for (int j = 0; j < R; ++j)
					ans += S.charAt(i);
			System.out.println(p + " " + ans);
		}
		
		in.close();
		System.exit(0);
	}
}
