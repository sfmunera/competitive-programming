package leetcode;

import java.util.*;

public class LC532_KDiffPairsInAnArray {
    public int findPairs(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        int count = 0;
        while (left < arr.length && right < arr.length) {
            int diff = arr[right] - arr[left];
            if (diff >= k) {
                if (diff == k) {
                    count++;
                }
                left++;
                while (left < arr.length && arr[left] == arr[left - 1]) left++;
            } else {
                right++;
                while (right < arr.length && arr[right] == arr[right - 1]) right++;
            }
            while (left >= right) right++;
        }
        return count;
    }
}
