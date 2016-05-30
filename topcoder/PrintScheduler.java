
public class PrintScheduler {
    public String getOutput(String[] threads, String[] slices) {
        int[] cur = new int[threads.length];
        
        String ans = "";
        for (int i = 0; i < slices.length; ++i) {
        	String[] parts = slices[i].split("[ ]+");
        	int thread = Integer.parseInt(parts[0]);
        	int time = Integer.parseInt(parts[1]);
        	
        	for (int k = 0; k < time; ++k) {
        		ans += threads[thread].charAt(cur[thread]);
        		cur[thread] = (cur[thread] + 1) % threads[thread].length();
        	}
        }
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(PrintScheduler.class, "test.*");
    }

	public void test0() {
		RETester.eq(getOutput(new String[] {"AB","CD"}, new String[] {"0 1","1 1","0 1","1 2"} ), "ACBDC");
	}

	public void test1() {
		RETester.eq(getOutput(new String[] {"ABCDE"}, new String[] {"0 20","0 21"}), "ABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDEA");
	}

	public void test2() {
		RETester.eq(getOutput(new String[] {"A","B"}, new String[] {"1 10","0 1","1 10","0 2"}), "BBBBBBBBBBABBBBBBBBBBAA");
	}

	public void test3() {
		RETester.eq(getOutput(new String[] {"A"}, new String[] {"0 1"}), "A");
	}

// END CUT HERE
}
