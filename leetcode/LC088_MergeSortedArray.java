
public class LC088_MergeSortedArray {
	
	// Time: O(m+n), Space: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < m; i++) {
            nums1[nums1.length - 1 - i] = nums1[m - 1 - i];
        }
        int index1 = nums1.length - m;
        int index2 = 0;
        int indexCombined = 0;
        int left1 = m;
        int left2 = n;
        while (left1 > 0 && left2 > 0) {
            if (nums1[index1] < nums2[index2]) {
                nums1[indexCombined++] = nums1[index1++];
                left1--;
            } else {
                nums1[indexCombined++] = nums2[index2++];
                left2--;
            }
        }
        while (left1-- > 0) nums1[indexCombined++] = nums1[index1++];
        while (left2-- > 0) nums1[indexCombined++] = nums2[index2++];
    }
}
