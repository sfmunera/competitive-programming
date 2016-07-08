package leetcode;

public class LC136_SingleNumber {
    public int singleNumber(int[] A) {
        int oddNumber = 0;
        for (int x : A)
            oddNumber ^= x;
        
        return oddNumber;
    }
}
