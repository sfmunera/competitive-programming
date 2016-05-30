package datastructures;

public class FenwickTreeMain {
	static class FenwickTree {
		int[] tree;
		
		public FenwickTree(int N) {
			tree = new int[N + 1];
		}
		public void add(int i, int v) {
			for (; i < tree.length; i += i & -i)
				tree[i] += v;
		}
		public int sum(int i) {
			int sum = 0;
			for (; i > 0; i -= i & -i)
				sum += tree[i];
			return sum;
		}
		public int sum(int i, int j) {
			return sum(j) - sum(i - 1);
		}
	}

	public static void main(String[] args) {
		int N = 8;
		FenwickTree ft = new FenwickTree(N);
		// 1-indexed
		ft.add(2, 1);
		ft.add(4, 1);
		ft.add(5, 2);
		ft.add(6, 3);
		ft.add(7, 2);
		ft.add(8, 1);
		
		System.out.println(ft.sum(1, 1)); // 0
		System.out.println(ft.sum(1, 2)); // 1
		System.out.println(ft.sum(1, 6)); // 7
		System.out.println(ft.sum(1, 8)); // 10
		System.out.println(ft.sum(3, 6)); // 6
	}
}
