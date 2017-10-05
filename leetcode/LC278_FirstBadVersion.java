
public class LC278_FirstBadVersion {
	
	// Dummy implementation
	private boolean isBadVersion(int version) {
		return true;
	}
	
    public int firstBadVersion(int n) {
        int low = 1; 
        int high = n;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
