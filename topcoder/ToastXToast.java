
import java.util.*;

public class ToastXToast {
    public int bake(int[] ut, int[] ot) {
        Arrays.sort(ut);
        Arrays.sort(ot);
        
        if (ot[0] < ut[0] || ot[ot.length - 1] < ut[ut.length - 1])
        	return -1;
        if (ot[0] > ut[ut.length - 1])
        	return 1;
        return 2;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(ToastXToast.class, "test.*");
    }

	public void test0() {
		RETester.eq(bake(new int[] {2,4}, new int[] {5,6,3}), 2);
	}

	public void test1() {
		RETester.eq(bake(new int[] {5}, new int[] {4}), -1);
	}

	public void test2() {
		RETester.eq(bake(new int[] {1,2,3}, new int[] {5,6,7}), 1);
	}

	public void test3() {
		RETester.eq(bake(new int[] {1,3,5}, new int[] {2,4,6}), 2);
	}

// END CUT HERE
}
