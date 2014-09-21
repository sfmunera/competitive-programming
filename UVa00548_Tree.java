package uva;

import java.io.*;
import java.util.*;

public class UVa00548_Tree {
	
	static ArrayList<Integer> inorder, postorder;
	static Map<Integer, Integer> posInInorder;
	static int ans;
	static int min;

	static void go(int li, int ri, int lp, int rp, int sum) {
		if (lp > rp) return;
		
		int root = postorder.get(rp);
		if (lp == rp) { // leaf
			if (sum + root < min) {
				min = sum + root;
				ans = root;
			}
			return;
		}
		
		int indInorder = posInInorder.get(root);
		int numLeft = indInorder - li;
		
		go(li, indInorder - 1, lp, lp + numLeft - 1, sum + root);
		go(indInorder + 1, ri, lp + numLeft, rp - 1, sum + root);		
	}
	
	public static void main(String[] args) throws IOException {	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		String line;
		while ((line = in.readLine()) != null) {
			inorder = new ArrayList<Integer>();
			postorder = new ArrayList<Integer>();
			posInInorder = new HashMap<Integer, Integer>();
			
			stk = new StringTokenizer(line);
			while (stk.hasMoreElements())
				inorder.add(Integer.parseInt(stk.nextToken()));
			stk = new StringTokenizer(in.readLine());
			while (stk.hasMoreElements())
				postorder.add(Integer.parseInt(stk.nextToken()));
			
			int N = inorder.size();
			for (int i = 0; i < N; ++i)
				posInInorder.put(inorder.get(i), i);

			ans = 0;
			min = Integer.MAX_VALUE;
			go(0, N - 1, 0, N - 1, 0);
			
			System.out.println(ans);
		}
		
		in.close();
		System.exit(0);
	}
}
