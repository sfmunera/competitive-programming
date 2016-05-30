package codeforces;

import java.util.*;

public class WellKnownNumbers {
	static final int MAX = (int) 1e9;
	
	static Set<Integer> kbonacci(int k) {
		Set<Integer> numbers = new TreeSet<Integer>();
		
		numbers.add(0);
		numbers.add(1);
		
		List<Integer> sequence = new ArrayList<Integer>();
		sequence.add(1);
		while (true) {
			int sum = 0;
			for (int i = sequence.size() - 1, cnt = 0; i >= 0 && cnt < k; --i, ++cnt) {
				sum += sequence.get(i);
			}
			sequence.add(sum);
			numbers.add(sum);
			
			if (sum > MAX) break;
		}
		
		return numbers;
	}
	
	static List<Integer> getNumbers(Set<Integer> kbonacci, int s) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		int x = s;
		while (x > 0) {
			int prev = 0;
			for (int n : kbonacci) {
				if (n > x) break;
				prev = n;
			}
			
			assert prev > 0;
			
			numbers.add(prev);
			x -= prev;
		}
		if (numbers.size() == 1) {
			numbers.add(0, 0);
		}
		
		return numbers;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int s = in.nextInt();
		int k = in.nextInt();
		
		List<Integer> numbers = getNumbers(kbonacci(k), s);
		assert numbers.size() >= 2;
		
		System.out.println(numbers.size());
		for (int i = 0; i < numbers.size(); ++i) {
			if (i > 0) System.out.print(" ");
			System.out.print(numbers.get(i));
		}
				
		in.close();
		System.exit(0);
	}
}
