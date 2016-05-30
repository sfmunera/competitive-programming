
public class TennisSet {
    public String firstSet(String[] p) {
        String set = "";
        for (int i = 0; i < p.length; ++i)
        	set += p[i];
        
        int turn = 0; // A: 0, B: 1
        int[] games = new int[2];
        int[] points = new int[2];
        for (int i = 0; i < set.length(); ++i) {
        	if (set.charAt(i) == 'S')
        		++points[turn];
        	else
        		++points[1 - turn];
        	
        	if (points[turn] >= 4 && points[turn] - points[1 - turn] >= 2) {
        		++games[turn];
        		points = new int[2];
        		turn = 1 - turn;
        	} else if (points[1 - turn] >= 4 && points[1 - turn] - points[turn] >= 2) {
        		++games[1 - turn];
        		points = new int[2];
        		turn = 1 - turn;
        	}
        	
        	if ((games[0] >= 6 && games[0] - games[1] >= 2) || (games[1] >= 6 && games[1] - games[0] >= 2))
        		break;
        }
        
        return games[0] + "-" + games[1];
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(TennisSet.class, "test.*");
    }

	public void test0() {
		RETester.eq(firstSet(new String[] {"SSSSSSSSSSSSSSS"}), "2-1");
	}

	public void test1() {
		RETester.eq(firstSet(new String[] {"SS","SRSS","RRRRR"}), "2-0");
	}

	public void test2() {
		RETester.eq(firstSet(new String[] {"SSSSRRRRSSSSRR","RRSSSSRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR","R"}), "6-0");
	}

// END CUT HERE
}
