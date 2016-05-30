
import java.util.*;

public class Glossary {
	
	String padString(String s) {
		for (int i = s.length(); i < 19; ++i)
			s += " ";
		return s;
	}
	
    public String[] buildGlossary(String[] items) {
    	int N = items.length;
    	String spaces = "                   ";
    	String dashes = "-------------------";
    	
        Arrays.sort(items, new Comparator<String>() {
        	public int compare(String s1, String s2) {
        		return s1.toLowerCase().compareTo(s2.toLowerCase());
        	}
        });
        
        List<String> glossary = new ArrayList<String>();
        int k = 0;
        boolean changed = false;
        for (int i = 0; i < N; ++i) {
        	char c = Character.toUpperCase(items[i].charAt(0));
        	if (c <= 'M') {
        		glossary.add(padString("" + c));
        		++k;
        		glossary.add(dashes);
        		++k;
        	} else {
        		if (!changed) {
        			k = 0;
        			changed = true;
        		}
        		if (glossary.size() > k)
        			glossary.set(k, glossary.get(k) + "  " + padString("" + c));
        		else
        			glossary.add(k, spaces + "  " + padString("" + c));
        		++k;
        		if (glossary.size() > k)
        			glossary.set(k, glossary.get(k) + "  " + dashes);
        		else
        			glossary.add(k, spaces + "  " + dashes);
        		++k;
    		}
        	while (i < N && Character.toUpperCase(items[i].charAt(0)) == c) {
        		if (c <= 'M')
        			glossary.add(padString("  " + items[i]));
            	else {
            		if (glossary.size() > k)
            			glossary.set(k, glossary.get(k) + "  " + padString("  " + items[i]));
            		else
            			glossary.add(k, spaces + "  " + padString("  " + items[i]));
        		}
        		++k;
        		++i;
        	}
        	--i;
        	
        }
        String[] res = new String[glossary.size()];
        int i = 0;
        for (String s : glossary) {
        	if (s.length() < 2 * 19 + 2)
        		s += "  " + spaces;
    		res[i++] = s;
        }
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Glossary.class, "test.*");
    }

	public void test0() {
		RETester.eq(buildGlossary(new String[] {
			"Canada", "France", "Germany", "Italy", "Japan", "Russia", 
			"United Kingdom", "United States"}),
			new String[] {"C                    R                  ", "-------------------  -------------------", "  Canada               Russia           ", "F                    U                  ", "-------------------  -------------------", "  France               United Kingdom   ", "G                      United States    ", "-------------------                     ", "  Germany                               ", "I                                       ", "-------------------                     ", "  Italy                                 ", "J                                       ", "-------------------                     ", "  Japan                                 " });
	}

	public void test1() {
		RETester.eq(buildGlossary(new String[] {"alpha", "beta", "gamma", "delta", "omega"}), new String[] {"A                    O                  ", "-------------------  -------------------", "  alpha                omega            ", "B                                       ", "-------------------                     ", "  beta                                  ", "D                                       ", "-------------------                     ", "  delta                                 ", "G                                       ", "-------------------                     ", "  gamma                                 " });
	}

	public void test2() {
		RETester.eq(buildGlossary(new String[] {"AVL tree", "backtracking", "array", "balanced tree", "binary search"}), new String[] {"A                                       ", "-------------------                     ", "  array                                 ", "  AVL tree                              ", "B                                       ", "-------------------                     ", "  backtracking                          ", "  balanced tree                         ", "  binary search                         " });
	}

	public void test3() {
		RETester.eq(buildGlossary(new String[] {
			"XXXXXXXXXXXXXXXXX", 
			"YYYYYYYYYYYYYYYYY",
			"ZZZZZZZZZZZZZZZZZ"}),
			new String[] {"                     X                  ", "                     -------------------", "                       XXXXXXXXXXXXXXXXX", "                     Y                  ", "                     -------------------", "                       YYYYYYYYYYYYYYYYY", "                     Z                  ", "                     -------------------", "                       ZZZZZZZZZZZZZZZZZ" });
	}

	public void test4() {
		RETester.eq(buildGlossary(new String[] {
			"Asteria", "Astraeus", "Atlas", "Clymene", "Coeus", "Crius", 
			"Cronus", "Dione", "Epimetheus", "Helios", "Hyperion", "Iapetus", 
			"Leto", "Mnemosyne", "Oceanus", "Ophion", "Phoebe", "Prometheus", 
			"Rhea", "Tethys", "Theia", "Themis"}),
			new String[] {"A                    O                  ", "-------------------  -------------------", "  Asteria              Oceanus          ", "  Astraeus             Ophion           ", "  Atlas              P                  ", "C                    -------------------", "-------------------    Phoebe           ", "  Clymene              Prometheus       ", "  Coeus              R                  ", "  Crius              -------------------", "  Cronus               Rhea             ", "D                    T                  ", "-------------------  -------------------", "  Dione                Tethys           ", "E                      Theia            ", "-------------------    Themis           ", "  Epimetheus                            ", "H                                       ", "-------------------                     ", "  Helios                                ", "  Hyperion                              ", "I                                       ", "-------------------                     ", "  Iapetus                               ", "L                                       ", "-------------------                     ", "  Leto                                  ", "M                                       ", "-------------------                     ", "  Mnemosyne                             " });
	}

// END CUT HERE
}
