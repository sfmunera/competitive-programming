import java.util.*;
import java.io.*;

public class FloatingFormation {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			
			List<List<Integer>> graph = new ArrayList<List<Integer>>(n);
			int[] degree = new int[n];
			for (int i = 0; i < n; ++i) {
				graph.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < m; ++i) {
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				
				graph.get(a).add(b);
				graph.get(b).add(a);
				++degree[a];
				++degree[b];
			}
			
			boolean[] seen = new boolean[n];
			List<Integer> pathLengths = new ArrayList<Integer>();
			for (int i = 0; i < n; ++i) {
				if (!seen[i] && degree[i] == 1) {
					int len = 0;
					int cur = i;
					int[] degreeTmp = degree.clone();
					while (!seen[cur] && degreeTmp[cur] == 1) {
						seen[cur] = true;
						++len;
						int neighbor = graph.get(cur).get(0);
						--degreeTmp[cur];
						--degreeTmp[neighbor];
						cur = neighbor;
					}
					if (len > 0) {
						pathLengths.add(len);
					}
				}
			}
			
			Collections.sort(pathLengths);
			int nPaths = pathLengths.size();
			int ans = 0;
			for (int i = 0; i < nPaths - k; ++i) {
				ans += pathLengths.get(i);
			}
			
			System.out.println(ans);
		}
		
		in.close();
	}
}
