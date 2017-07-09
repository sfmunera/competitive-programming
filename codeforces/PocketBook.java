import java.util.*;

public class PocketBook {
	
	static final int MODULO = 1000000007;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		char[][] book = new char[n][m];
		for (int i = 0; i < n; i++) {
			book[i] = in.next().toCharArray();
		}
		
		long ans = 1;
		for (int col = 0; col < m; col++) {
			Set<Character> unique = new HashSet<>();
			for (int row = 0; row < n; row++) {
				unique.add(book[row][col]);
			}
			ans *= unique.size();
			ans %= MODULO;
		}
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
