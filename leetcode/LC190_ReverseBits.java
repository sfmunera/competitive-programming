package leetcode;

public class LC190_ReverseBits {
	static final int MAX_BITS = 32;
	public int reverseBits(int x) {
		long n = (long)x;
		int left = 0;
		int right = MAX_BITS - 1;
		while (left < right) {
			n = swapBits(n, left, right);
			left++;
			right--;
		}
		return (int)n;
	}


	private long swapBits(long n, int left, int right) {
		long leftBit = n & (1L << left);
		long rightBit = n & (1L << right);
		n &= ~leftBit; // clear bit at left position
		n &= ~rightBit; // clear bit at right position
		if (leftBit > 0) {
			n |= 1L << right;
		}
		if (rightBit > 0) {
			n |= 1L << left;
		}
		return n;
	}
}
