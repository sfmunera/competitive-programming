package livearchive;

import java.util.*;

public class BridgingSignals {
	
	static int lis (int[] list) {
		int N = list.length;
		List<Integer> M = new ArrayList<Integer>();
		int [] parent = new int[N];
		Arrays.fill(parent, -1);
		M.add(0);
		for (int i = 1; i < N; ++i) {
			int x = list[i];
			if (x > list[M.get(M.size() - 1)]) {
				parent[i] = M.get(M.size() - 1);
				M.add(i);
				continue;
			}
			int lo = 0;
			int hi = M.size() - 1;
			while (lo < hi) {
				int mid = (lo + hi) / 2;
				if (list[M.get(mid)] <= x)
					lo = mid + 1;
				else
					hi = mid;
			}
			int j = lo;
			if (x < list[M.get(j)]) {
				if (j > 0)
					parent[i] = M.get(j - 1);
				M.set(j, i);
			}
		}
		List<Integer> lis = new ArrayList<Integer>();
		int cur = M.get(M.size() - 1);
		while (cur != -1) {
			lis.add(0, list[cur]);
			cur = parent[cur];
		}
		return lis.size();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int N = in.nextInt();
			int[] arr = new int[N];
			
			for (int i = 0; i < N; ++i) {
				arr[i] = in.nextInt();
			}
			
			System.out.println(lis(arr));
		}
		
		in.close();
		System.exit(0);
	}
}
