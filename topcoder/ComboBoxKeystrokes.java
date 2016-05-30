
import java.util.*;

public class ComboBoxKeystrokes {
    public int minimumKeystrokes(String[] elements) {
        int N = elements.length;
        int INF = 1000000000;
        
        for (int i = 0; i < N; ++i)
        	elements[i] = elements[i].toLowerCase();
        
        int[][] adj = new int[N][N];
        for (int i = 0; i < N; ++i)
        	Arrays.fill(adj[i], INF);

		for (int i = 0; i < N; i++) {
			Arrays.fill(adj[i], INF);
			adj[i][i] = 0;
			for (char c = 'a'; c <= 'z'; c++)
				for (int k = 1; k < N; k++)
					if (c == elements[(i + k) % N].charAt(0)) {
						adj[i][(i + k) % N] = 1;
						break;
					}
		}
		for (int k = 0; k < N; ++k)
			for (int i = 0; i < N; ++i)
				for (int j = 0; j < N; ++j)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
		int ans = 0;
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				ans = Math.max(ans, adj[i][j]);
		return ans;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		RETester.test(ComboBoxKeystrokes.class, "test.*");
	}

	public void test0() {
		RETester.eq(minimumKeystrokes(new String[] {"alpha","beta","gamma","delta"}), 1);
	}

	public void test1() {
		RETester.eq(minimumKeystrokes(new String[] {"kyky","kalinov","kalmakka","Kavan","Kawigi","kaylin","Klinck","krijgertje","kupo"}), 8);
	}

	public void test2() {
		RETester.eq(minimumKeystrokes(new String[] {"a","b","c","b","d","b","e","b","f"}), 2);
	}

	public void test3() {
		RETester.eq(minimumKeystrokes(new String[] {
			"apple","Boy","CaRD","Dog","egG","FruiT",
			"Grape","hand","Ant","eagle","ice cream",
			"air","East","Exit","Door","camerA","bad",
			"fast","Zealot","internAtional","Bead",
			"Bread","Exit","fast", "actiVe","Cats",
			"beast","Alligator","drag","castle",
			"clean","iLlEgAl","crab","Free Willy",
			"first","dean","Fourth of July","King",
			"fellow","FrEaK","Elephant","bird","Bible",
			"creep","create","Deal","eEl","entrance",
			"cream","Fleece"}),
			4);
	}

// END CUT HERE
}
