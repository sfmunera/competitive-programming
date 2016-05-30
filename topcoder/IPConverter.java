
import java.util.*;

public class IPConverter {
	
	List<String> res;
	
	boolean valid(String ip) {
		String[] parts = ip.split("\\.");
		if (parts.length != 4)
			return false;
		for (int i = 0; i < parts.length; ++i) {
			if (parts[i].equals(""))
				return false;
			if (parts[i].length() > 1 && parts[i].charAt(0) == '0')
				return false;
			if (parts[i].length() > 3)
				return false;
			int oct = Integer.parseInt(parts[i]);
			if (oct > 255)
				return false;
		}
		return true;
	}
	
	void solve(String ip, int rem) {
		if (rem == 0) {
			if (valid(ip))
				res.add(ip);
			return;
		}
		
		int i = -1;
		for (int j = 0; j < ip.length(); ++j)
			if (ip.charAt(j) == '.')
				i = j;
		for (int j = 1; j <= 3; ++j)
			if (i + j < ip.length() - 1) {
				String newip = ip.substring(0, i + j + 1) + "." + ip.substring(i + j + 1);
				solve(newip, rem - 1);
			}
	}
	
    public String[] possibleAddresses(String ambiguousIP) {
        res = new ArrayList<String>();
        solve(ambiguousIP, 3);
        Collections.sort(res);
        
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); ++i)
        	ans[i] = res.get(i);
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(IPConverter.class, "test.*");
    }

	public void test0() {
		RETester.eq(possibleAddresses("1902426"), new String[] { "1.90.24.26",  "1.90.242.6",  "19.0.24.26",  "19.0.242.6",  "190.2.4.26",  "190.2.42.6",  "190.24.2.6" });
	}

	public void test1() {
		RETester.eq(possibleAddresses("000"), new String[] { });
	}

	public void test2() {
		RETester.eq(possibleAddresses(""), new String[] { });
	}

	public void test3() {
		RETester.eq(possibleAddresses("0186290"), new String[] { "0.18.62.90",  "0.186.2.90",  "0.186.29.0" });
	}

	public void test4() {
		RETester.eq(possibleAddresses("11111111"), new String[] { "1.1.111.111",  "1.11.11.111",  "1.11.111.11",  "1.111.1.111",  "1.111.11.11",  "1.111.111.1",  "11.1.11.111",  "11.1.111.11",  "11.11.1.111",  "11.11.11.11",  "11.11.111.1",  "11.111.1.11",  "11.111.11.1",  "111.1.1.111",  "111.1.11.11",  "111.1.111.1",  "111.11.1.11",  "111.11.11.1",  "111.111.1.1" });
	}

	public void test5() {
		RETester.eq(possibleAddresses("3082390871771742784899852251737850570843857369760"), new String[] { });
	}

	public void test6() {
		RETester.eq(possibleAddresses("256255255"), new String[] { "2.56.255.255",  "25.6.255.255",  "25.62.55.255" });
	}

// END CUT HERE
}
