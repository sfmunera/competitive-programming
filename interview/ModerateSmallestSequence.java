package interview;

public class ModerateSmallestSequence {
	
	static int minSequence(int[] val) {
		int left = 0;
		int right = val.length - 1;
		
		for (int i = 1; i < val.length && val[i] >= val[i - 1]; ++i)
			++left;
		
		if (left >= right)
			return 0;
		
		for (int i = val.length - 1; i > 0 && val[i] >= val[i - 1]; --i)
			--right;
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = left + 1; i < right; ++i) {
			min = Math.min(min, val[i]);
			max = Math.max(max, val[i]);
		}
		
		while (left > 0 && val[left - 1] > min)
			--left;
		while (right < val.length - 1 && val[right + 1] < max)
			++right;
		
		System.out.println(left + " " + right);
		
		return right - left + 1;
	}
	
	public static void main(String[] args) {
		int[] val = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		//int[] val = {1, 2, 4, 6, 7, 7, 11, 10, 11, 12, 16, 18, 19};
		
		System.out.println(minSequence(val));
	}
}
