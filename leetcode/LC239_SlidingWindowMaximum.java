package leetcode;

import java.util.*;

public class LC239_SlidingWindowMaximum {
    class Element implements Comparable<Element> {
        int value, index;
        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Element that) {
            if (this.value != that.value) {
                return this.value - that.value;
            }
            return this.index - that.index;
        }
        @Override
        public boolean equals(Object o) {
            Element that = (Element) o;
            return this.value == that.value && this.index == that.index;
        }
        @Override
        public int hashCode() {
            int hash = 1;
            hash = 31 * hash + value;
            hash = 31 * hash + index;
            return hash;
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] max = new int[nums.length - k + 1];
        TreeSet<Element> window = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            window.add(new Element(nums[i], i));
        }
        max[0] = window.last().value;
        for (int i = k; i < nums.length; i++) {
            window.remove(new Element(nums[i - k], i - k));
            window.add(new Element(nums[i], i));
            max[i - k + 1] = window.last().value;
        }
        return max;
    }
}
