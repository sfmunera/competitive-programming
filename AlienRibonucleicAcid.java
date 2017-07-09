import java.util.*;

public class AlienRibonucleicAcid {
	
	static boolean inside(int length, int position) {
		return position >= 0 && position < length;
	}
	
	static boolean match(String rnaa, int left, int right) {
		assert inside(rnaa.length(), left) && inside(rnaa.length(), right);
		
		char leftChar = rnaa.charAt(left);
		char rightChar = rnaa.charAt(right);
		if (leftChar == 'B' && rightChar == 'S') return true;
		if (leftChar == 'S' && rightChar == 'B') return true;
		if (leftChar == 'C' && rightChar == 'F') return true;
		if (leftChar == 'F' && rightChar == 'C') return true;
		return false;
	}
	
	static int solve(String rnaa, Map<String, Integer> memo) {
		if (rnaa.isEmpty()) {
			return 0;
		}
		if (memo.containsKey(rnaa)) {
			return memo.get(rnaa);
		}
		int ans = 0;
		for (int i = 0; i + 1 < rnaa.length(); i++) {
			int left = i;
			int right = i + 1;
			while (inside(rnaa.length(), left) && inside(rnaa.length(), right) && match(rnaa, left, right)) {
				String next = rnaa.substring(0, left) + rnaa.substring(right + 1, rnaa.length());
				ans = Math.max(ans, (right - left + 1) / 2 + solve(next, memo));
				left--;
				right++;
			}
		}
		memo.put(rnaa, ans);
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String rnaa = in.next();
			System.out.println(solve(rnaa, new HashMap<String, Integer>()));
		}
		in.close();
		System.exit(0);
	}
}
