
import java.util.*;

public class InternetSecurity {
	
	class Website {
		String address;
		Set<String> keywords = new HashSet<String>();
		
		public Website(String address) {
			this.address = address;
		}
	}
	
    public String[] determineWebsite(String[] address, String[] keyword, String[] dangerous, int threshold) {
        TreeMap<Integer, Website> safe = new TreeMap<Integer, Website>();
        TreeMap<Integer, Website> danger = new TreeMap<Integer, Website>();
        HashSet<String> bad = new HashSet<String>();
        
        for (int i = 0; i < address.length; ++i) {
        	String name = address[i];
        	safe.put(i, new Website(name));
        	String[] parts = keyword[i].split("[ ]+");
        	for (String key : parts)
        		safe.get(i).keywords.add(key);
        }
        
        for (String s : dangerous)
        	bad.add(s);
        
        boolean done = false;
        while (!done) {
        	done = true;
        	Set<Integer> toRemove = new HashSet<Integer>();
        	for (int i : safe.keySet()) {
        		Website w = safe.get(i);
        		int cnt = 0;
        		for (String k : w.keywords)
        			if (bad.contains(k))
        				++cnt;
        		if (cnt >= threshold) {
        			done = false;
        			toRemove.add(i);
        			danger.put(i, w);
        			for (String k : w.keywords)
        				bad.add(k);
        		}
        	}
        	for (int i : toRemove)
        		safe.remove(i);
        }
        if (danger.isEmpty())
        	return new String[]{};
        String[] ans = new String[danger.size()];
        int i = 0;
        for (Website w : danger.values())
        	ans[i++] = w.address;
        
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(InternetSecurity.class, "test.*");
    }

	public void test0() {
		RETester.eq(determineWebsite(new String[] {
			"www.topcoder.com",
			"www.sindicate_of_evil.com",
			"www.happy_citizens.com"},
			new String[] {
			"hack encryption decryption internet algorithm",
			"signal interference evil snake poison algorithm",
			"flower baloon topcoder blue sky sea"},
			new String[] {"hack","encryption","decryption","interference","signal","internet"}, 3), new String[] {"www.topcoder.com", "www.sindicate_of_evil.com" });
	}

	public void test1() {
		RETester.eq(determineWebsite(new String[] {"brokenlink","flowerpower.net","purchasedomain.com"}, new String[] {"broken","rose tulips","cheap free domain biggest greatest"}, new String[] {"biggest","enemy","hideout"}, 2), new String[] { });
	}

	public void test2() {
		RETester.eq(determineWebsite(new String[] {"a..a.ab.","...aa.b"}, new String[] {"a bc def","def ghij klmno"}, new String[] {"a","b","c","d","e"}, 1), new String[] {"a..a.ab.", "...aa.b" });
	}

	public void test3() {
		RETester.eq(determineWebsite(new String[] {"www.tsa.gov"}, new String[] {"information assurance signal intelligence research"}, new String[] {"signal","assurance","penguin"}, 2), new String[] {"www.tsa.gov" });
	}

// END CUT HERE
}
