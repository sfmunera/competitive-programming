
import java.util.*;

public class EllysCheckers {
	
	int N;
	Map<Integer, Boolean> memo;
	
	boolean canWin(int board) {
		board &= ~(1 << (N - 1));
		
		if (memo.containsKey(board))
			return memo.get(board);
		
		// step
		for (int i = 0; i < N - 1; ++i) {
			if ((board & (1 << i)) != 0 && (board & (1 << (i + 1))) == 0) {
				int next = board;
				next &= ~(1 << i);
				next |= (1 << (i + 1));
				if (!canWin(next)) {
					memo.put(board, true);
					return true;
				}
			}
		}
		// jump
		for (int i = 0; i < N - 3; ++i) {
			if ((board & (1 << i)) != 0 && (board & (1 << (i + 1))) != 0 &&
				(board & (1 << (i + 2))) != 0 && (board & (1 << (i + 3))) == 0) {
				int next = board;
				next &= ~(1 << i);
				next |= (1 << (i + 3));
				if (!canWin(next)) {
					memo.put(board, true);
					return true;
				}
			}
		}
		memo.put(board, false);
		return false;
	}
	
    public String getWinner(String board) {
        int b = 0;
        N = board.length();
        for (int i = 0; i < N; ++i)
        	if (board.charAt(i) == 'o')
        		b |= 1 << i;
        memo = new HashMap<Integer, Boolean>();
        
        return canWin(b) ? "YES" : "NO";
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(EllysCheckers.class, "test.*");
    }

	public void test0() {
		RETester.eq(getWinner(".o..."), "YES");
	}

	public void test1() {
		RETester.eq(getWinner("..o..o"), "YES");
	}

	public void test2() {
		RETester.eq(getWinner(".o...ooo..oo.."), "NO");
	}

	public void test3() {
		RETester.eq(getWinner("......o.ooo.o......"), "YES");
	}

	public void test4() {
		RETester.eq(getWinner(".o..o...o....o.....o"), "NO");
	}

// END CUT HERE
}
