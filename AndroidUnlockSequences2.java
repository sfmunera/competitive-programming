import java.util.*;

public class AndroidUnlockSequences2 {
	
	static final int MAX = 9;
	
	static Integer[][] middle;
	
	static Integer getMiddle(int x, int y) {
		assert x >= 0 && x < MAX;
		assert y >= 0 && y < MAX;
		
		return middle[x][y];
	}
	
	static void initMiddle() {
		middle = new Integer[MAX][MAX];
		middle[0][2] = middle[2][0] = 1;
		middle[0][6] = middle[6][0] = 3;
		middle[0][8] = middle[8][0] = 4;
		middle[1][7] = middle[7][1] = 4;
		middle[2][6] = middle[6][2] = 4;
		middle[2][8] = middle[8][2] = 5;
		middle[3][5] = middle[5][3] = 4;
		middle[6][8] = middle[8][6] = 7;		
	}
	
	static List<Integer[]> getPermutations(int length) {
		List<Integer[]> permutations = new ArrayList<Integer[]>();
		getPermutations(length, 0, new Integer[length], new boolean[MAX], permutations);
		
		return permutations;
	}
	
	static void getPermutations(int length, int curPosition, Integer[] cur, boolean[] used, List<Integer[]> permutations) {
		if (curPosition == length) {
			permutations.add(cur.clone());
			return;
		}
		
		for (int next = 0; next < MAX; ++next) {
			if (!used[next]) {
				cur[curPosition] = next;
				used[next] = true;
				getPermutations(length, curPosition + 1, cur, used, permutations);
				used[next] = false;
			}
		}
	}
	
	static boolean isValid(Integer[] pattern) {
		Set<Integer> seen = new HashSet<Integer>();
		for (int i = 1; i < pattern.length; ++i) {
			seen.add(pattern[i - 1]);
			Integer middle = getMiddle(pattern[i - 1], pattern[i]);
			if (middle != null && !seen.contains(middle)) {
				return false;
			}
		}
		return true;
	}
	
	static int countValidPatterns(int length) {
		List<Integer[]> permutations = getPermutations(length);
		
		int count = 0;
		for (Integer[] pattern : permutations) {
			if (isValid(pattern)) {
				count++;
			}
		}
		
		return count;
	}
	
	static int countValidPatterns() {
		initMiddle();
		
		int count = 0;
		for (int length = 4; length <= 9; ++length) {
			count += countValidPatterns(length);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countValidPatterns());
	}
}
