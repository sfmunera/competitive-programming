
public class ListeningIn {
	
	String ans;
	
	void solve(String typed, String phrase, String removed) {
		if (!ans.equals("UNMATCHED")) return;
		
		if (phrase.length() < typed.length()) return;

		if (typed.equals("")) {
			removed += phrase;
			ans = removed;
			return;
		}
		int k = -1;
		for (int i = 0; i < phrase.length(); ++i) {
			if (typed.charAt(0) == phrase.charAt(i))
				break;
			removed += phrase.charAt(i);
			k = i;
		}
		phrase = phrase.substring(k + 1);
		
		if (!phrase.equals("") && phrase.charAt(0) == typed.charAt(0)) {
			phrase = phrase.substring(1);
			typed = typed.substring(1);
		}
		solve(typed, phrase, removed);
	}
	
    public String probableMatch(String typed, String phrase) {
    	ans = "UNMATCHED";
        solve(typed, phrase, "");
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ListeningIn.class, "test.*");
    }

	public void test0() {
		RETester.eq(probableMatch("cptr", "capture"), "aue");
	}

	public void test1() {
		RETester.eq(probableMatch("port to me", "teleport to me"), "tele");
	}

	public void test2() {
		RETester.eq(probableMatch("back  to base", "back to base"), "UNMATCHED");
	}

// END CUT HERE
}
