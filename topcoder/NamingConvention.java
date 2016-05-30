import java.util.*;

public class NamingConvention {
    public String toCamelCase(String variableName) {
        String res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(NamingConvention.class, "test.*");
    }

	public void test0() {
		RETester.eq(toCamelCase("sum_of_two_numbers"), "sumOfTwoNumbers");
	}

	public void test1() {
		RETester.eq(toCamelCase("variable"), "variable");
	}

	public void test2() {
		RETester.eq(toCamelCase("t_o_p_c_o_d_e_r"), "tOPCODER");
	}

	public void test3() {
		RETester.eq(toCamelCase("the_variable_name_can_be_very_long_like_this"), "theVariableNameCanBeVeryLongLikeThis");
	}

// END CUT HERE
}
