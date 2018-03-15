
public class LC410_SplitArrayLargestSum {
	
	private static boolean check(long M, int[] nums, int m) {
        // check that it is possible to have m groups or less, 
        // where the sum of each group is <= M
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > M) return false;
			if (sum + nums[i] > M) {
				m--;
				sum = 0;
			}
			sum += nums[i];
		}
		if (sum > 0) {
			m--;
		}
		return sum <= M && m >= 0;
	}
	
    public static int splitArray(int[] nums, int m) {
        long sum = 0;
        for (int x : nums) sum += x;

        long low = 0;
        long high = sum;
        long ans = 0;
        while (low <= high) {
        	long mid = low + (high - low) / 2;
        	if (check(mid, nums, m)) {
        		ans = mid;
        		high = mid - 1;
        	} else {
        		low = mid + 1;
        	}
        }
        return (int)ans;
    }
    
    public static void main(String[] args) {
    	int[] nums = {2,3,1,2,4,3};
    	int m = 5;
    	System.out.println(splitArray(nums, m));
    }
}
