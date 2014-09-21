package uva;

import java.io.*;
import java.util.*;

public class UVa11131_CloseRelatives {
	
	static Map<String, ArrayList<String>> tree;
	
	static LinkedList<String> dfs(String node, boolean reverse) {
		
		LinkedList<String> list = new LinkedList<String>();
		
		if (reverse)
			for (int i = tree.get(node).size() - 1; i >= 0; --i)
				list.addAll(dfs(tree.get(node).get(i), reverse));
		else
			for (int i = 0; i < tree.get(node).size(); ++i)
				list.addAll(dfs(tree.get(node).get(i), reverse));
		
		list.add(node);
		
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		StringTokenizer stk;
		tree = new HashMap<String, ArrayList<String>>();
		String root = "";
		
		while ((line = in.readLine()) != null) {
			stk = new StringTokenizer(line, ",");
			String node = stk.nextToken();
			if (root.isEmpty())
				root = node;
			
			ArrayList<String> children = new ArrayList<String>();
			
			while (stk.hasMoreTokens()) {
				String child = stk.nextToken();
				children.add(child);
				
				if (!tree.containsKey(child))
					tree.put(child, new ArrayList<String>());
			}
			tree.put(node, children);
		}
		
		LinkedList<String> list1 = dfs(root, false);
		LinkedList<String> list2 = dfs(root, true);
		
		if (list1.equals(list2)) {
			System.out.println("1");
			
			System.out.println();
			for (String s : list1)
				System.out.println(s);
		} else {
			System.out.println("2");
			
			System.out.println();
			for (String s : list1)
				System.out.println(s);
			
			System.out.println();
			for (String s : list2)
				System.out.println(s);
		}

		in.close();
		System.exit(0);
	}
}
