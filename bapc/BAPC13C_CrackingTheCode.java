package bapc;

import java.util.*;

public class BAPC13C_CrackingTheCode {
	// mapping decrypted -> encrypted
	static Map<Character, Character> getMapping(String decrypted, String encrypted) {
		if (decrypted.length() != encrypted.length()) return null;
		
		Map<Character, Character> mapping = new HashMap<>();
		for (int i = 0; i < decrypted.length(); ++i) {
			char d = decrypted.charAt(i);
			char e = encrypted.charAt(i);
			if (!mapping.containsKey(d)) {
				mapping.put(d, e);
			} else {
				if (mapping.get(d) != e) return null;
			}
		}
		
		return transpose(mapping);
	}
	
	static Map<Character, Character> transpose(Map<Character, Character> mapping) {
		Map<Character, Character> mappingTranspose = new HashMap<Character, Character>();
		for (char k : mapping.keySet()) {
			char v = mapping.get(k);
			if (mappingTranspose.containsKey(v)) return null;
			mappingTranspose.put(v, k);
		}
		
		if (mappingTranspose.size() == 25) {
			for (char c = 'a'; c <= 'z'; ++c) {
				if (!mappingTranspose.containsKey(c)) {
					char missing = 'a';
					for (char c2 = 'a'; c2 <= 'z'; ++c2) {
						if (!mappingTranspose.values().contains(c2)) {
							missing = c2;
							break;
						}
					}
					mappingTranspose.put(c, missing);
					break;
				}
			}
		}
		
		return mappingTranspose;
	}
	
	static String decrypt(String encrypted, List<Map<Character, Character>> mappings) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < encrypted.length(); ++i) {
			char e = encrypted.charAt(i);
			char to = '?';
			for (Map<Character, Character> mapping : mappings) {
				if (!mapping.containsKey(e)) {
					to = '?';
					break;
				}
				if (to != '?' && to != mapping.get(e)) {
					to = '?';
					break;
				}
				to = mapping.get(e);
			}
			
			sb.append(to);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while (T-- > 0) {
			int n = in.nextInt();
			String[] encrypted = new String[n];
			
			for (int i = 0; i < n; ++i) {
				encrypted[i] = in.next();
			}
			
			String decrypted = in.next();
			String toDecrypt = in.next();
			
			List<Map<Character, Character>> mappings = new ArrayList<>();
			for (String e : encrypted) {
				Map<Character, Character> mapping = getMapping(decrypted, e);
				if (mapping != null) {
					mappings.add(mapping);
				}
			}
			
			if (mappings.isEmpty()) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(decrypt(toDecrypt, mappings));
			}
		}
		
		in.close();
		System.exit(0);
	}
}
