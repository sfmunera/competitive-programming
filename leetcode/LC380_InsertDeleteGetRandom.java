package leetcode;

import java.util.*;

public class LC380_InsertDeleteGetRandom {

    public class RandomizedSet {
        private Map<Integer, Integer> positions;
        private List<Integer> elements;
    
        /** Initialize your data structure here. */
        public RandomizedSet() {
            positions = new HashMap<Integer, Integer>();
            elements = new ArrayList<Integer>();
        }
        
        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int element) {
            if (!positions.containsKey(element)) {
                elements.add(element);
                int pos = elements.size() - 1;
                positions.put(element, pos);
                return true;
            } else {
                return false;
            }
        }
        
        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int element) {
            if (positions.containsKey(element)) {
                int pos = positions.get(element);
                elements.set(pos, elements.get(elements.size() - 1));
                positions.put(elements.get(pos), pos);
                elements.remove(elements.size() - 1);
                positions.remove(element);
                return true;
            } else {
                return false;
            }
        }
        
        /** Get a random element from the set. */
        public int getRandom() {
            Random r = new Random();
            int random = r.nextInt(elements.size()); // [0, size - 1]
            return elements.get(random);
        }
    }
    
    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * RandomizedSet obj = new RandomizedSet();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
}