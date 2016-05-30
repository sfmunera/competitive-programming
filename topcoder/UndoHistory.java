
import java.util.*;

public class UndoHistory {
    public int minPresses(String[] lines) {
        String buffer = "";
        HashSet<String> history = new HashSet<String>();
        int ans = lines.length;
        for (String line : lines) {
        	int tmp = Integer.MAX_VALUE;
        	if (line.startsWith(buffer))
    			tmp = Math.min(tmp, line.length() - buffer.length());
        	for (int i = 0; i <= line.length(); ++i)
				if (history.contains(line.substring(0, i)))
					tmp = Math.min(tmp, 2 + line.length() - i);
        	ans += tmp;
        	for (int i = 0; i <= line.length(); ++i)
        		history.add(line.substring(0, i));
        	buffer = line;
        }
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(UndoHistory.class, "test.*");
    }

	public void test0() {
		RETester.eq(minPresses(new String[] {"tomorrow", "topcoder"}), 18);
	}

	public void test1() {
		RETester.eq(minPresses(new String[] {"a","b"}), 6);
	}

	public void test2() {
		RETester.eq(minPresses(new String[] {"a", "ab", "abac", "abacus" }), 10);
	}

	public void test3() {
		RETester.eq(minPresses(new String[] {"pyramid", "sphinx", "sphere", "python", "serpent"}), 39);
	}

	public void test4() {
		RETester.eq(minPresses(new String[] {
			"ba","a","a","b","ba"}
			),
			13);
	}

// END CUT HERE
}
