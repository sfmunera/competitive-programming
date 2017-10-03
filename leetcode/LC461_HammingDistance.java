package leetcode;

public class LC461_HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
