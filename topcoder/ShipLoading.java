
import java.util.*;

public class ShipLoading {
    public int minimumTime(int[] cranes, String[] boxes) {
        String cat = "";
        
        for (String s: boxes)
        	cat += s;
        String[] parts = cat.split("[ ]");
        int[] nboxes = new int[parts.length];
        
        for (int i = 0; i < parts.length; ++i)
        	nboxes[i] = Integer.parseInt(parts[i]);
        
        Arrays.sort(nboxes);
        Arrays.sort(cranes);
        
        boolean ok = false;
        for (int j = 0; j < cranes.length; ++j)
        	if (cranes[j] >= nboxes[nboxes.length - 1])
        		ok = true;
        
        if (!ok)
        	return -1;
        int t = 0;
        boolean[] visited = new boolean[nboxes.length];
        while (true) {
        	for (int j = cranes.length - 1; j >= 0; --j) {
        		for (int i = nboxes.length - 1; i >= 0; --i)       		
        			if (!visited[i] && cranes[j] >= nboxes[i]) {
        				visited[i] = true;
        				break;
        			}
        	}
        	++t;
        	ok = true;
        	for (int i = 0; i < nboxes.length; ++i)
        		ok &= visited[i];
        	if (ok)
        		break;
        }
        return t;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ShipLoading.class, "test.*");
    }

	public void test0() {
		RETester.eq(minimumTime(new int[] {6,8,9}, new String[] {"2 5 2 4 7"}), 2);
	}

	public void test1() {
		RETester.eq(minimumTime(new int[] {19,20}, new String[] {"14 12 16 19 16 1 5"}), 4);
	}

	public void test2() {
		RETester.eq(minimumTime(new int[] {23,32,25,28}, new String[] {"5 27 10 16 24 20 2 32 18 7"}), 3);
	}

	public void test3() {
		RETester.eq(minimumTime(new int[] {11,17,5,2,20,7,5,5,20,7}, new String[] {"18 18 15 15 17"}), 2);
	}

	public void test4() {
		RETester.eq(minimumTime(new int[] {56,114,979,120,120,87,480}, new String[] {"221 882 504 358 642 674 212 679 203 279 632 799 79","6 502 275 823 372 594 482 343"}), 12);
	}

// END CUT HERE
}
