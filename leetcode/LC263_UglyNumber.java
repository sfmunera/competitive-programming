package leetcode;

public class LC263_UglyNumber {
	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
		num = removeFactor(num, 2);
		num = removeFactor(num, 3);
		num = removeFactor(num, 5);
		return num == 1;
	}


	private int removeFactor(int num, int factor) {
		while (num % factor == 0 && num > 1) {
			num /= factor;
		}
		return num;
	}
}
