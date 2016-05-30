import java.util.*;
import java.io.*;

public class Prueba {	
	public static void main(String[] args) {
		int[] arr = {4, 1, 0, -5, 10};
		
		PriorityQueue<Integer> Q = new PriorityQueue<Integer>(arr.length, 
				new Comparator<Integer>() {
					@Override public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				});
		for (int p : arr) {
			Q.add(p);
		}
		
		while (!Q.isEmpty()) {
			System.out.println(Q.poll());
		}
	}
}