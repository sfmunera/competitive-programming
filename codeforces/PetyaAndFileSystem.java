package codeforces;

import java.io.*;
import java.util.*;

public class PetyaAndFileSystem {
	
	static class Node {
		String name;
		ArrayList<Node> children;
		HashMap<String, Integer> childNames;
		boolean isFolder;
		
		public Node() {
			this.name = "$";
			this.children = new ArrayList<Node>();
			this.childNames = new HashMap<String, Integer>();
			isFolder = false;
		}
		public Node(String name) {
			this.name = name;
			this.children = new ArrayList<Node>();
			this.childNames = new HashMap<String, Integer>();
			isFolder = !name.contains(".");
		}
		
		public void addChild(Node n) {
			this.children.add(n);
			this.childNames.put(n.name, this.children.size() - 1);
		}
		public boolean containsChild(String name) {
			return this.childNames.containsKey(name);
		}
		public Node getChild(String name) {
			if (!this.containsChild(name))
				return null;
			return this.children.get(this.childNames.get(name));
		}
	}
	
	static int[] dfs(Node node) {
		if (!node.isFolder) {
			int[] cnt = new int[2];
			cnt[1] = 1;
			return cnt;
		}
		
		int[] ans = new int[2];
		for (Node c : node.children) {
			int[] cnt = dfs(c);
			ans[0] += cnt[0];
			ans[1] += cnt[1];
		}
		++ans[0];
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		Node[] roots = new Node[5];
		for (int i = 0; i < 5; ++i)
			roots[i] = new Node();
		
		while (in.hasNext()) {
			String line = in.next();
			String[] parts = line.split("\\\\");
			
			int disk = parts[0].charAt(0) - 'C';
			Node curnode = roots[disk];
			for (int i = 1; i < parts.length; ++i) {
				if (!curnode.containsChild(parts[i]))
					curnode.addChild(new Node(parts[i]));
				curnode = curnode.getChild(parts[i]);
			}
		}
		
		int numFolders = 0;
		int numFiles = 0;
		
		for (int i = 0; i < 5; ++i) {
			for (Node node : roots[i].children) {
				int[] cnt = dfs(node);
				numFolders = Math.max(numFolders, cnt[0] - 1);
				numFiles = Math.max(numFiles, cnt[1]);
			}
		}
		
		System.out.println(numFolders + " " + numFiles);
		in.close();
	}
}
