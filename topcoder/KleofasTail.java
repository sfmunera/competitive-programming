import java.util.*;

public class KleofasTail {
    public long countGoodSequences(long K, long A, long B) {
        long res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(KleofasTail.class, "test.*");
    }

	public void test0() {
		RETester.eq(countGoodSequences(3L, 4L, 8L), 2L);
	}

	public void test1() {
		RETester.eq(countGoodSequences(1L, 23457L, 123456L), 100000L);
	}

	public void test2() {
		RETester.eq(countGoodSequences(1234567890123456L, 10L, 1000000L), 0L);
	}

	public void test3() {
		RETester.eq(countGoodSequences(0L, 0L, 2L), 3L);
	}

	public void test4() {
		RETester.eq(countGoodSequences(2L, 3L, 3L), 1L);
	}

	public void test5() {
		RETester.eq(countGoodSequences(13L, 12345L, 67890123L), 8387584L);
	}

// END CUT HERE
}
