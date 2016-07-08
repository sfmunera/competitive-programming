package leetcode;

import java.util.*;

public class LC169_MajorityElement {
	public int majorityElement(int[] num) {
        Arrays.sort(num);
        
        for (int i = 0; i + num.length / 2 < num.length; ++i) {
            if (num[i] == num[i + num.length / 2])
                return num[i];
        }
        return 0;
    }
}
