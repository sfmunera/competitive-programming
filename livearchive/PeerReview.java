package livearchive;

import java.util.*;

public class PeerReview {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			int K = in.nextInt();
			int N = in.nextInt();
			
			if (K == 0 && N == 0) break;
			
			String[] institutions = new String[N + 1];
			int[] numReviews = new int[N + 1];
			List<List<Integer>> input = new ArrayList<List<Integer>>();
			
			for (int i = 1; i <= N; ++i) {
				institutions[i] = in.next();				
				
				List<Integer> tmp = new ArrayList<Integer>();
				for (int j = 0; j < K; ++j) {
					tmp.add(in.nextInt());
				}
				input.add(tmp);
			}
			
			boolean[] hasProblem = new boolean[N + 1];
			for (int i = 1; i <= N; ++i) {
				Set<Integer> reviews = new HashSet<Integer>();
				for (int j = 0; j < K; ++j) {
					int review = input.get(i - 1).get(j);
					numReviews[review]++;
					if (reviews.contains(review)) {
						hasProblem[review] = true;
					} else {
						reviews.add(review);
					}
					if (i == review || institutions[i].equals(institutions[review])) {
						hasProblem[review] = true;
					}
				}				
			}
			
			for (int i = 1; i <= N; ++i) {
				if (numReviews[i] != K) {
					hasProblem[i] = true;
				}
			}
			
			int problems = 0;
			for (int i = 1; i <= N; ++i) {
				if (hasProblem[i]) {
					++problems;
				}
			}
			
			if (problems == 0) {
				System.out.println("NO PROBLEMS FOUND");
			} else if (problems == 1) {
				System.out.println("1 PROBLEM FOUND");
			} else {
				System.out.println(problems + " PROBLEMS FOUND");
			}
		}
		
		in.close();
		System.exit(0);
	}
}
