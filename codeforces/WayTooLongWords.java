import java.util.*;

public class WayTooLongWords {
	
	static String abbreviate(String word) {
		if (word.length() <= 10) {
			return word;
		} else {
			return "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String word = in.next();
			System.out.println(abbreviate(word));
		}
		
		in.close();
		System.exit(0);
	}
}
