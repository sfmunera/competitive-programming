package leetcode;

import java.util.*;

public class LC220_ContainsDuplicateIII {
	
	class Element implements Comparable<Element> {
		int idx, val;
		Element(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		
		@Override
		public int hashCode() {
			long h = idx;
			h = 1000007L * h + val;
			h %= 1000000007;
			
			return (int)h;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null) return false;
			if (this == o) return true;
			if (!(o instanceof Element)) return false;
			
			Element that = (Element) o;
			return this.idx == that.idx && this.val == that.val;
		}

		@Override
		public int compareTo(Element that) {
			return this.val - that.val;
		}
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		Element[] elements = new Element[nums.length];
		
		for (int i = 0; i < nums.length; ++i) {
			elements[i] = new Element(i, nums[i]);
		}
		
		TreeSet<Element> set = new TreeSet<Element>();
		for (int i = 1; i <= Math.min(k, nums.length - 1); ++i) {
			set.add(elements[i]);
		}
		
        for (int i = 0; i < nums.length - 1; ++i) {
        	Element ceil = set.ceiling(elements[i]);
        	Element floor = set.floor(elements[i]);
        	
        	if (ceil != null && Math.abs((long)nums[i] - ceil.val) <= t)
    			return true;
        	if (floor != null && Math.abs((long)nums[i] - floor.val) <= t)
    			return true;
        	
        	set.remove(elements[i + 1]);
        	if (i + k + 1 < nums.length) set.add(elements[i + k + 1]);
        }
        
        return false;
    }
}
