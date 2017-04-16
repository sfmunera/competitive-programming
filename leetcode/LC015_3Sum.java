package leetcode;

import java.util.*;

public class LC015_3Sum {
    
    class Triplet {
        int a, b, c;
        Triplet(int a, int b, int c) {
            int[] arr = new int[]{a, b, c};
            Arrays.sort(arr);
            this.a = arr[0];
            this.b = arr[1];
            this.c = arr[2];
        }
        @Override public boolean equals(Object o) {
            Triplet that = (Triplet) o;
            return this.a == that.a && this.b == that.b && this.c == that.c;
        }
        @Override public int hashCode() {
            int hash = 1;
            hash = 31 * hash + a;
            hash = 31 * hash + b;
            hash = 31 * hash + c;
            return hash;
        }
        
        List<Integer> getList() {
            List<Integer> triplet = new ArrayList<>();
            triplet.add(a);
            triplet.add(b);
            triplet.add(c);
            return triplet;
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        List<Integer> unique = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!count.containsKey(nums[i])) count.put(nums[i], 0);
            count.put(nums[i], count.get(nums[i]) + 1);
        }
        for (int x : count.keySet()) {
            unique.add(x);
        }

        List<List<Integer>> ans = new ArrayList<>();
        Set<Triplet> triplets = new HashSet<>();
        if (count.containsKey(0) && count.get(0) >= 3) {
            triplets.add(new Triplet(0, 0, 0));
        }
        for (int i = 0; i < unique.size(); i++) {
            for (int j = i + 1; j < unique.size(); j++) {
                int a = unique.get(i);
                int b = unique.get(j);
                int c = -(a + b);
                if (!count.containsKey(c)) continue;
                if (c == a && count.get(a) == 1) continue;
                if (c == b && count.get(b) == 1) continue;
                triplets.add(new Triplet(a, b, c));
            }
        }
        
        for (Triplet triplet : triplets) {
            ans.add(triplet.getList());
        }
        return ans;
    }
}
