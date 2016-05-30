
import java.util.*;

public class KingSort {
    public String[] getSortedList(String[] kings) {
    	
    	String[] unit = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    	String[] dec = {"X", "XX", "XXX", "XL", "L"};
    	
    	String[] roman = new String[100];
    	int k = 0;
    	
    	for (int i = 1; i < unit.length; ++i)
    		roman[k++] = unit[i];
    	for (int i = 0; i < dec.length; ++i)
    		for (int j = 0; j < unit.length; ++j)
    			roman[k++] = dec[i] + unit[j];    	
    	
    	Map<String, String> kings2 = new TreeMap<String, String>();
    	
    	for (int i = 0; i < kings.length; ++i) {
    		String[] parts = kings[i].split("[ ]");
    		int ind = 0;
    		for (int j = 0; j < roman.length; ++j)
    			if (parts[1].equals(roman[j])) {
    				ind = j + 1;
    				break;
    			}
    		String pos = (ind < 10 ? "0" : "") + ind;
    		kings2.put(parts[0] + pos, kings[i]);
    	}
    	
    	String[] res = new String[kings.length];
    	
    	k = 0;
    	for (String s : kings2.values())
    		res[k++] = s;
    	
        
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(KingSort.class, "test.*");
    }

	public void test0() {
		RETester.eq(getSortedList(new String[] {"Louis IX", "Louis VIII"}), new String[] {"Louis VIII", "Louis IX" });
	}

	public void test1() {
		RETester.eq(getSortedList(new String[] {"Louis IX", "Philippe II"}), new String[] {"Louis IX", "Philippe II" });
	}

	public void test2() {
		RETester.eq(getSortedList(new String[] {"Richard III", "Richard I", "Richard II"}), new String[] {"Richard I", "Richard II", "Richard III" });
	}

	public void test3() {
		RETester.eq(getSortedList(new String[] {"John X", "John I", "John L", "John V"}), new String[] {"John I", "John V", "John X", "John L" });
	}

	public void test4() {
		RETester.eq(getSortedList(new String[] {"Philippe VI", "Jean II", "Charles V", "Charles VI", "Charles VII", "Louis XI"}), new String[] {"Charles V", "Charles VI", "Charles VII", "Jean II", "Louis XI", "Philippe VI" });
	}

	public void test5() {
		RETester.eq(getSortedList(new String[] {"Philippe II", "Philip II"}), new String[] {"Philip II", "Philippe II" });
	}

// END CUT HERE
}
