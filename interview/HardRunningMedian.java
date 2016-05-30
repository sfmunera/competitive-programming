package interview;

import java.util.*;

public class HardRunningMedian {
	public static void main(String[] args) {
		int[] val = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		PriorityQueue<Integer> least = new PriorityQueue<Integer>();
		PriorityQueue<Integer> most = new PriorityQueue<Integer>();
		
		for (int i = 0; i < val.length; ++i) {
			int median = val[i];
			if (i == 0) {
				most.offer(val[i]);
			} else {
				int l = most.peek();
				if (val[i] < l)
					least.offer(-val[i]);
				else
					most.offer(val[i]);
				
				if (least.size() > most.size() + 1)
					most.offer(-least.poll());
				else if (least.size() + 1 < most.size())
					least.offer(-most.poll());
				
				if (least.size() > most.size())
					median = -least.peek();
				else
					median = most.peek();
			}
			System.out.println(i + ", Median : " + median);
		}
	}
}
