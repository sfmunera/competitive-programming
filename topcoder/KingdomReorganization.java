import java.util.*;

public class KingdomReorganization {
    public int getCost(String[] kingdom, String[] build, String[] destroy) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(KingdomReorganization.class, "test.*");
    }

	public void test0() {
		RETester.eq(getCost(new String[] {"000","000","000"}, new String[] {"ABD","BAC","DCA"}, new String[] {"ABD","BAC","DCA"}), 3);
	}

	public void test1() {
		RETester.eq(getCost(new String[] {"011","101","110"}, new String[] {"ABD","BAC","DCA"}, new String[] {"ABD","BAC","DCA"}), 1);
	}

	public void test2() {
		RETester.eq(getCost(new String[] {"011000","101000","110000","000011","000101","000110"}, new String[] {"ABDFFF","BACFFF","DCAFFF","FFFABD","FFFBAC","FFFDCA"}, new String[] {"ABDFFF","BACFFF","DCAFFF","FFFABD","FFFBAC","FFFDCA"}), 7);
	}

	public void test3() {
		RETester.eq(getCost(new String[] {"0"}, new String[] {"A"}, new String[] {"A"}), 0);
	}

	public void test4() {
		RETester.eq(getCost(new String[] {"0001","0001","0001","1110"}, new String[] {"AfOj","fAcC","OcAP","jCPA"}, new String[] {"AWFH","WAxU","FxAV","HUVA"}), 0);
	}

	public void test5() {
		RETester.eq(getCost(new String[] {"0000000000","0000000011","0001010000","0010010000","0000001000","0011000000","0000100000","0000000011","0100000101","0100000110"}, new String[] {"AhPEqkSFMM","hAfKPtsDad","PfAyGQkaqN","EKyAeLpRpm","qPGeASfNwo","ktQLSAnCAK","SskpfnAdJS","FDaRNCdAZz","MaqpwAJZAn","MdNmoKSznA"}, new String[] {"AgTqWWxEYH","gAXPgjzIRA","TXAleTmWvT","qPlAQkwxRO","WgeQAqgbJJ","WjTkqAiTzl","xzmwgiAuHb","EIWxbTuAwk","YRvRJzHwAn","HATOJlbknA"}), 65);
	}

// END CUT HERE
}
