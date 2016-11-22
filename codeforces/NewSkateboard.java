import java.io.*;

public class NewSkateboard {
	
	static boolean isDivisibleBy4(char c) {
		return c == '0' || c == '4' || c == '8';
	}
	
	static boolean isDivisibleBy4(char c1, char c2) {
		String num = "" + c1 + c2;
		return Integer.valueOf(num) % 4 == 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		long ans = 0;
		for (int i = s.length() - 1; i >= 0; --i) {
			if (isDivisibleBy4(s.charAt(i)))
				ans++;
		}
		
		for (int i = s.length() - 1; i > 0; --i) {
			char c1 = s.charAt(i - 1);
			char c2 = s.charAt(i);
			if (isDivisibleBy4(c1, c2)) {
				ans += i;
			}
		}
		
		System.out.println(ans);
		
		bf.close();
		System.exit(0);
	}
}
