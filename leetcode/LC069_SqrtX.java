package leetcode;

public class LC069_SqrtX {
	public int mySqrt(int x) {
        long low = 0;
        long high = x;
        
        long sqrt = -1;
        while (low <= high) {
        	long mid = (low + high) / 2;
        	if (mid * mid <= x) {
        		sqrt = mid;
        		low = mid + 1;
        	} else {
        		high = mid - 1;
        	}
        }
        
        return (int)sqrt;
    }
}
