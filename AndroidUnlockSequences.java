public class AndroidUnlockSequences {
	
	static final int MIN_DIGITS = 4;
	static final int MAX_DIGITS = 9;
	
	static int solve() {
		Integer[][] middle = new Integer[MAX_DIGITS][MAX_DIGITS];
		middle[0][2] = middle[2][0] = 1;
		middle[0][6] = middle[6][0] = 3;
		middle[0][8] = middle[8][0] = 4;
		middle[1][7] = middle[7][1] = 4;
		middle[2][6] = middle[6][2] = 4;
		middle[2][8] = middle[8][2] = 5;
		middle[3][5] = middle[5][3] = 4;
		middle[6][8] = middle[8][6] = 7;
		
		boolean[] marked = new boolean[MAX_DIGITS];
		int[] result = new int[MAX_DIGITS];
		
		return countSequences(middle, marked, result, 0);
	}
	
	static int countSequences(Integer[][] middle, boolean[] marked, int[] result, int index) {
		int ans = 0;
		if (index >= MIN_DIGITS) {
			++ans;
			if (index == MAX_DIGITS) {
				return ans;
			}
		}
		
		for (int i = 0; i < MAX_DIGITS; ++i) {
			if (!marked[i]) {
				if (index == 0 || (index > 0 && (middle[result[index - 1]][i] == null || marked[middle[result[index - 1]][i]]))) {
					marked[i] = true;
					result[index] = i;
					ans += countSequences(middle, marked, result, index + 1);
					marked[i] = false;
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
}
